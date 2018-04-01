grammar Mx_star;

Stringliteral
    :
	Encodingprefix? '"' Schar* '"'
	| Encodingprefix? 'R' Rawstring
    ;

Integerliteral
    :
	Decimalliteral Integersuffix?
	| Octalliteral Integersuffix?
	| Hexadecimalliteral Integersuffix?
	| Binaryliteral Integersuffix?
    ;

Identifier
    :
	LETTER
	(
		Identifiernondigit
		| DIGIT
	)*
    ;

Decimalliteral
    :
	NONZERODIGIT
	(
		'\''? DIGIT
	)*
    ;

Octalliteral
    :
	'0'
	(
		'\''? OCTALDIGIT
	)*
    ;

Hexadecimalliteral
    :
	(
		'0x'
		| '0X'
	) HEXADECIMALDIGIT
	(
		'\''? HEXADECIMALDIGIT
	)*
    ;

Binaryliteral
    :
	(
		'0b'
		| '0B'
	) BINARYDIGIT
	(
		'\''? BINARYDIGIT
	)*
    ;

Integersuffix
    :
	Unsignedsuffix Longsuffix?
	| Unsignedsuffix Longlongsuffix?
	| Longsuffix Unsignedsuffix?
	| Longlongsuffix Unsignedsuffix?
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
OCTALDIGIT
    :
	[0-7]
    ;

fragment
HEXADECIMALDIGIT
    :
	[0-9a-fA-F]
    ;

fragment
BINARYDIGIT
    :
	[01]
    ;

fragment
Unsignedsuffix
    :
	[uU]
    ;

fragment
Longsuffix
    :
	[lL]
    ;

fragment
Longlongsuffix
    :
	'll'
	| 'LL'
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
Encodingprefix
    :
	'u8'
	| 'u'
	| 'U'
	| 'L'
    ;

fragment
Schar
    :
	~["\\\r\n]
	| Escapesequence
	| Universalcharactername
    ;

fragment
Escapesequence
:
	Simpleescapesequence
	| Octalescapesequence
	| Hexadecimalescapesequence
;

fragment
Simpleescapesequence
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

fragment
Octalescapesequence
:
	'\\' OCTALDIGIT
	| '\\' OCTALDIGIT OCTALDIGIT
	| '\\' OCTALDIGIT OCTALDIGIT OCTALDIGIT
;

fragment
Hexadecimalescapesequence
:
	'\\x' HEXADECIMALDIGIT+
;

fragment
Rawstring /* '"' dcharsequence? '(' rcharsequence? ')' dcharsequence? '"' */
    :
	'"' .*? '(' .*? ')' .*? '"'
    ;

fragment
Universalcharactername
:
	'\\u' Hexquad
	| '\\U' Hexquad Hexquad
;

fragment
Hexquad
:
	HEXADECIMALDIGIT HEXADECIMALDIGIT HEXADECIMALDIGIT HEXADECIMALDIGIT
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

