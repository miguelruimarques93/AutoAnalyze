grammar aa;

@header {

package pt.up.fe.comp.aa.parser;

}

stmt_list       : stmt*
                ;
stmt            : (((attribution | operation) (SEMICOLON | EOF)) | control_expr)
                ;
attribution     : attribution_lhs EQUAL attribution_rhs
                ;
attribution_lhs : IDENTIFIER
                ;
attribution_rhs : IDENTIFIER
                | operation
                | STRING
                ;
operation       : operator=IDENTIFIER arg_list
                ;

IF              : 'if';
ELSE            : 'else';

control_expr    : IF OPEN_PR predicate=operation CLOSE_PR OPEN_BR trueCase=stmt_list CLOSE_BR (ELSE OPEN_BR falseCase=stmt_list CLOSE_BR)?
                ;
arg_list        : arg*
                ;
arg             : IDENTIFIER
                | STRING
                | OPEN_PR operation CLOSE_PR
                ;

IDENTIFIER      : [_a-zA-Z][_a-zA-Z0-9-]*;
STRING          : '"' .*? '"';
OPEN_PR         : '(';
CLOSE_PR        : ')';
OPEN_BR         : '{';
CLOSE_BR        : '}';
EQUAL           : '=';
SEMICOLON       : ';';

WS              : [ \t\r\n]+ -> skip;
COMMENT         :   '/*' .*? '*/'       -> skip;
LINE_COMMENT    :   '//' .*? '\r'? '\n' -> skip;
