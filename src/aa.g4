grammar aa;

@header {

package pt.up.fe.comp.aa.parser;

}

stmt_list       : (stmt (SEMICOLON | NL))* stmt?
                ;
stmt            : (attribution | operation | control_expr)
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

control_expr    : IF OPEN_PR predicate=operation CLOSE_PR OPEN_BR trueCase=stmt_list CLOSE_BR (NL? ELSE OPEN_BR falseCase=stmt_list CLOSE_BR)?
                ;
arg_list        : arg*
                ;
arg             : IDENTIFIER
                | STRING
                | OPEN_PR operation CLOSE_PR
                ;


// UNION               : 'union';
// INTERSECTION        : 'intersect';
// CARTESIAN_PRODUCT   : 'cartesian';
// DIFFERENCE          : 'diff';
// CLOSURE             : 'closure';
// COMPLEMENT          : 'complement';
// MINIMIZE            : 'min';
// TO_DFA              : 'to_dfa';
// INCLUDED            : 'in';
// EQUIVALENT          : 'equi';
// EQUALS              : 'equals';
// ENFA_TO_NFA         : 'remove_e'; //TODO rename
// TOTALIZE            : 'totalize';
// REMOVE_UNREACHABLE  : 'remove_unreachable';
// REMOVE_USELESS      : 'remove_useless';
// WRITE_DOT           : 'write_dot';
// WRITE_REGEX         : 'write_regex';
// WRITE_CODE          : 'write_code';
// SHOW                : 'show';
// PRINT               : 'print';

IDENTIFIER      : [_a-zA-Z][_a-zA-Z0-9-]*;
STRING          : '"' .+? '"';
OPEN_PR         : '(';
CLOSE_PR        : ')';
OPEN_BR         : '{';
CLOSE_BR        : '}';
EQUAL           : '=';
SEMICOLON       : ';';
NL              : '\n';

WS              : [ \t\r\n]+ -> skip;
COMMENT         :   '/*' .*? '*/'       -> skip;
LINE_COMMENT    :   '//' .*? '\r'? '\n' -> skip;
