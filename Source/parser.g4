grammar Mx_star;

defclass
    :
	Class Identifier 
	'{'
	(defvar|defun)*
	(Identifier '(' Void? ')' block)?
	(defvar|defun)*
	'}'
    ;

defvar
    :
	(basetype Identifier ('=' expression)? ';')
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
	stmts
	'}'
    ;

stmts
    :
	stmt*
    ;

stmt
    :
	';'|
	defvar|
	assignment|
	callfun|
	(expression ';')|
	block|
	if_stmt|
	while_stmt|
	for_stmt|
	(Break ';')|
	(Continue ';')|
	(return_stmt)
    ;

callfun
    :
	variable'(' (expression ('(',expression')')*)? ')'
    ;

if_stmt
    :
	(If '(' expression ')' (stmt|block) )|
	(If '(' expreesion ')' (stmt|block) Else (stmt|block))
    ;

while_stmt
    :
	While '(' expression ')' (stmt|block)
    ;

for_stmt
    :
	For '(' (defvar|assignment) ';' (expression)? ';' assignment ')' (stmt|block)
    ;

return_stmt
    :
	Return expression ';'
    ;

assignment
    :
	(variable '=' expression)|
	(('++'|'--') variable)|
	(variable ('++'|'--'))

    ;

expression
    :
	term|
	callfun|
	('('expression')')|
	(('-'|'!'|'~') expreesion)|
	(expression ('*'|'/'|'%') expression)|
	(expression ('+'|'-') expression)|
	(expression ('<<'|'>>') expression)|
	(expression ('>'|'>='|'<'|'<=') expression)|
	(expression ('=='|'!=') expression)|	
	(expression '&' expression)|
	(expression '^' expression)|
	(expression '|' expression)|
	(expression '&&' expression)|
	(expression '||' expression)|
	(expression '?' expression ':' expression)|
	(New vartype_plus ('(' (expression (',' expression)* )? ')')?)
    ;

term
    :
	variable|
	literal
    ;

callfun
    :
	(variable'('')')|
	(variable'('expression')')|
	(variable'('expression (',' expression)+ ')')
    ;

variable
    :
	Identifier|
	(variable '.' Identifier)|
	(variable ('[' expression ']')+)
    ;

vartype_plus:
    :
	basetype (('[' Decimalliteral ']')*('[' ']')*)?
    ;

vartype_plus
    :
	basetype (('[' ']')*)?
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
	Decimalliteral
    ;

Identifier
    :
	LETTER
	(
	    Identifiernondigit|
	    DIGIT
	)*
    ;

Decimalliteral
    :
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
