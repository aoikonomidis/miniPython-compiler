/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.analysis;

import java.util.*;
import minipython.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable in;
    private Hashtable out;

    public Object getIn(Node node)
    {
        if(in == null)
        {
            return null;
        }

        return in.get(node);
    }

    public void setIn(Node node, Object in)
    {
        if(this.in == null)
        {
            this.in = new Hashtable(1);
        }

        if(in != null)
        {
            this.in.put(node, in);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(out == null)
        {
            return null;
        }

        return out.get(node);
    }

    public void setOut(Node node, Object out)
    {
        if(this.out == null)
        {
            this.out = new Hashtable(1);
        }

        if(out != null)
        {
            this.out.put(node, out);
        }
        else
        {
            this.out.remove(node);
        }
    }
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAGoal(AGoal node)
    {
        defaultCase(node);
    }

    public void caseAFunctGoal1(AFunctGoal1 node)
    {
        defaultCase(node);
    }

    public void caseAStatGoal1(AStatGoal1 node)
    {
        defaultCase(node);
    }

    public void caseAArgument(AArgument node)
    {
        defaultCase(node);
    }

    public void caseAIdValue(AIdValue node)
    {
        defaultCase(node);
    }

    public void caseAIfStatement(AIfStatement node)
    {
        defaultCase(node);
    }

    public void caseAWhileStatement(AWhileStatement node)
    {
        defaultCase(node);
    }

    public void caseAForStatement(AForStatement node)
    {
        defaultCase(node);
    }

    public void caseAReturnStatement(AReturnStatement node)
    {
        defaultCase(node);
    }

    public void caseAPrintStatement(APrintStatement node)
    {
        defaultCase(node);
    }

    public void caseAAssignmentStatement(AAssignmentStatement node)
    {
        defaultCase(node);
    }

    public void caseATableStatement(ATableStatement node)
    {
        defaultCase(node);
    }

    public void caseAFunctionCallStatement(AFunctionCallStatement node)
    {
        defaultCase(node);
    }

    public void caseAAddExpression(AAddExpression node)
    {
        defaultCase(node);
    }

    public void caseASubExpression(ASubExpression node)
    {
        defaultCase(node);
    }

    public void caseAMulExpression(AMulExpression node)
    {
        defaultCase(node);
    }

    public void caseADivExpression(ADivExpression node)
    {
        defaultCase(node);
    }

    public void caseAIncrementExpression(AIncrementExpression node)
    {
        defaultCase(node);
    }

    public void caseADecrementExpression(ADecrementExpression node)
    {
        defaultCase(node);
    }

    public void caseAArrayExpression(AArrayExpression node)
    {
        defaultCase(node);
    }

    public void caseAFunctionCallExpression(AFunctionCallExpression node)
    {
        defaultCase(node);
    }

    public void caseAValueExpression(AValueExpression node)
    {
        defaultCase(node);
    }

    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        defaultCase(node);
    }

    public void caseAParExpression(AParExpression node)
    {
        defaultCase(node);
    }

    public void caseAArgsExpression(AArgsExpression node)
    {
        defaultCase(node);
    }

    public void caseAGreComparison(AGreComparison node)
    {
        defaultCase(node);
    }

    public void caseALessComparison(ALessComparison node)
    {
        defaultCase(node);
    }

    public void caseANeqComparison(ANeqComparison node)
    {
        defaultCase(node);
    }

    public void caseAEqComparison(AEqComparison node)
    {
        defaultCase(node);
    }

    public void caseATrueComparison(ATrueComparison node)
    {
        defaultCase(node);
    }

    public void caseAFalseComparison(AFalseComparison node)
    {
        defaultCase(node);
    }

    public void caseAFunctionCall(AFunctionCall node)
    {
        defaultCase(node);
    }

    public void caseAArgList(AArgList node)
    {
        defaultCase(node);
    }

    public void caseAIntegerLiteralValue(AIntegerLiteralValue node)
    {
        defaultCase(node);
    }

    public void caseAStringValueValue(AStringValueValue node)
    {
        defaultCase(node);
    }

    public void caseTTab(TTab node)
    {
        defaultCase(node);
    }

    public void caseTMinusEq(TMinusEq node)
    {
        defaultCase(node);
    }

    public void caseTDivEq(TDivEq node)
    {
        defaultCase(node);
    }

    public void caseTAug(TAug node)
    {
        defaultCase(node);
    }

    public void caseTDec(TDec node)
    {
        defaultCase(node);
    }

    public void caseTNotEq(TNotEq node)
    {
        defaultCase(node);
    }

    public void caseTEqComp(TEqComp node)
    {
        defaultCase(node);
    }

    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    public void caseTEq(TEq node)
    {
        defaultCase(node);
    }

    public void caseTDef(TDef node)
    {
        defaultCase(node);
    }

    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    public void caseTLBr(TLBr node)
    {
        defaultCase(node);
    }

    public void caseTRBr(TRBr node)
    {
        defaultCase(node);
    }

    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    public void caseTFor(TFor node)
    {
        defaultCase(node);
    }

    public void caseTPrint(TPrint node)
    {
        defaultCase(node);
    }

    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    public void caseTLess(TLess node)
    {
        defaultCase(node);
    }

    public void caseTGreat(TGreat node)
    {
        defaultCase(node);
    }

    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    public void caseTSemi(TSemi node)
    {
        defaultCase(node);
    }

    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    public void caseTIn(TIn node)
    {
        defaultCase(node);
    }

    public void caseTLineComment(TLineComment node)
    {
        defaultCase(node);
    }

    public void caseTIntegerLiteral(TIntegerLiteral node)
    {
        defaultCase(node);
    }

    public void caseTNumber(TNumber node)
    {
        defaultCase(node);
    }

    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    public void caseTStringLiteral(TStringLiteral node)
    {
        defaultCase(node);
    }

    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(Node node)
    {
    }
}
