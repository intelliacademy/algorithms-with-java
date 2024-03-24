package az.rock.lesson.cp0.p2;

public class InfixToPostfixExpression_Paragraph_2 {
    public static void main(String[] args) {
        InfixToPostfix infixToPostfix = InfixToPostfix.of("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println(infixToPostfix.convert());
    }
}
