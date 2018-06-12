package leet.problems.validparen;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesis {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     */

    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length()%2 != 0 || s.length() < 2) {
            return false;
        }

        int len = s.length();
        List<Character> closers = Arrays.asList(']', '}', ')');
        Stack<Character> stack = new Stack();

        for (char c: s.toCharArray()) {
            if(closers.contains(c)){
                if(stack == null || stack.isEmpty()){
                    return false;
                }
                char cc = stack.pop();
                switch(c){
                    case '}':
                        if(cc != '{')
                            return false;
                        break;
                    case ')':
                        if(cc != '(')
                            return false;
                        break;
                    case ']':
                        if(cc != '[')
                            return false;
                        break;
                }
            }else{
                stack.push(c);
            }
        }
        if(!stack.empty()){
            return false;
        }

        return true;
    }

    @Test
    public void testCaseTrue_simpleSingleCase(){
        ValidParenthesis vp = new ValidParenthesis();
        assertTrue(vp.isValid("()"));

    }

    @Test
    public void testCaseTrue_allMatchedSingle(){
        ValidParenthesis vp = new ValidParenthesis();
        assertTrue(vp.isValid("()[]{}"));

    }

    @Test
    public void testCaseFalse_notMatched(){
        ValidParenthesis vp = new ValidParenthesis();
        assertFalse(vp.isValid( "(]"));

    }

    @Test
    public void testCaseFalse_notMatchedMultiple(){
        ValidParenthesis vp = new ValidParenthesis();
        assertFalse(vp.isValid("([)]"));

    }

    @Test
    public void testCaseTrue_Nested(){
        ValidParenthesis vp = new ValidParenthesis();
        assertTrue(vp.isValid("{[]}"));

    }
}
