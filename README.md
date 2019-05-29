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
The Lexer, The Parser, Semantic Analysis, Code Generation (in three address code).

# Part 1: The Lexer
Lexical Analyzer Generator is <a href="https://github.com/antlr/antlr4">antlr4</a> and implementation in Java.

Inside Lexical Analyzer folder you can find:

-LexicalAnalyzer.g4 >> Contains the grammar for cool language.

-Lexer.java >> The implementation of how the code reads a file, go throw it and check each line to produce the tokens.

-Test Cases >> Both examples for bad & good test cases with extensions .cl

  For good examples >> you will get a file contains the line number and its tokens.
  (Ex: if file name is helloworld.cl then output will be helloworld.cl-lex)

  For bad examples>> you will get an error for invalid grammar.
