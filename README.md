# cool-compiler
Compiler for cool programming language made using antlr as a course project for Compilers Course - 4th year, Computer Engineering Students.

# Team Memebrs:
Mohamed Ezzat

Mohamed Okasha

Mohammed Aref

Hassan Raafat

Abdelrahman Elsayed

Ahmed Mahmoud

# Main Parts
The Lexer, The Parser, Code Generation (in three address code).

# Part 1: The Lexer
Lexical Analyzer Generator is <a href="https://github.com/antlr/antlr4">antlr4</a> and implementation in Java.

Inside Lexical Analyzer folder you can find:

-LexicalAnalyzer.g4 >> Contains the grammar for cool language.

-Lexer.java >> The implementation of how the code reads a file, go throw it and check each line to produce the tokens.

-Test Cases >> Both examples for bad & good test cases with extensions .cl

  For good examples >> you will get a file contains the line number and its tokens.
  (Ex: if file name is helloworld.cl then output will be helloworld.cl-lex)

  For bad examples>> you will get an error for invalid grammar.
  We defined every single occurence for the COOL grammar as lexemes
  We started with letters as fragments
  
  ``` 
  fragment A : [aA];
  ```

  then we used these fragments to define the other lexemes that we use, so for example:
  class is considered as a 5 fragments piece of code
  ``` 
  CLASS: C L A S S;
  ```
  Note: here class lexeme is case-insensitive
  Constants and literal terminals is defined as
  
  ``` 
  ADD : '+';
  ```

# Part 2: Parser
  In this phase, we created a Parser to get the parse tree after we separated the tokens in phase 1. In the project's main folder you     will find a folder called src which contains a parsing.g4 file in which our parser grammar is written.

  -Here we define every production for COOL language, so we can apply these productions on the tokens we get from phase 1
  
  -Also we get a name for every production rule to use it later in the code generation phase
  ```
  expr      : ID ASSIGN expr # assign
  ```
# Phase 3: Three Address Code Generation
The most important part in this phase is to collect the information you need from your source code in order to generate the equivalent three address code for that source code.

There are multiple ways you can get the data you need, you can use Antlr visitors and listeners, or you can use the generated CST from Antlr parsers using Antlr's API. We prefered the visitors way where we can get the three address code for every production on its own.

This way is actually discussed in the Dragon Book.

The basic structure for Code Generation
  ```
  import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

    public class ParsingBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements ParsingVisitor<T> {

    private int n;

    @Override public T visitStart(ParsingParser.StartContext ctx) {
        n = 1;
        return visitChildren(ctx);
    }

    @Override public T visitEveryOtherProduction(ParsingParser.ClassDefContext ctx) { 
        return visitChildren(ctx);
    }
}
  ```
  ###### So let's explain what happens here

  we import the Visitor class for Antlr and extends our main ParsingBaseVisitor class to it

  we then declare the variable n which later will determine the temporary variables counter ( t1,t2,t3,...)

  at start production we assign 1 as a base value for temporary variables counter

  Start Production
  ``` 
  program   : classDefine+ # start
  ```
  After this we visit every other production and generate the code for it
  
  # Example

  Let's say we want to compile this simple COOL program
  ``` 
  class Main{
    main():Int{
        return 5 + 6;
    };
  }; 
  
  ``` 
  Running the CodeGen.java file

  After visiting the Start production we visit the Class definition for main class

  ```
  @Override public T visitClassDef(ParsingParser.ClassDefContext ctx) { 
    return visitChildren(ctx);
  }
  
  ```
  after that we find a stmt that matches the production expr mainly the # add one

  ```
  expr : expr ADD expr # add
  
  ```
  That evaluates to the Add visitor

  ```
  @Override public T visitAdd(ParsingParser.AddContext ctx) {
        String expr1Value = (String) visit(ctx.expr(0));
        String expr2Value = (String) visit(ctx.expr(1));
        System.out.printf("t%d = %s + %s\n", n, expr1Value, expr2Value);
        return (T) String.valueOf("t" + n++);
  }  
  
  ```
  Fregmenting this block to get what's inside

  -it defines two strings for both expressions in the production body and assigns them with the values that return from their visitors
  
  -later it prints the three address code for the add production from the three values of t (the currrent value and two values from the    return)
  
  -Finally it returns the current value then increments it for the later functions
  
  in step 1 we called the expression visitor and gets it seturn value so what does it exactly do?

  both expressions evaluates to the production num
  ```
  expr : NUM # num
  
  ```
  That evaluates to Num visitor where we get the number as a return value with the type T
  ```
    @Override public T visitNum(ParsingParser.NumContext ctx) {
        return (T) ctx.NUM().getText();
        
    }
    
   ```
   after returning those values to the Add visitor and resuming execution of the rest, you should see the word program printed.

    ```
      t1 = 5 + 6
      
    ```
   If you get errors, it might be one of those:

   Make sure you regenerate Antlr code recognizer each time you modify the grammar.
   Make sure you call parser.program() only once.
   Similarly, code generation for all other operators is done, by creating a new class for each expression that extends the expression      class (like visitAdd class above).
  
