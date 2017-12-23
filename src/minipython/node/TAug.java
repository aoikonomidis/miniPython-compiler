/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TAug extends Token
{
    public TAug()
    {
        super.setText("++");
    }

    public TAug(int line, int pos)
    {
        super.setText("++");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TAug(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAug(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TAug text.");
    }
}