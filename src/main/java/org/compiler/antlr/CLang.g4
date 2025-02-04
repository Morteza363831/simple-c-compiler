grammar CLang;

// Entry rule for the program
compilationUnit: (functionDeclaration | statement)* EOF;

// Function declaration with optional parameter list
functionDeclaration
    : typeSpecifier IDENTIFIER '(' parameterList? ')' block
    ;

parameterList
    : parameter (',' parameter)*
    ;

parameter
    : typeSpecifier IDENTIFIER
    ;

block
    : '{' statement* '}'
    ;

statement
    : expressionStatement
    | block
    | returnStatement
    | declarationStatement
    ;

declarationStatement
    : typeSpecifier IDENTIFIER ('=' expression)? ';'
    ;

expressionStatement
    : expression ';'
    ;

returnStatement
    : 'return' expression? ';'
    ;

expression
    : primary (operator primary)*
    ;

primary
    : IDENTIFIER
    | CONSTANT
    | '(' expression ')'
    ;

typeSpecifier
    : 'int' | 'float' | 'void'
    ;

operator
    : '+' | '-' | '*' | '/' | '='
    ;

// Lexer rules
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
CONSTANT: [0-9]+ ('.' [0-9]+)?;
WS: [ \t\r\n]+ -> skip;

PUNCTUATION: '{' | '}' | '(' | ')' | ',' | ';';
OPERATOR: '+' | '-' | '*' | '/' | '=';
