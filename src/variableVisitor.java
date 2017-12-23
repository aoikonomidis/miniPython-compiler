import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class variableVisitor extends DepthFirstAdapter {
	private Hashtable symtable;
	private Hashtable valueTable;	

	variableVisitor(Hashtable symtable, Hashtable valueTable) {
		this.symtable = symtable;
		this.valueTable = valueTable;
	}
	
	//Definition
	public void outAAssignmentStatement(AAssignmentStatement node) {
		
		String varName = node.getIdentifier().toString();
		if (!symtable.containsKey(varName)) {
			symtable.put(varName, node);
			valueTable.put(varName, node.getExpression());
		}
	}
	
	//Definition
	public void inAArgument(AArgument node) {
		
		String varName = node.getIdentifier().toString();
		if (!symtable.containsKey(varName)) {
			symtable.put(varName, node);
		}
		
		LinkedList restVars = node.getIdValue();
		for (int i = 0; i < restVars.size(); i++) {
			varName = ((AIdValue) restVars.get(i)).getIdentifier().toString();
			if (!symtable.containsKey(varName)) {
				symtable.put(varName, node);
			}
		}
	}
	
	//Check
	public void inAForStatement(AForStatement node) {
		
		String varName1 = node.getId1().toString();
		String varName2 = node.getId2().toString();
		if (!symtable.containsKey(varName1)) {
			int line1 = ((TIdentifier) node.getId1()).getLine();
			System.out.println("Line " + line1 + ": " +"Variable " + varName1 + " is not defined!");
		}
		if (!symtable.containsKey(varName2)) {
			int line2 = ((TIdentifier) node.getId2()).getLine();
			System.out.println("Line " + line2 + ": " +"Variable " + varName2 + " is not defined!");
		}
	}
	
	//Check
	public void inAIdentifierExpression(AIdentifierExpression node) {
		
		String varName = node.getIdentifier().toString();
		if (!symtable.containsKey(varName)) {
			int line = ((TIdentifier) node.getIdentifier()).getLine();
			System.out.println("Line " + line + ": " +"Variable " + varName + " is not defined!");
		}
	}
}