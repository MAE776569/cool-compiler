import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.antlr.v4.runtime.*;

public class Lexer {

    public static void main(String[] args) throws Exception {

        if(args.length < 1) {
            System.err.println("No file is given!");
            return;
        }

        String inputFile = args[0];
        FileInputStream inputStream = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(inputStream);

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(input);
        Vocabulary vocabulary = lexicalAnalyzer.getVocabulary();
        StringBuilder output = new StringBuilder();

        for (Token token = lexicalAnalyzer.nextToken();
             token.getType() != Token.EOF;
             token = lexicalAnalyzer.nextToken()) {

            if(vocabulary.getSymbolicName(token.getType()).equals("INVALID")){
                System.out.printf("ERROR: line %d: Lexer: invalid character '%s'", token.getLine(), token.getText());
                return;
            }

            output.append(token.getLine());
            output.append('\n');
            String symbolicName = vocabulary.getSymbolicName(token.getType());
            output.append(symbolicName);
            output.append('\n');
            if (symbolicName.equals("ID") || symbolicName.equals("CLASSTYPE") || symbolicName.equals("STRING")){
                output.append(token.getText());
                output.append('\n');
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile + "-lex"));
        writer.write(output.toString());
        writer.close();
    }

}
