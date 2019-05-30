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

  Here we define every production for COOL language, so we can apply these productions on the tokens we get from phase 1
  
  Also we get a name for every production rule to use it later in the code generation phase
  ```
  expr      : ID ASSIGN expr # assign
  ```
