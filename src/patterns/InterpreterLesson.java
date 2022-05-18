package patterns;

import java.util.Stack;

public class InterpreterLesson {
    public static void main(String[] args) {
        String expression = "1+2+3-4"; //2
        Expression evaluator = new Evaluate(expression);
        System.out.println(evaluator.interpreter(evaluator));
    }
}

interface Expression {
    int interpreter(Expression context);
}

class Number implements Expression{
    int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpreter(Expression context) {
        return number;
    }
}

class Plus implements Expression {
    Expression expressionLeft;
    Expression expressionRight;

    public Plus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpreter(Expression context) {
        return expressionLeft.interpreter(context) + expressionRight.interpreter(context);
    }
}

class Minus extends Plus {

    public Minus(Expression expressionLeft, Expression expressionRight) {
        super(expressionLeft, expressionRight);
    }

    @Override
    public int interpreter(Expression context) {
        return expressionLeft.interpreter(context) - expressionRight.interpreter(context);
    }
}

class Evaluate implements Expression {
    Expression evaluate;

    public Evaluate(String expression) {
        Stack<Expression> expressions = new Stack<>();
        String expressionRevert = new StringBuilder(expression).reverse().toString();
        for (String s : expressionRevert.split("\\D")) {
             expressions.push(new Number(Integer.parseInt(s)));
        }
        for (String s : expression.split("\\d")) {
            if (s.equals("+")) {
                expressions.push(new Plus(expressions.pop(), expressions.pop()));
            } else if (s.equals("-")) {
                expressions.push(new Minus(expressions.pop(), expressions.pop()));
            }
        }
        evaluate = expressions.pop();
    }

    @Override
    public int interpreter(Expression context) {
        return evaluate.interpreter(context);
    }
}