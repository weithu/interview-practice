package leet.problems.reverseint;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseInt {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     * @param x
     * @return
     */
    public int reverse(int x) {
        System.out.println("x="+x);
        boolean isNeg = x < 0;
        if(isNeg){
            System.out.println("MAXINT: " + Integer.MAX_VALUE);
            long lx = (long)x * -1;
            System.out.println(lx);
            if(lx > Integer.MAX_VALUE) return 0;
            x = x * -1;
            System.out.println("x is neg & value changed to x=" + x);
        }
        char[] s = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = s.length-1; i >=0; i--) {
            System.out.println(s[i]);
            sb.append(s[i]);
        }

        String ss = sb.toString();
        long l = Long.parseLong(ss);
        if(l > Integer.MAX_VALUE) {
            return 0;
        }

        int v = Integer.valueOf(ss);
        if(isNeg) return v * -1;
        return v;
    }

    @Test
    public void testReverseInt(){
        ReverseInt r = new ReverseInt();
        Assert.assertEquals(r.reverse(123), 321);

    }
    @Test
    public void testReverseIntNeg(){
        ReverseInt r = new ReverseInt();
        Assert.assertEquals(r.reverse(-123), -321);
    }
    @Test
    public void testReverseMaxNeg(){
//        long l = -1234;
//        long lx = l * -1;
//        System.out.println(lx);
        ReverseInt r = new ReverseInt();
        Assert.assertEquals(r.reverse(-2147483648), 0);
    }
}

