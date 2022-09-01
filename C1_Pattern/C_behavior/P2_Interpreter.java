package C1_Pattern.C_behavior;


import java.util.Stack;



interface Expression{
    int interpreter();              // в примере int interpreter(Expression context);
}

class Number implements Expression{
    int number;

    public Number(int number){
        this.number = number;
    }

    @Override
    public int interpreter() {
        return number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}

class Plus implements Expression{
    Expression expressionLeft;
    Expression expressionRight;

    public Plus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    // expressionLeft  = Plus{expressionLeft=Number{number=5}, expressionRight=Number{number=2}}
    // expressionRight = Number{number=3}

    // expressionLeft  = Number{number=5}
    // expressionRight = Number{number=2}
    @Override
    public int interpreter() {
        int a = expressionLeft.interpreter() + expressionRight.interpreter();
        System.out.println(a);
        return a;
    }

    @Override
    public String toString() {
        return "Plus{" +
                "expressionLeft=" + expressionLeft +
                ", expressionRight=" + expressionRight +
                '}';
    }
}

class Minus extends Plus{
    public Minus(Expression expressionLeft, Expression expressionRight) {
        super(expressionLeft, expressionRight);
    }

    // expressionLeft=Plus{expressionLeft=Plus{expressionLeft=Number{number=5}, expressionRight=Number{number=2}}, expressionRight=Number{number=3}}
    // expressionRight=Number{number=11}
    @Override
    public int interpreter() {
        System.out.println("первый метод interpreter");
        return expressionLeft.interpreter() - expressionRight.interpreter();
    }

    @Override
    public String toString() {
        return "Minus{" +
                "expressionLeft=" +  expressionLeft +
                ", expressionRight=" + expressionRight +
                '}';
    }
}

//-------------------------------------------------------------------------------------------------
class Evaluate implements Expression{
    Expression evaluate;                        // получаем выражение 5 + 2 + 3 - 11

    // создает выражение 5+2+3-11
    public Evaluate(String expression) {
        Stack<Expression> stack = new Stack<>();
        String expRevers = new StringBuilder(expression).reverse().toString();   // 11 - 3 + 2 + 5

        for (String el : expRevers.split("\\D"))                          // [11, 3, 2, 5]
            stack.push(new Number(Integer.parseInt(el)));                             // добавили в Stack

        for(String s : expression.split("\\d")){                          // [, +, +, -]
            System.out.println(" - Элемент массива = " + s);
            System.out.println("    Размер до = " + stack.size());
            if (s.equals("+")){
                    Plus plus = new Plus(stack.pop(), stack.pop());
                    System.out.println(plus);
                stack.push(plus);
            } else if (s.equals("-")){
                    Minus minus = new Minus(stack.pop(), stack.pop());
                    System.out.println(minus);
                stack.push(minus);
            }
            System.out.println("    Размер после = " + stack.size());
        }

        evaluate = stack.pop();
    }

    @Override
    public int interpreter() {
        return evaluate.interpreter();
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "evaluate=" + evaluate +
                '}';
    }
}

//-------------------------------------------------------------------------------------------------
public class P2_Interpreter {
    public static void main(String[] args) {
        Expression ev = new Evaluate("5+2+3-11");
            System.out.println(ev.interpreter());
    }
}
