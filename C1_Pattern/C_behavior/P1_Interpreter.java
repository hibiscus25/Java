package C1_Pattern.C_behavior;


interface Expression2{
    boolean interpret(String context);
}

class AndExpression implements Expression2{
    private Expression2 expr1;
    private Expression2 expr2;

    public AndExpression(Expression2 expr1, Expression2 expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        boolean a = expr1.interpret(context);
            System.out.println(a);
        boolean b = expr2.interpret(context);
            System.out.println(b);
        return a && b;
    }
}


class OrExpression implements Expression2{
    private Expression2 expr1;                                      // объект Java
    private Expression2 expr2;                                      // объект Java Core

    public OrExpression(Expression2 expr1, Expression2 expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {                  // текст Java Core
        boolean a = expr1.interpret(context);
            System.out.println(a);
        boolean b = expr2.interpret(context);
            System.out.println(b);
        return a || b;
    }
}


class TerminalExpression implements Expression2{
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        System.out.println("Context = " + context + "         " + "Date = " + data);
        if(context.contains(data))
            return true;
        return false;
    }
}

//-------------------------------------------------------------------------------------
public class P1_Interpreter {
    public static void main(String[] args) {
        Expression2 isJava = new OrExpression(new TerminalExpression("Java"), new TerminalExpression("Java Core"));
        Expression2 isJavaEE = new AndExpression(new TerminalExpression("Java"), new TerminalExpression("Spring"));

        System.out.println("Does developer knows Java Core: " + isJava.interpret("Java Core"));
        System.out.println();
        System.out.println("Does developer knows Java EE: " + isJavaEE.interpret("Java Spring"));
    }
}
