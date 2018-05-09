package problems.longestcommonprefix;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeSet;

public class LongestPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int len = strs[0].length();
        int index = 0;
        for(int i =0; i< strs.length;i++){
            if(strs[i].length() <= len){
                len = strs[i].length();
                index=i;
            }
        }

        String shortestStr = strs[index].substring(0, len);

        boolean found = false;
        while(!found){
            for(int i=0;i<strs.length;i++){
                String s = strs[i];
                if(s.indexOf(shortestStr) != 0){
                    shortestStr = shortestStr.substring(0, shortestStr.length()-1);
                    break;
                } else { if(i == strs.length-1) found = true; }
            }
        }

        return shortestStr;
    }

    @Test
    public void testSimpleCase(){
        LongestPrefix lp = new LongestPrefix();
        Assert.assertEquals(lp.longestCommonPrefix(new String[]{"abcxdf", "abdef", "abaa", "ab", "abcv"}), "ab");
    }


    @Test
    public void testSubsetCase(){
        LongestPrefix lp = new LongestPrefix();
        Assert.assertEquals(lp.longestCommonPrefix(new String[]{"abcxdf", "abdef", "abaa", "abdd", "abcv"}), "ab");
    }
}
