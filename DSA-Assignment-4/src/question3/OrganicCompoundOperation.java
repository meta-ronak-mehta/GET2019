package question3;

import java.util.Stack;

public class OrganicCompoundOperation {

    private Stack<Integer> stack = new Stack<Integer>();

    public int evaluate(String compound) {
        // place ')' at the end so we get to know the end of formula
        String input = compound.toUpperCase() + ")";
        // push -1 so at the and we can calculate the sum of all element of
        // stack
        stack.push(-1);
        int i = 0;

        // iterate throw every Char of formula
        while (i < input.length()) {
            char symbol = input.charAt(i);
            // push corresponding molecular mass of Atom into Stack
            if ('C' == symbol)
                stack.push(12);
            else if ('O' == symbol)
                stack.push(16);
            else if ('H' == symbol)
                stack.push(1);
            // if its '(' push -1 so we can sum all atom's mass when ')' accrue
            else if ('(' == symbol)
                stack.push(-1);
            // if ')' accrue pop elements till -1 ['('] accrue and push sum of
            // them into stack
            else if (')' == symbol) {
                int sum = 0;
                while (stack.peek() > 0) {
                    sum += stack.pop();
                }
                // pop -1 from stack
                stack.pop();
                stack.push(sum);
                // if char in number
            } else if (Character.isDigit(symbol)) {
                String val = "" + symbol;
                // make integer value of multi digit
                while (Character.isDigit(input.charAt(i + 1))) {
                    val += input.charAt(i + 1);
                    i++;
                }
                // multiply integer to stack top and push
                int value = (int) Integer.parseInt(val);
                int mul = stack.pop() * value;
                stack.push(mul);
            } else
                System.out.println("Enter a Valid Formula");
            i++;
        }
        return stack.peek();
    }
}
