import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class funcCheckVisitor extends DepthFirstAdapter {
	private Hashtable symtable;	

	funcCheckVisitor(Hashtable symtable) {
		this.symtable = symtable;
	}
	
	//Check
	public void inAFunctionCall(AFunctionCall node) {
		
		HashMap checks = new HashMap<String,Boolean>();
		checks = doChecks(node);
		
		String funcName = node.getIdentifier().toString().trim();
		int line = ((TIdentifier) node.getIdentifier()).getLine();
		if (!((boolean) checks.get("functionNameExists") && (boolean) checks.get("functionCallCovered"))) {
			if (!(boolean) checks.get("functionNameExists")) {
				System.out.println("Line " + line + ": " + "Function " + funcName + " is not defined!");
			} else if (!(boolean) checks.get("functionCallCovered")) {
				System.out.println("Line " + line + ": " + "No appropriate overloaded version of function " + funcName + " was found!");
			}
			
			return;
		}
	}
	
	public HashMap<String,Boolean> doChecks(AFunctionCall node) {
		
		boolean functionNameExists = false;
		boolean functionCallCovered = false;
		
		String funcName = node.getIdentifier().toString().trim();
		
		Set<String> keySet = symtable.keySet();
		Iterator<String> iterator = keySet.iterator();
		String key;
		int numberOfArguments = 0;
		int minimumRequiredArguments = 0;
		int defaultArguments = 0;
		
		LinkedList nodeArguments = node.getArgList();
		
		if (nodeArguments.size() == 1) {
			AArgList argList = (AArgList) nodeArguments.get(0);
			numberOfArguments = ((LinkedList) argList.getR()).size() + 1;
		}
		
		while (iterator.hasNext()) { 
			key = iterator.next();
			
			if (key.contains(funcName)) {
				if (!functionNameExists) {
					functionNameExists = true;
				}
				
				minimumRequiredArguments = Integer.valueOf(key.substring(key.indexOf("-") + 1, key.indexOf("_")));
				defaultArguments = Integer.valueOf(key.substring(key.indexOf("_") + 1));
				
				if (numberOfArguments >= minimumRequiredArguments && numberOfArguments <= minimumRequiredArguments + defaultArguments) {
					functionCallCovered = true;
					break;
				}
			}
		}
		
		HashMap checks = new HashMap<String,Boolean>();
		checks.put("functionNameExists", functionNameExists);
		checks.put("functionCallCovered", functionCallCovered);
		
		return checks;
	}
}