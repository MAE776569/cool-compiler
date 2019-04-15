import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;

import org.antlr.v4.runtime.*;

public class Lexer {

    public static void main(String[] args) throws Exception {

        if(args.length < 1) {
            System.err.println("No file is given");
            System.exit(1);
        }

        String inputFile = args[0];
        FileInputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(input);
        //CommonTokenStream tokenStream = new CommonTokenStream(lexicalAnalyzer);
        //Vocabulary vocabulary = lexicalAnalyzer.getVocabulary();
        //tokenStream.fill();
        //System.out.println(tokenStream.getTokens());
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile + "-lex"));
        for (Token token = lexicalAnalyzer.nextToken();
             token.getType() != Token.EOF;
             token = lexicalAnalyzer.nextToken()) {

            if(token.getType() == Token.INVALID_TYPE){
                System.out.printf("ERROR: line %i: Lexer: invalid token %s", token.getLine(),token.getText());
                writer.close();
                return;
            }

            writer.write(String.valueOf(token.getLine()) + '\n');
            writer.write(String.valueOf(token.getText()) + '\n');
            //writer.write(String.valueOf(lexicalAnalyzer.getVocabulary().getSymbolicName()));


        }
        writer.close();
        /*for (int i = 0; i < tokenStream.size(); ++i){
            writer.write(String.valueOf(tokenStream.get(i).getLine()) + '\n');
            writer.write(String.valueOf(tokenStream.get(i).getText()) + '\n');
            writer.write(String.valueOf(vocabulary.getSymbolicName(i)));
        }*/
    }

}
