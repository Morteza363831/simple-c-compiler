package org.compiler.tac;

public class TacInstruction {
    public String operator;  // e.g., "+", "-", "=", "if", "goto"
    public String arg1;      // Argument 1
    public String arg2;      // Argument 2
    public String result;    // Result variable (temporary or named)

    public TacInstruction(String operator, String arg1, String arg2, String result) {
        this.operator = operator;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;
    }

    @Override
    public String toString() {
        if (result==null) result="";
        if (arg1==null) arg1="";
        if (operator==null) operator="";
        if (arg2==null) arg2="";
//        result = " (#result): " + result;
//        arg1 = " (#arg1): " + arg1;
//        arg2 = " (#arg2): " + arg2;
//        operator = " (#operator): " + operator;
        return result + " = " + arg1 + " " + operator + " " + arg2; // Or whatever format you prefer
    }
}
