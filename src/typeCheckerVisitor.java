
import minipython.analysis.*;
import minipython.node.*;
import java.util.*;

public class typeCheckerVisitor extends DepthFirstAdapter {
	private Hashtable valueTable;
    private Hashtable returnFunctionTable;

    public AIntegerLiteralValue intVal;
    public AStringValueValue strVal;

	typeCheckerVisitor(Hashtable valueTable, Hashtable returnFunctionTable) {
		this.valueTable = valueTable;
        this.returnFunctionTable = returnFunctionTable;
	}

	public void outAValueExpression(AValueExpression node) {
    	setIn(node,node.getValue());      
    }

    public void outAIdentifierExpression(AIdentifierExpression node) {
    	
    	String varName = node.getIdentifier().toString();
		if (valueTable.containsKey(varName)) {
		
			AValueExpression temp = (AValueExpression) valueTable.get(varName);

			setIn(node, temp.getValue());
		}
    }

    public void outAFunctionCallExpression(AFunctionCallExpression node) {
    	String func = node.getFunctionCall().toString();
        String[] funcSplt = func.split("\\s");
        
        String str = returnFunctionTable.get(funcSplt[0]).toString();

        if (str.equals("integer")) 
            setIn(node, intVal);

        if (str.equals("string"))
            setIn(node, strVal);

        if (str.equals("variables")) {
            int int_counter = 0, str_counter = 0;
            for (int i=1; i<funcSplt.length; i++) {
                if (funcSplt[i].startsWith("\""))
                    str_counter++;
                if (Character.isDigit(funcSplt[i].charAt(0)))
                    int_counter++;
            }

            if (str_counter == funcSplt.length-1)
                setIn(node, strVal);
            if (int_counter == funcSplt.length-1)
                setIn(node, intVal);

            if (str_counter>0 && int_counter>0)
                System.out.println("\nCan't add/sub/mul/div string with integer\n");
        }
    }

    public void inAIntegerLiteralValue(AIntegerLiteralValue node) {
        intVal = node;
    }

    public void inAStringValueValue(AStringValueValue node) {
        strVal = node;
    }

	public void caseAAddExpression(AAddExpression node) {	
    	inAAddExpression(node);
        if (node.getL() != null) {
            node.getL().apply(this);
        }
        if (node.getR() != null) {
            node.getR().apply(this);
        }

		if (getIn(node.getL()) != null && getIn(node.getR()) != null) {
            Object ltype = getIn(node.getL()).getClass();
            Object rtype = getIn(node.getR()).getClass();
                
            if(!(ltype.equals(rtype))) {
                System.out.println("\nCan't add string with integer\n");
            }
            setIn(node, getIn(node.getL()));
            setIn(node.getL(),null);
            setIn(node.getR(),null);
        }
        outAAddExpression(node);
    }

	

    public void caseASubExpression(ASubExpression node) {
        inASubExpression(node);
        if (node.getL() != null) {
            node.getL().apply(this);
        }
        if (node.getR() != null) {
            node.getR().apply(this);
        }
        if (getIn(node.getL()) != null && getIn(node.getR()) != null) {
            Object ltype = getIn(node.getL()).getClass();
            Object rtype = getIn(node.getR()).getClass();
           
    	    if (!(ltype.equals(rtype))) {
            	System.out.println("\nCan't sub string with integer\n");
            }

            setIn(node, getIn(node.getL()));
    	    setIn(node.getL(),null);
    	    setIn(node.getR(),null);
        }
        outASubExpression(node);
    }

    public void caseAMulExpression(AMulExpression node) {
        inAMulExpression(node);
        if (node.getL() != null) {
            node.getL().apply(this);
        }
        if (node.getR() != null) {
            node.getR().apply(this);
        }
        if (getIn(node.getL()) != null && getIn(node.getR()) != null) {
            Object ltype = getIn(node.getL()).getClass();
            Object rtype = getIn(node.getR()).getClass();
           
    	    if (!(ltype.equals(rtype))) {
            	System.out.println("\nCan't mul string with integer\n");
            }
			setIn(node, getIn(node.getL()));
		    setIn(node.getL(),null);
		    setIn(node.getR(),null);
        }
        outAMulExpression(node);
    }

    public void caseADivExpression(ADivExpression node) {
        inADivExpression(node);
        if (node.getL() != null) {
            node.getL().apply(this);
        }
        if (node.getR() != null) {
            node.getR().apply(this);
        }
        if (getIn(node.getL()) != null && getIn(node.getR()) != null) {
            Object ltype = getIn(node.getL()).getClass();
            Object rtype = getIn(node.getR()).getClass();
           
    	    if (!(ltype.equals(rtype))) {
            	System.out.println("\nCan't div string with integer\n");
            }
    		setIn(node, getIn(node.getL()));
    	    setIn(node.getL(),null);
    	    setIn(node.getR(),null);        
        }
        outADivExpression(node);
    }
}

