package leet.problems.countandsay;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth term of the count-and-say sequence.
     *
     * Note: Each term of the sequence of integers will be represented as a string.
     *
     * Example 1:
     *
     * Input: 1
     * Output: "1"
     * Example 2:
     *
     * Input: 4
     * Output: "1211"
     */
    public String countAndSay(int n) {
        if(n == 0) return "0";
        if(n == 1) return "1";

        String item = "1";
        for(int i = 2; i<= n; i++){
            item = getCountNumber(item);
        }
        return item;
    }

    private String getCountNumber(String number){
        char holder = 0;
        int count = 0;
        boolean firstRun = true;
        StringBuffer sb = new StringBuffer();

        for(char c: number.toCharArray()){
            if (holder == c){
                count++;
            } else {
                if(firstRun){
                    holder = c;
                    count++;

                    firstRun = false;
                }else{
                    sb.append(count);
                    sb.append(holder);

                    holder = c;
                    count = 1;
                }

            }
        }
        sb.append(count);
        sb.append(holder);

        return sb.toString();
    }

    @Test
    public void example1Test(){
        CountAndSay cas = new CountAndSay();
        Assert.assertEquals(cas.countAndSay(1), "1");
    }

    @Test
    public void example2Test(){
        CountAndSay cas = new CountAndSay();
        Assert.assertEquals(cas.countAndSay(4), "1211");
    }
}
