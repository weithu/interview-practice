package leet.problems.longestsubstring;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Examples:
     *
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     *
     * Given "bbbbb", the answer is "b", with the length of 1.
     *
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> usedChars = new HashMap<>();

        int lastI = 0;
        int maxCount = 0;

        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(usedChars.get(c) != null){
                if(usedChars.size() > maxCount){
                    maxCount = usedChars.size();
                }
                i = lastI++;
                usedChars = new HashMap<>();
                usedChars.put(s.charAt(i), true);

                continue;
            }

            usedChars.put(c, true);
        }

        return usedChars.size() > maxCount? usedChars.size(): maxCount;
    }

    @Test
    public void testBasecase1(){
        LongestSubstring ls = new LongestSubstring();
        Assert.assertEquals(ls.lengthOfLongestSubstring("abcabcbb"), 3);
    }

    @Test
    public void testBasecase2(){
        LongestSubstring ls = new LongestSubstring();
        Assert.assertEquals(ls.lengthOfLongestSubstring("bbbbb"), 1);
    }

    @Test
    public void testBasecase3(){
        LongestSubstring ls = new LongestSubstring();
        Assert.assertEquals(ls.lengthOfLongestSubstring("pwwkew"), 3);
    }

    @Test
    public void testCase1(){
        LongestSubstring ls = new LongestSubstring();
        Assert.assertEquals(ls.lengthOfLongestSubstring("aab"), 2);
    }

    @Test
    public void testCase2(){
        LongestSubstring ls = new LongestSubstring();
        Assert.assertEquals(ls.lengthOfLongestSubstring("dvdf"), 3);
    }
}
