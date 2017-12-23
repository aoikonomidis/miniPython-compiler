
import java.io.*;
import minipython.lexer.Lexer;
import minipython.parser.Parser;
import minipython.node.*;
import java.util.*;

public class ParserTest {
  public static void main(String[] args) {
    try {
      Parser parser =
        new Parser(
        new Lexer(
        new PushbackReader(
        new FileReader(args[0].toString()), 1024)));

     Hashtable varTable =  new Hashtable();
     Hashtable funcTable =  new Hashtable();
     Hashtable valueTable=  new Hashtable();
     Hashtable returnFunctionTable=  new Hashtable();
     Start ast = parser.parse();
     ast.apply(new variableVisitor(varTable,valueTable));
	   ast.apply(new funcDefVisitor(funcTable,returnFunctionTable));
	   ast.apply(new funcCheckVisitor(funcTable));
     ast.apply(new typeCheckerVisitor(valueTable, returnFunctionTable));
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}

