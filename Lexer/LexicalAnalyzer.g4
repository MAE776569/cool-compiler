lexer grammar LexicalAnalyzer;

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

CLASS: C L A S S;
INHERITS: I N H E R I T S;
SEMICOLON: ';';
OPENBRACKE: '{';
CLOSEBRACKE: '}';
ASSIGN: '<-';
COLON: ':';
COMMA: ',';
OPENPARENTHESES: '(';
CLOSEPARENTHESES: ')';
DOT: '.';
AT: '@';
INTCOMP: '~';
SELF: S E L F;
SELFTYPE: 'SELF_TYPE';
NEW: N E W;
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
EQUAL: '=';
LT: '<';
LTEQ: '<=';
NOT: N O T;
VARTYPE: 'Int' | 'String' | 'Bool';
TRUE: 'true';
FALSE: 'false';
STRING: '"' (('\\'|'\t'|'\r\n'|'\r'|'\n'|'\\"') | ~('\\'|'\t'|'\r'|'\n'|'"'))* '"';
IF: I F;
THEN: T H E N;
ELSE: E L S E;
FI: F I;
WHILE: W H I L E;
LOOP: L O O P;
POOL: P O O L;
CASE: C A S E;
OF: O F;
ESAC: E S A C;
LET: L E T;
IN: I N;
CASEASSIGN: '=>';
ISVOID: I S V O I D;
ID: [a-z_][a-zA-Z0-9_]*;
NUM: [0-9]+;
CLASSTYPE: [A-Z][a-zA-Z_0-9]*;
SINGLECOMMENT: '-'()*'-';
MULTICOMMENT: '*'()*'*';
WS: [ \n\t\r]+ -> skip;