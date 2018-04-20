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
    defclass|defvar|defun
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
    (Identifier '(' params ')' block)
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
	funtype Identifier '(' params ')' block
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
	variable'(' (expression (',' expression )*)? ')'
    ;

if_stmt
    :
	(If '(' expression ')' (stmt|block) )|
	(If '(' expression ')' (stmt|block) Else (stmt|block))
    ;

while_stmt
    :
	While '(' expression ')' (stmt|block)
    ;

for_stmt
    :
	For '(' (defvar|assignment) ';' (expression)? ';' (assignment|expression)? ')' (stmt|block)
    ;

return_stmt
    :
	Return expression? ';'
    ;

assignment
    :
	(variable '=' expression)
    ;

variable
    :
	Identifier|
	'(' variable ')'|
	variable '.' Identifier|
	variable ('[' expression ']')+
    ;

expression
    :
	term|
	callfun|
	'('expression')'|
	expression '.' callfun|
	expression '.' Identifier|
	expression '[' expression ']'|
	variable ('++'|'--')|
    ('++'|'--') variable|
	('-'|'!'|'~') expression|
	expression ('*'|'/'|'%') expression|
	expression ('+'|'-') expression|
	expression ('<<'|'>>') expression|
	expression ('>'|'>='|'<'|'<=') expression|
	expression ('=='|'!=') expression|	
	expression '&' expression|
	expression '^' expression|
	expression '|' expression|
	expression '&&' expression|
	expression '||' expression|
	expression '?' expression ':' expression|
	New vartype_plus ('(' (expression (',' expression)* )? ')')?
    ;

term
    :
	variable|
	literal
    ;

vartype_plus
    :
	basetype ('[' Integerliteral ']')*('[' ']')*
    ;

vartype
    :
	basetype ('[' ']')*
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

Identifier
    :
	LETTER
	(
	    NONDIGIT|
	    DIGIT
	)*
    ;
