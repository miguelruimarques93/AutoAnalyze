grammar aa;

//@header {
//
//package pt.up.fe.comp.aa.parser;
//
//}

stmt_list       : stmt*
                ;
stmt            : (attribution | operation | control_expr) (SEMICOLON | NL)
                ;
attribution     : IDENTIFIER EQUAL (operation | IDENTIFIER | STRING)
                ;
operation       : operator arg_list
                ;
control_expr    : IF OPEN_PR predicate CLOSE_PR OPEN_BR stmt_list CLOSE_BR (ELSE OPEN_BR stmt_list CLOSE_BR)?
                ;
arg_list        : (IDENTIFIER | OPEN_PR operation CLOSE_PR)*
                ;
predicate       : p_operator arg_list
                ;
p_operator      : EQUIVALENT
                | EQUALS
                | INCLUDED
                ; //possibly include NOT, AND and OR
operator        : p_operator
                | UNION
                | INTERSECTION
                | CARTESIAN_PRODUCT
                | DIFFERENCE
                | CLOSURE
                | COMPLEMENT
                | MINIMIZE
                | TO_DFA
                | ENFA_TO_NFA
                | TOTALIZE
                | REMOVE_UNREACHABLE
                | REMOVE_USELESS
                | WRITE_DOT
                | WRITE_REGEX
                | SHOW              //for graphic visualization of automata
                | PRINT
                | WRITE_CODE
                ;


UNION               : 'union';
INTERSECTION        : 'intersect';
CARTESIAN_PRODUCT   : 'cartesian';
DIFFERENCE          : 'diff';
CLOSURE             : 'closure';
COMPLEMENT          : 'complement';
MINIMIZE            : 'min';
TO_DFA              : 'to_dfa';
INCLUDED            : 'in';
EQUIVALENT          : 'equi';
EQUALS              : 'equals';
ENFA_TO_NFA         : 'remove_e'; //TODO rename
TOTALIZE            : 'totalize';
REMOVE_UNREACHABLE  : 'remove_unreachable';
REMOVE_USELESS      : 'remove_useless';
WRITE_DOT           : 'write_dot';
WRITE_REGEX         : 'write_regex';
WRITE_CODE          : 'write_code';
SHOW                : 'show';
PRINT               : 'print';

IDENTIFIER      : [_a-zA-Z][_a-zA-Z0-9'-']*;
STRING          : '"' .+? '"';
IF              : 'if';
ELSE            : 'else';
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
