grammar dot;

graph       :	(STRICT)? (GRAPH | DIGRAPH) (ID)? '{' stmt_list '}';
stmt_list	:	(stmt ';'?)* ;
stmt	    :	node_stmt
            |	edge_stmt
            |	attr_stmt
            |	ID '=' ID
            |	subgraph;
attr_stmt	:	(GRAPH | NODE | EDGE) attr_list;
attr_list	:	'[' ( a_list )? ']' (attr_list)?;
a_list	    :	ID '=' ID ( (';' | ',') )? ( a_list )?;
edgeop      :   '-' ('-'|'>') ;
edge_stmt	:	(node_id | subgraph) edgeRHS (attr_list)?;
edgeRHS	    :	edgeop (node_id | subgraph) (edgeRHS)?;
node_stmt	:	node_id ( attr_list )?;
node_id	    :	ID ( port )?;
port	    :	':' ID ( ':' compass_pt )?
		    |	':' compass_pt;
subgraph	:	( SUBGRAPH ( ID )? )? '{' stmt_list '}';
compass_pt	:	('n' | 'ne' | 'e' | 'se' | 's' | 'sw' | 'w' | 'nw' | 'c' | '_') ;

STRICT      :   [Ss][Tt][Rr][Ii][Cc][Tt] ;
GRAPH       :   [Gg][Rr][Aa][Pp][Hh] ;
DIGRAPH     :   [Dd][Ii][Gg][Rr][Aa][Pp][Hh] ;
NODE        :   [Nn][Oo][Dd][Ee] ;
EDGE        :   [Ee][Dd][Gg][Ee] ;
SUBGRAPH    :   [Ss][Uu][Bb][Gg][Rr][Aa][Pp][Hh] ;
ID  : 'ABC';

COMMENT     :   '/*' .*? '*/'       -> skip ;
LINE_COMMENT:   '//' .*? '\r'? '\n' -> skip ;
PREPROC     :   '#' .*? '\n' -> skip ;

WS        : [ \t\r\n]+ -> skip ;

