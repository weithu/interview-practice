package ctci.chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem1_9_StringRotation {
    /**
     * String Rotation: Assume you have a method isSubstring which checks if one word is asubstring of another.
     * Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one call to
     * isSubstring
     * (e.g.,"waterbottle"is a rotation of"erbottlewat").
     * Hints: #34, #88, #104
     */
    public boolean isRotation(String s1, String s2){
        if(s1.length() > s2.length()) return false;

        String doubleStr = s1 + s1;


        return isSubstring(doubleStr, s2);
    }

    private boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    private Problem1_9_StringRotation p;

    @Before
    public void setUp(){
        p = new Problem1_9_StringRotation();
    }
    @Test
    public void testExample1(){
       assertTrue(p.isRotation("waterbottle", "erbottlewat"));
    }

    @Test
    public void testExample2(){
        assertFalse(p.isRotation("waterbottle", "ersbottlewat"));
    }
    @Test
    public void testExample3(){
        assertFalse(p.isRotation("abcdefg", "efghabcd"));
    }
    @Test
    public void testExample4(){
        assertTrue(p.isRotation("abcdefg", "efgabcde"));
    }
}
