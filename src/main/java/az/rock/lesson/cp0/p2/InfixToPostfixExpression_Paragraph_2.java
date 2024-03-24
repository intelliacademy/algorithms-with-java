package az.rock.lesson.cp0.p2;

public class InfixToPostfixExpression_Paragraph_2 {
    public static void main(String[] args) {
        InfixToPostfixParser infixToPostfix = InfixToPostfixParser.of("a+b*(c/d-e)^(f+g)*h");
        System.out.println(infixToPostfix.parse());
    }
}
