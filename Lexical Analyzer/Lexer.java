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
	lexicalAnalyzer.removeErrorListeners();
        lexicalAnalyzer.addErrorListener(new Error());
        Vocabulary vocabulary = lexicalAnalyzer.getVocabulary();
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile + "-lex"));

        for (Token token = lexicalAnalyzer.nextToken();
             token.getType() != Token.EOF;
             token = lexicalAnalyzer.nextToken()) {

            writer.append(String.valueOf(token.getLine()));
            writer.newLine();
            String symbolicName = vocabulary.getSymbolicName(token.getType());
            writer.append(symbolicName);
            writer.newLine();
            if (symbolicName.equals("ID") || symbolicName.equals("CLASSTYPE") || symbolicName.equals("STRING")){
                writer.append(token.getText());
                writer.newLine();
            }
        }

        writer.close();
    }
}