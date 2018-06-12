package leet.problems.strstr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrStr {
    /**
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Example 1:
     *
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     *
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * Clarification:
     *
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     *
     * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     *
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null) return -1;

        if(haystack.isEmpty() && needle.isEmpty()) return 0;
        if(needle.isEmpty()) return 0;
        System.out.println(haystack + ":" + needle);


        for(int i = 0; i< haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0) && i+needle.length() <= haystack.length()){
                boolean found = true;
                for(int j=1; j<needle.length(); j++){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        found = false;
                        break;

                    }
                }
                if(found){
                    return i;
                }
            }
        }

        return -1;
    }

    @Test
    public void testExample1(){
        StrStr s = new StrStr();
        assertEquals(s.strStr("hello", "ll"), 2);
    }
    @Test
    public void testExample2(){
        StrStr s = new StrStr();
        assertEquals(s.strStr("aaaa", "bba"), -1);
    }
}
