package az.rock.lesson.cp0.p2;

import az.rock.lesson.cp2.Stack;

public class InfixToPostfix {

    private Knot[] knots;
    private Stack<Knot> stack;
    private StringBuilder postfix;

    private InfixToPostfix(Knot[] knots) {
        this.knots = knots;
        this.stack = new Stack<Knot>();
        this.postfix = new StringBuilder();
    }


    public static InfixToPostfix of(String expression){
        return new InfixToPostfix(parse(expression));
    }

    public static Knot[] parse(String expression){
        Knot[] knots = new Knot[expression.length()];
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            int priority = 0;
            if(character == '+' || character == '-'){
                priority = 1;
            }else if(character == '*' || character == '/'){
                priority = 2;
            }
            knots[i] = new Knot(character, priority);
        }
        return knots;
    }

    public String convert(){
        for (Knot knot : knots) {
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


    public static class Knot implements Comparable<Knot> {
        private Character character;
        private Integer priority;

        public Knot(Character character, Integer priority) {
            this.character = character;
            this.priority = priority;
        }

        public Character getCharacter() {
            return character;
        }

        public Integer getPriority() {
            return priority;
        }

        public Boolean isOperator(){
            return character == '+' || character == '-' || character == '*' || character == '/';
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

        @Override
        public int compareTo(Knot o) {
            return priority.compareTo(o.getPriority());
        }
    }
}
