grammar Jsp;

options {
    output = AST;
    rewrite = true;
}

tokens {
    ELEMENT;
    ATTRIBUTE;
    ATTRIBUTES;
    JSP_DIRECTIVE;
}

@header {
    package com.nohup.tool.jsp2jspx.parser;
}

@lexer::header {
    package com.nohup.tool.jsp2jspx.parser;
}

@lexer::members {
    private int tags;
    private enum Quote {NONE, SINGLE, DOUBLE};

    private Quote quote = Quote.NONE;
    private List<Integer> tagStack = new ArrayList<Integer>();
    private List<Quote> quoteStack = new ArrayList<Quote>();

    private void trim(int front, int back) {
        String text = getText();
        setText(text.substring(front, text.length() - back));
    }

    private boolean inTag() {
        return tags > 0;
    }

    private void pushTag() {
        tagStack.add(tags);
        tags = 0;
    }

    private void popTag() {
        tags = tagStack.remove(tagStack.size() - 1);
    }

    private void pushQuote() {
        quoteStack.add(quote);
        quote = Quote.NONE;
    }

    private void popQuote() {
        quote = quoteStack.remove(quoteStack.size() - 1);
    }
}

document
    : (
        child
        | PROCESSING_INSTRUCTION
        | DOCTYPE_DEFINITION
        | jspDirective
    ) *
    EOF!
    ;

child
    : element[false]
    | CDATA
    | PCDATA
    | COMMENT
    | jspLexicon
    ;


jspDirective
    : JSP_DIRECTIVE_OPEN name=GENERIC_ID (
        attributes+=attribute
    ) *
    JSP_DIRECTIVE_CLOSE
    -> ^( JSP_DIRECTIVE $name ^( ATTRIBUTES $attributes* ) )
    ;

jspLexicon
    : JSP_EXPRESSION
    | JSP_SCRIPTLET
    | JSP_COMMENT
    | EL_EXPR
    ;

element[boolean attributeAllowed]
    : r=startTag^ (
        TAG_CLOSE! ( (
            ( { attributeAllowed }?=> attribute )
            | child
        ) + endTag[$r.tagName]!
        | endTag[$r.tagName] )
        | TAG_EMPTY_CLOSE !
    )
    ;

startTag
    returns [ String tagName ]
    : TAG_START_OPEN name=GENERIC_ID (
        attributes+=attribute
        | attributes+=jspLexicon
        | attributes+=element[true]
    ) *
    { $tagName = $name.text; }
    -> ^( ELEMENT $name ^( ATTRIBUTES $attributes* ) )
    ;

attribute
    : name=GENERIC_ID ATTR_EQ ATTR_VALUE_OPEN (
        value+=attributeValue
    ) * ATTR_VALUE_CLOSE
    -> ^( ATTRIBUTE $name $value* )
    ;

attributeValue
    : PCDATA
    | element[false]
    | jspLexicon
    ;

endTag[ String tagName ]
    : t=TAG_END_OPEN name=GENERIC_ID { $name.text.equals( $tagName ) }? TAG_CLOSE
    -> CDATA[$t,""]
    ;

CDATA
    : '<![CDATA[' ( options { greedy = false; } : . )* ']]>' { trim( 9, 3 ); }
    ;

COMMENT
    : { ! inTag() }?=> '<!--' ( options { greedy = false; } : . )* '-->' { trim( 4, 3 ); }
    ;

TAG_START_OPEN
    : '<' { tags++; pushQuote(); }
    ;

TAG_END_OPEN
    : '</' { tags++; pushQuote(); }
    ;

TAG_CLOSE
    : { inTag() }?=> '>' { tags--; popQuote(); }
    ;

TAG_EMPTY_CLOSE
    : { inTag() }?=> '/>' { tags--; popQuote(); }
    ;

ATTR_EQ
    : { inTag() }?=> '=' ;

ATTR_VALUE_OPEN
    : { inTag() }?=> (
        { quote != Quote.DOUBLE }?=> '"' { quote = Quote.DOUBLE; }
        | { quote != Quote.DOUBLE }?=> '\'' { quote = Quote.SINGLE; }
      )
      { pushTag(); }
    ;

ATTR_VALUE_CLOSE
    : { ! inTag() }?=> (
          { quote == Quote.DOUBLE }?=> '"'
        | { quote == Quote.SINGLE }?=> '\''
    )
    { quote = Quote.NONE; popTag(); }
    ;

EL_EXPR
    : '${' ( options { greedy = false; } : . )* '}' { trim( 2, 1 ); }
    ;

PCDATA
    : { ! inTag() }?=> (
          { quote == Quote.NONE }?=> ~ ( '<' ) ( ~ ( '<' | '$' ) )*
        | { quote == Quote.DOUBLE }?=> ~ ( '<' | '"' ) ( ~ ( '<' | '$' | '"' ) )*
        | { quote == Quote.SINGLE }?=> ~ ( '<' | '\'' ) ( ~ ( '<' | '$' | '\'' ) )*
    )
    ;

GENERIC_ID
    : { inTag() }?=> ( LETTER | '_' | ':' ) ( NAMECHAR )*
    ;

fragment NAMECHAR : LETTER | DIGIT | '.' | '-' | '_' | ':' ;
fragment DIGIT : '0'..'9' ;
fragment LETTER : 'a'..'z' | 'A'..'Z' ;

WHITESPACE
    : { inTag() }?=> (' '|'\r'|'\t'|'\u000C'|'\n') { $channel = HIDDEN; }
    ;

PROCESSING_INSTRUCTION
    : { ! inTag() }?=> '<?' ( options { greedy = false; } : . )* '?>' { trim( 2, 2 ); }
    ;

DOCTYPE_DEFINITION
    : { ! inTag() }?=> '<!DOCTYPE' ( options { greedy = false; } : . )* '>'
    ;

JSP_DIRECTIVE_OPEN
    : { ! inTag() }?=> '<%@' { tags++; }
    ;

JSP_DIRECTIVE_CLOSE
    : { inTag() }?=> '%>' { tags--; }
    ;

JSP_COMMENT
    : '<%--' ( options { greedy = false; } : . )* '--%>' { trim( 4, 4 ); }
    ;

JSP_EXPRESSION
    : '<%=' ( options { greedy = false; } : . )* '%>' { trim( 3, 2 ); }
    ;

JSP_SCRIPTLET
    : '<%' ~( '@' | '=' | '-' ) ( options { greedy = false; } : . )* '%>' { trim( 2, 2 ); }
    ;
