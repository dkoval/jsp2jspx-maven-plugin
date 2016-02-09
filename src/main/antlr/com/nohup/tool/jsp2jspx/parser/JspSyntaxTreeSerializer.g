tree grammar JspSyntaxTreeSerializer;

options {
    tokenVocab = Jsp;
    ASTLabelType = Tree;
    rewrite = true;
}

@header {
    package com.nohup.tool.jsp2jspx.parser;
}

@members {
    private java.io.PrintStream out;

    public JspSyntaxTreeSerializer(TreeNodeStream input, java.io.PrintStream out) {
        super(input);
        this.out = out;
    }

    private void out(String text) {
        out.print(text);
    }
}

document
    : (
        child
        | t=PROCESSING_INSTRUCTION { out( "<?" + $t.text + "?>" ); }
        | t=DOCTYPE_DEFINITION { out( $t.text ); }
    )*
    ;

text
    : t=PCDATA { out( $t.text ); }
    | t=CDATA { out( "<![CDATA[" + $t.text + "]]>" ); }
    ;

element
    : ^( ELEMENT
            GENERIC_ID { out( "<" + $GENERIC_ID.text ); }
            ^( ATTRIBUTES ( { out( " " ); } attribute )* )
            (
                { out( ">" ); } child+ { out( "</" + $GENERIC_ID.text + ">" ); }
                | { out( "/>" ); }
               )
        )
    ;

child
    : element
    | text
    | comment
    ;

comment
    : t=COMMENT { out( "<!--" + $t.text + "-->" ); }
    ;

attribute
    : ^(
        ATTRIBUTE
        t=GENERIC_ID
        { out( $t.text + "=\"" ); }
        text*
        { out( "\"" ); }
    )
    ;
