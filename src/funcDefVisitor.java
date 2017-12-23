import minipython.analysis.*;
import minipython.node.*;
import java.util.*;
import java.util.Arrays;


public class funcDefVisitor extends DepthFirstAdapter {
	private Hashtable symtable;	
	private Hashtable returnFunctionTable;

	funcDefVisitor(Hashtable symtable,  Hashtable returnFunctionTable) {
		this.symtable = symtable;
		this.returnFunctionTable =returnFunctionTable;
	}
	
	String func = null;//global variable to hold func names
	String arguments = null;
	//Definition
	public void inAFunctGoal1(AFunctGoal1 node) {
		
		HashMap argumentsInfo = new HashMap<String,Integer>();
		int line = ((TIdentifier) node.getIdentifier()).getLine()-1;
		argumentsInfo = findArgumentsInfo(node);
		String funcName = node.getIdentifier().toString().trim() + "-" + argumentsInfo.get("minimumRequiredArguments") + "_" + argumentsInfo.get("defaultArguments");
		
		func = node.getIdentifier().toString().trim();
		arguments = node.getArgument().toString();
		
		if (!alreadyCovered(funcName)) {
			symtable.put(funcName, node);
		} else {
			System.out.println("Line " + line + ": " + "Function " + node.getIdentifier().toString().trim() + " with " + argumentsInfo.get("minimumRequiredArguments") + " required and " + argumentsInfo.get("defaultArguments") +" default argument(s) is already covered!");
		}
	}
	
	public void caseAReturnStatement(AReturnStatement node) {
    	int strCounter=0, intCounter=0, idCounter=0;
		inAReturnStatement(node);
		 
		String exp = node.getExpression().toString(); //return expression
		
		String[] spltArgs = arguments.split("\\s");

		spltArgs[0] = spltArgs[0].replace("[", "");
		String[] argSplt = new String[spltArgs.length-1];
		for(int i=0; i<spltArgs.length-1; i++) {
			argSplt[i] = spltArgs[i];
		}
		
		String[] spltExp = exp.split("\\s");
		
		for(int i=0; i<spltExp.length; i++) {
			if (spltExp[i].startsWith("\""))
				strCounter++;
			if (Character.isDigit(spltExp[i].charAt(0)))
				intCounter++;
		}	

		if (strCounter>0 && intCounter>0) 
			System.out.println("\nCan't add integer with string\n");

		if (strCounter>0) 
			returnFunctionTable.put(func, "string");

		if (intCounter>0) 
			returnFunctionTable.put(func, "integer");

		int search;
		Arrays.sort(argSplt);
		Arrays.sort(spltExp);
		for(int i=0; i<argSplt.length; i++) {
			search = Arrays.binarySearch(spltExp, argSplt[i]);
			if (search >= 0) 
				idCounter++;
		}	

		if (idCounter == argSplt.length) 
			returnFunctionTable.put(func, "variables");

        if(node.getExpression() != null)
            node.getExpression().apply(this);

        outAReturnStatement(node);
		
       
    }
	
	public HashMap<String,Integer> findArgumentsInfo(AFunctGoal1 node) {
		
		int minimumRequiredArguments = 0;
		int defaultArguments = 0;
		LinkedList argumentList = node.getArgument();
		
		if (argumentList.size() == 1) {
			AArgument argument = (AArgument) argumentList.get(0);
			LinkedList value = argument.getValue();
			LinkedList idValues = argument.getIdValue();
			
			if (value.size() == 0) {
				minimumRequiredArguments++;
			} else {
				defaultArguments++;
			}
			
			for (int i = 0; i < idValues.size(); i++) {
				if (((AIdValue) idValues.get(i)).getValue().size() == 0) {
					minimumRequiredArguments++;
				} else {
					defaultArguments++;
				}
			}
		}
		
		HashMap argumentsInfo = new HashMap<String,Integer>();
		argumentsInfo.put("minimumRequiredArguments", minimumRequiredArguments);
		argumentsInfo.put("defaultArguments", defaultArguments);
		
		return argumentsInfo;
	}
	
	public boolean alreadyCovered(String funcName) {
		
		boolean covered = false;
		
		String name = funcName.substring(0, funcName.indexOf("-") - 1);
		int newMinimumRequiredArguments = Integer.valueOf(funcName.substring(funcName.indexOf("-") + 1, funcName.indexOf("_")));
		int newDefaultArguments = Integer.valueOf(funcName.substring(funcName.indexOf("_") + 1));
		
		int oldMinimumRequiredArguments = 0;
		int oldDefaultArguments = 0;
		
		Set<String> keySet = symtable.keySet();

		Iterator<String> iterator = keySet.iterator();
	
		String key;
	
		while (iterator.hasNext()) { 

			key = iterator.next();

			if (key.contains(name)) {
				oldMinimumRequiredArguments = Integer.valueOf(key.substring(key.indexOf("-") + 1, key.indexOf("_")));
				oldDefaultArguments = Integer.valueOf(key.substring(key.indexOf("_") + 1));
				
				if (newMinimumRequiredArguments + newDefaultArguments >= oldMinimumRequiredArguments &&		// newSum < oldRequired || newRequired > oldSum
						newMinimumRequiredArguments <= oldMinimumRequiredArguments + oldDefaultArguments) {
					covered = true;
					break;
				}
			}
		} 
		
		return covered;
	}
}