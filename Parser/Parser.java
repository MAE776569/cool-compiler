import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;

public class Parser {

    public static void main(String[] args) throws Exception {

        /*if(args.length < 1) {
            System.err.println("No file is given!");
            return;
        }

        String inputFile = args[0];*/
        FileInputStream inputStream = new FileInputStream("hello-cst.cl");
        ANTLRInputStream input = new ANTLRInputStream(inputStream);
        Lexer2 lexer = new Lexer2(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParsingParser parser = new ParsingParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new Error());
        ParseTree tree = parser.program();
        BufferedWriter writer = new BufferedWriter(new FileWriter("hello" + "-cst"));
        writer.write(tree.toStringTree(parser));
        writer.close();

    }
}
