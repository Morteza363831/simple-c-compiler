grammar CLang;

// Entry rule for the program
compilationUnit
    : (functionDeclaration | statement)* EOF
    ;

// Function declarations
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

// Statements
statement
    : expressionStatement
    | block
    | returnStatement
    | declarationStatement
    | printfStatement
    | ifStatement
    | whileStatement
    | forStatement
    ;

// Declaration statements
declarationStatement
    : typeSpecifier IDENTIFIER ('=' expression)? ';'
    | IDENTIFIER ('=' expression)? ';'
    ;

expressionStatement
    : expression ';'
    ;

returnStatement
    : 'return' expression? ';'
    ;

printfStatement
    : 'printf' '(' printfExpression (',' expression)* ')' ';'
    ;
printfExpression
    : STRING_LITERAL
    | CHAR_LITERAL
    | CONSTANT
    ;
// If-else structure
ifStatement
    : 'if' '(' comparisonExpression ')' statement ('else' statement)?
    ;

// While loop
whileStatement
    : 'while' '(' comparisonExpression ')' block
    ;

// For loop
forStatement
    : 'for' '(' forInit ';' comparisonExpression? ';' forUpdate? ')' block
    ;

forInit
    : typeSpecifier IDENTIFIER '=' expression
    ;

forUpdate
    : IDENTIFIER ('++' | '--')
    ;

// Comparison expression
comparisonExpression
    : expression comparisonOperator expression
    ;

// Expressions and operations
expression
    : primary (operator primary)*
    ;

primary
    : IDENTIFIER
    | CONSTANT
    | CHAR_LITERAL
    | STRING_LITERAL
    | '(' expression ')'
    ;

typeSpecifier
    : 'int' | 'float' | 'char' | 'void'
    ;

comparisonOperator
    : '<' | '>' | '<=' | '>=' | '==' | '!='
    ;

operator
    : '+' | '-' | '*' | '/' | '^'
    ;

// Lexer rules
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
CONSTANT: [0-9]+ ('.' [0-9]+)?;
CHAR_LITERAL: '\'' (ESC | ~['\\]) '\'';
STRING_LITERAL: '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' [btnfr"'\\];
WS: [ \t\r\n]+ -> skip;

PUNCTUATION: '{' | '}' | '(' | ')' | ',' | ';';
OPERATOR: '+' | '-' | '*' | '/' | '^';
COMPARISON: '<' | '>' | '<=' | '>=' | '==' | '!=';
