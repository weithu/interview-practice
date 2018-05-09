package leet.problems.zigzag;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ZigZag {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     *
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    public String convert(String s, int numRows) {

        int len = s.length();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++)
                sb[idx].append(s.charAt(i++));
            for (int idx = numRows-2; idx >= 1 && i < len; idx--)
                sb[idx].append(s.charAt(i++));
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    @Test
    public void exampleTest(){
        ZigZag z = new ZigZag();
        Assert.assertEquals(z.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    }

}
