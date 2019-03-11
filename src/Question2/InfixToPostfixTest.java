package Question2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InfixToPostfixTest {

    // test without Parenthesis
    @Test
    public void testWithoutParenthesis() {
        InfixToPostfix postfix = new InfixToPostfix("a + b");
        String result = postfix.findPostfixExpression();
        assertEquals("ab+", result);
    }

    // test with Parenthesis
    @Test
    public void testWithParenthesis() {
        InfixToPostfix postfix = new InfixToPostfix("( a + b ) * ( c + d )");
        String exp = postfix.findPostfixExpression();
        assertEquals(exp, "ab+cd+*");
    }

    // test with multi valued Parenthesis
    @Test
    public void testWithMultiDigitVariable() {
        InfixToPostfix postfix = new InfixToPostfix("( ax + by ) * ( c + d )");
        String exp = postfix.findPostfixExpression();
        assertEquals(exp, "axby+cd+*");
    }

    // test with extra close parenthesis
    @Test(expected = AssertionError.class)
    public void testWithExtraCloseParenthesis() {
        InfixToPostfix postfix = new InfixToPostfix("a + b )");
        String result = postfix.findPostfixExpression();
        assertEquals("ab+", result);
    }
    
    // test with extra open parenthesis
    @Test(expected = AssertionError.class)
    public void testWithExtraOpenParenthesis() {
        InfixToPostfix postfix = new InfixToPostfix("( a + b");
        String result = postfix.findPostfixExpression();
        assertEquals("ab+", result);
    }
    
    // test without Relational Operators
    @Test
    public void testWithRelationalOperators() {
        InfixToPostfix postfix = new InfixToPostfix("a * b == 2");
        String result = postfix.findPostfixExpression();
        assertEquals("ab*2==", result);
    }
    
    
    @Test
    public void testWithParenthesis2() {
        InfixToPostfix postfix = new InfixToPostfix("a + b * c");
        String exp = postfix.findPostfixExpression();
        assertEquals(exp, "abc*+");
    }
    

}
