grammar dot;

@header {

package pt.up.fe.comp.dot.parser;

}

graph       :   STRICT? (GRAPH | DIGRAPH) id? '{' stmt_list '}';
stmt_list   :   (stmt ';'?)* ;
stmt        :   node_stmt
            |   edge_stmt
            |   attr_stmt
            |   id '=' id
            |   subgraph;
attr_stmt   :   (GRAPH | NODE | EDGE) attr_list;
attr_list   :   ('[' a_list? ']')+;
a_list      :   (id '=' id ( ';' | ',' )?)+ ;
edgeop      :   '-' ('-'|'>') ;
edge_stmt   :   (lhs=node_id | subgraph) (edgeop (rhs=node_id | subgraph))+ attr_list?;
// edgeRHS     :   (edgeop (node_id | subgraph))+;
node_stmt   :   node_id attr_list?;
node_id     :   id port?;
port        :   ':' id ( ':' id )?;
subgraph    :   ( SUBGRAPH id? )? '{' stmt_list '}';
// compass_pt  :   ('n' | 'ne' | 'e' | 'se' | 's' | 'sw' | 'w' | 'nw' | 'c' | '_') ;
id          :   ID //alphabetic chars, '_', or digits (but can't start with a digit)
            |   NUMERAL // any number (can be negative or floating point)
            |   QUOTED_STRING //any double-quoted string ("...") possibly containing escaped quotes (\")
            |   HTML_STRING ; //html string (must be valid XML)

STRICT          :   [Ss][Tt][Rr][Ii][Cc][Tt] ;
GRAPH           :   [Gg][Rr][Aa][Pp][Hh] ;
DIGRAPH         :   [Dd][Ii][Gg][Rr][Aa][Pp][Hh] ;
NODE            :   [Nn][Oo][Dd][Ee] ;
EDGE            :   [Ee][Dd][Gg][Ee] ;
SUBGRAPH        :   [Ss][Uu][Bb][Gg][Rr][Aa][Pp][Hh] ;

ID              :   [_a-zA-Z\u0080-\u00FF][_0-9a-zA-Z\u0080-\u00FF]* ;
NUMERAL         :   '-'? ('.'[0-9]+ | [0-9]+ ('.'[0-9]*)? );
QUOTED_STRING   :   '"' ('\\"'|.)*? '"' ;
HTML_STRING     :   '<' ('<' .*? '>'|~[<>])* '>' ;

COMMENT         :   '/*' .*? '*/'       -> skip ;
LINE_COMMENT    :   '//' .*? '\r'? '\n' -> skip ;
PREPROC         :   '#' .*? '\n' -> skip ;

WS      : [ \t\r\n]+ -> skip ;

