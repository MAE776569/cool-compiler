grammar Parsing;

import Lexer2;

program   : classDefine+ # start
          ;
classDefine     : CLASS TYPE (INHERITS TYPE)? OPENBRACE (feature SEMICOLON)* CLOSEBRACE SEMICOLON # classDef
          ;
feature   : ID OPENPARENTHESES (parameter (COMMA parameter)*)? CLOSEPARENTHESES COLON TYPE OPENBRACE expr CLOSEBRACE # function
          | ID COLON TYPE (ASSIGN expr )? # varDef
          ;
parameter : ID COLON TYPE # param;
expr      : ID ASSIGN expr # assign
          | expr(AT TYPE)? DOT ID OPENPARENTHESES ( expr (COMMA expr)*)? CLOSEPARENTHESES # objectCall
          | ID OPENPARENTHESES  expr ( expr (COMMA expr)*)? CLOSEPARENTHESES # staticCall
          | IF expr THEN expr ELSE expr FI # if
          | WHILE expr LOOP expr POOL # while
          | OPENBRACE (expr SEMICOLON)+ CLOSEBRACE  # block
          | LET ID COLON TYPE ( ASSIGN expr )? (COMMA ID COLON TYPE ( ASSIGN expr )?)* IN expr # let
          | CASE expr OF (ID COLON TYPE CASEASSIGN expr SEMICOLON )+ ESAC # switch
          | NEW TYPE # newObject
          | ISVOID expr # void
          | expr MUL expr # mul
          | expr DIV expr # div
          | expr ADD expr # add
          | expr SUB expr # sub
          | INTCOMP expr # invert
          | expr LT expr # lt
          | expr LTEQ expr # lteq
          | expr EQUAL expr # equal
          | NOT expr # not
          | OPENPARENTHESES expr CLOSEPARENTHESES # factExpr
          | STRING # string
          | NUM # num
          | ID # id
          | TRUE # true
          | FALSE # false
          ;

