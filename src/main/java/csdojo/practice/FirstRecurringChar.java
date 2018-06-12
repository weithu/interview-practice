package csdojo.practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstRecurringChar {
    /**
     * Given a String of characters find the first repeating character. Return null otherwise.
     * examples:
     * ABCA --> A
     * BCABA --> B
     * ABC --> null
     */

    public Character findFirstRecurring(String s) {
        boolean[] usedChars = new boolean[128];
        if(s == null || s.isEmpty()) return null;
        for(char c: s.toCharArray()){
            if(usedChars[c]){
                return c;
            } else {
                usedChars[c] = true;
            }
        }
        return null;
    }

    private FirstRecurringChar f;
    @Before
    public void setUp(){
        f = new FirstRecurringChar();
    }
    @Test
    public void testExample1(){
        assertEquals(f.findFirstRecurring("ABCA"), Character.valueOf('A'));
    }
    @Test
    public void testExample2(){
        assertEquals(f.findFirstRecurring("BCABA"), Character.valueOf('B'));
    }
    @Test
    public void testExample3(){
        assertEquals(f.findFirstRecurring("ABC"), null);
    }
    @Test
    public void testLowerAndUpper(){
        assertEquals(f.findFirstRecurring("ABCabcC"), Character.valueOf('C'));
    }
    @Test
    public void testUpperAndLower(){
        assertEquals(f.findFirstRecurring("ABCabcb"), Character.valueOf('b'));
    }
    @Test
    public void testEdgeConditionsNull(){
        assertEquals(f.findFirstRecurring(null), null);
    }
    @Test
    public void testEdgeConditionsEmpty(){
        assertEquals(f.findFirstRecurring(""), null);
    }
}
