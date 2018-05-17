package csdojo.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRecurringChar {
    /**
     * Given a String of characters, return the first non recurruring characters in the String, return null otherwise.
     */
    public Character firstNonRecurringChar(String s){
        if(s==null||s.isEmpty()){
            return null;
        }
        List<Character> singleChars = new ArrayList<>();
        List<Character> multipleChars = new ArrayList<>();
        for(Character c: s.toCharArray()){
            if(singleChars.contains(c)){
                singleChars.remove(c);
                multipleChars.add(c);
            } else {
                if(!multipleChars.contains(c)){
                    singleChars.add(c);
                }
            }
        }
        if(singleChars.isEmpty()){
            return null;
        } else {
            return singleChars.remove(0);
        }
    }
    private FirstNonRecurringChar f;
    @Before
    public void setUp(){
        f = new FirstNonRecurringChar();
    }
    @Test
    public void testExample1(){
        Assert.assertEquals(f.firstNonRecurringChar("ABCDABC"), Character.valueOf('D'));
    }

    @Test
    public void testExample2(){
        Assert.assertEquals(f.firstNonRecurringChar("ABCDABCD"), null);
    }
    @Test
    public void testFirstChar(){
        Assert.assertEquals(f.firstNonRecurringChar("ABCDBCD"), Character.valueOf('A'));
    }
    @Test
    public void testLastChar(){
        Assert.assertEquals(f.firstNonRecurringChar("ABCDABCDX"), Character.valueOf('X'));
    }
    @Test
    public void testUpperAndLower(){
        Assert.assertEquals(f.firstNonRecurringChar("ABcdAbbcdA"), Character.valueOf('B'));
    }
    @Test
    public void testLowerAndUpper(){
        Assert.assertEquals(f.firstNonRecurringChar("ABcdAbbdDBA"), Character.valueOf('c'));
    }
    @Test
    public void testMultipleNonRepeating(){
        Assert.assertEquals(f.firstNonRecurringChar("abcdabcdxYzabcd"), Character.valueOf('x'));
    }
    @Test
    public void testEdgeConditionsNull(){
        Assert.assertEquals(f.firstNonRecurringChar(null), null);
    }
    @Test
    public void testEdgeConditionsEmpty(){
        Assert.assertEquals(f.firstNonRecurringChar(""), null);
    }
}
