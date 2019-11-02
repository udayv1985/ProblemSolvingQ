package com.uday.design.patterns;

public class ChainOfRespPattern {

    public static void main(String[] arg){
        StringRule sr = new StringRule();
        sr.execute(new Long(5));
    }
}

interface Rule {

    public boolean qualifies(Object o);

    public void execute(Object o);
}

abstract class RuleImpl implements Rule {

    Rule next;

    public RuleImpl(Rule r){
        this.next = r;
    }

    @Override
    public void execute(Object o) {
        if (this.qualifies(o)) {
            System.out.println(this.getClass().getName());
        } else if(null != next) {
            next.execute(o);
        }
        else{
            System.out.println("No rule found to execute");
        }
    }
}

class StringRule extends RuleImpl{

    public StringRule() {
        super(new IntegerRule());
    }

    @Override
    public boolean qualifies(Object o) {
        return (o instanceof  String);
    }
}

class IntegerRule extends RuleImpl{

    public IntegerRule() {
        super(null);
    }

    @Override
    public boolean qualifies(Object o) {
        return (o instanceof  Integer);
    }
}
