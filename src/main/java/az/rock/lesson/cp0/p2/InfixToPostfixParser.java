package az.rock.lesson.cp0.p2;


import java.util.Stack;

public class InfixToPostfixParser {

    private Knot[] knots;
    private Stack<Knot> stack;
    private StringBuilder postfix;

    private InfixToPostfixParser(Knot[] knots) {
        this.knots = knots;
        this.stack = new Stack<>();
        this.postfix = new StringBuilder();
    }


    public static InfixToPostfixParser of(String expression){
        return new InfixToPostfixParser(parse(expression));
    }

    public static Knot[] parse(String expression){
        Knot[] knots = new Knot[expression.length()];
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == ' ') {
                continue;
            }
            knots[i] = new Knot(character);
        }
        return knots;
    }

    public String parse(){
        for (Knot knot : knots)
            if (knot != null){
                if(knot.isOperator()){
                    while (!stack.isEmpty() && !stack.peek().isLeftParenthesis() && stack.peek().isUpperPriority(knot)){
                        postfix.append(stack.pop().getCharacter());
                    }
                    stack.push(knot);
                }else if(knot.isLeftParenthesis()){
                    stack.push(knot);
                }else if(knot.isRightParenthesis()){
                    while (!stack.isEmpty() && !stack.peek().isLeftParenthesis()){
                        postfix.append(stack.pop().getCharacter());
                    }
                    stack.pop();
                }else{
                    postfix.append(knot.getCharacter());
                }
            }
        while (!stack.isEmpty()){
            postfix.append(stack.pop().getCharacter());
        }
        return postfix.toString();
    }


    public static class Knot  {
        private Character character;
        private Integer priority;

        public Knot(Character character) {
            this.character = character;
            this.priority = setPriority(character);
        }

        public static Integer setPriority(Character character){
            int priority = 0;
            if (character == '+') {
                priority = 1;
            } else if (character == '-') {
                priority = 2;
            } else if (character == '*') {
                priority = 3;
            } else if ( character == '/') {
                priority = 4;
            } else if (character == '^') {
                priority = 5;
            }
            return priority;
        }

        public Character getCharacter() {
            return character;
        }

        public Integer getPriority() {
            return priority;
        }

        public Boolean isOperator(){
            return character == '+' || character == '-' || character == '*' || character == '/' || character == '^';
        }

        public Boolean isUpperPriority(Knot knot){
            return priority > knot.getPriority();
        }

        public Boolean isLowerPriority(Knot knot){
            return priority < knot.getPriority();
        }

        public Boolean isPower(){
            return character == '^';
        }

        public Boolean isLeftParenthesis(){
            return character == '(';
        }

        public Boolean isRightParenthesis(){
            return character == ')';
        }

    }
}
