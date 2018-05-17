grammar Mx_star;

@header {
package com.lmxyy.mxcompiler.parser;
}

prog
    :
	progsec*
    ;

progsec
    :
    defclass|defvar ';'|defun
    ;

defclass
    :
	Class Identifier 
	'{'
	classmem*
	constructor?
	classmem*
	'}'
    ;

constructor
    :
	Inline? (Identifier '(' params ')' block)
    ;

classmem
    :
    defvar ';'|defun
    ;

defvar
    :
	(vartype defvarassignment)(',' defvarassignment)*
    ;

defvarassignment
    :
    Identifier ('=' expression)?
    ;

defun
    :
	Inline? funtype Identifier '(' params ')' block
    ;

params
    :
	(Void?)|
	(vartype Identifier (',' vartype Identifier)*)|
    ;

block
    :
	'{'
	stmt*
	'}'
    ;

stmt
    :
	defvar ';'|
	assignment ';'|
	expression ';'|
	block|
	if_stmt|
	while_stmt|
	for_stmt|
	(Break ';')|
	(Continue ';')|
	(return_stmt)|
	';'
    ;

callfun
    :
	Identifier'(' (expression (',' expression )*)? ')'
    ;

stmtorblock
    :
    stmt|block
    ;

if_stmt
    :
	If '(' expression ')' stmtorblock|
	If '(' expression ')' stmtorblock Else stmtorblock
    ;

while_stmt
    :
	While '(' expression ')' stmtorblock
    ;

for_stmt
    :
	For '(' forinit? ';' expression? ';' forstep? ')' stmtorblock
    ;

expressionorassignment
    :
    (expression|assignment)
    ;

forinit
    :
    defvar|expressionorassignment (',' expressionorassignment)*
    ;
forstep
    :
    expressionorassignment (',' expressionorassignment)*
    ;

return_stmt
    :
	Return expression? ';'
    ;

assignment
    :
	(expression '=' expression)
    ;

variable
    :
	This|
	Identifier|
	'(' variable ')'|
	variable '.' Identifier|
	variable '[' expression ']'
    ;

term
    :
	variable|
	literal
    ;

expression
    :
	term|
	callfun|
	lefpar expression rigpar|
	expression mem callfun|
	expression mem Identifier|
	expression lefbra expression rigbra|
	variable (sinc|sdec)|
	(pinc|pdec) variable|
	(neg|not|comp) expression|
	New vartype_plus ( lefpar (expression (',' expression)* )? rigpar)?|
	expression (times|divide|mod) expression|
	expression (add|sub) expression|
	expression (lesh|rish) expression|
	expression (grtr|geq|less|leq) expression|
	expression (equ|neq) expression|
	expression band expression|
	expression xor expression|
	expression bor expression|
	expression and expression|
	expression or expression|
	expression que expression ':' expression
    ;

lefpar: '(' ;
rigpar: ')' ;
mem: '.' ;
lefbra: '[' ;
rigbra: ']' ;
sinc: '++' ;
sdec: '--' ;
pinc: '++' ;
pdec: '--';
neg: '-' ;
not: '!' ;
comp: '~' ;
times: '*' ;
divide: '/' ;
mod: '%' ;
add: '+' ;
sub: '-' ;
lesh: '<<' ;
rish: '>>' ;
less: '<' ;
grtr: '>' ;
leq: '<=' ;
geq: '>=' ;
equ: '==' ;
neq: '!=' ;
band: '&' ;
xor: '^' ;
bor: '|' ;
and: '&&' ;
or: '||' ;
que: '?' ;

vartype_plus
    :
	basetype (lefbra expression rigbra)*(lefbra rigbra)*
    ;

vartype
    :
	basetype (lefbra rigbra)*
    ;

basetype
    :
	Int|
	String|
	Bool|
	Identifier
    ;

funtype
    :
	vartype|
	Void
    ;

literal
    :
	Integerliteral|
	Stringliteral|
	Booleanliteral|
	Null
    ;

Booleanliteral
    :
	False|
	True
    ;

Stringliteral
    :
	 '"' Schar* '"'
    ;

Integerliteral
    :
	'0'|
    NONZERODIGIT
    (
    	'\''? DIGIT
    )*
    ;

// --------------------------------------------------Skip Tokens--------------------------------------------------
Whitespace
:
	[ \t]+ -> skip
;

Newline
:
	(
		'\r' '\n'?
		| '\n'
	) -> skip
;

BlockComment
:
	'/*' .*? '*/' -> skip
;

LineComment
:
	'//' ~[\r\n]* -> skip
;


// --------------------------------------------------Fragments--------------------------------------------------

fragment
NONZERODIGIT
    :
	[1-9]
    ;

fragment
NONDIGIT
    :
	[a-zA-Z_]
    ;

fragment
LETTER
    :
	[a-zA-Z]
    ;

fragment
DIGIT
    :
	[0-9]
    ;

fragment
Schar
    :
	~["\\\r\n]
	| Escapesequence
    ;

fragment
Escapesequence
    :
	'\\\''
	| '\\"'
	| '\\?'
	| '\\\\'
	| '\\a'
	| '\\b'
	| '\\f'
	| '\\n'
	| '\\r'
	| '\\t'
	| '\\v'
    ;

// --------------------------------------------------Key Words--------------------------------------------------
Int
    :
	'int'
    ;

Bool
    :
	'bool'
    ;

String
    :
	'string'
    ;

Null
    :
	'null'
    ;

Void
    :
	'void'
    ;

True
    :
	'true'
    ;

False
    :
	'false'
    ;

If
    :
	'if'
    ;

Else
    :
	'else'
    ;

For
    :
	'for'
    ;

While
    :
	'while'
    ;

Break
    :
	'break'
    ;

Continue
    :
	'continue'
    ;

Return
    :
	'return'
    ;

New
    :
	'new'
    ;

Class
    :
	'class'
    ;

This
    :
	'this'
    ;

Inline
    :
	'inline'
    ;

Identifier
    :
	LETTER
	(
	    NONDIGIT|
	    DIGIT
	)*
    ;









