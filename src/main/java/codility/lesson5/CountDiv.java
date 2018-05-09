package codility.lesson5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountDiv {
    /**
     * Write a function:
     *
     * class Solution { public int solution(int A, int B, int K); }
     *
     * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
     *
     * { i : A ≤ i ≤ B, i mod K = 0 }
     *
     * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
     *
     * Assume that:
     *
     * A and B are integers within the range [0..2,000,000,000];
     * K is an integer within the range [1..2,000,000,000];
     * A ≤ B.
     * Complexity:
     *
     * expected worst-case time complexity is O(1);
     * expected worst-case space complexity is O(1).
     */

    public int solution(int A, int B, int K){
        int offset=0;
        if(A%K==0)
            offset = 1;
        return B/K-A/K+offset;
    }
//    Does not pass performance specs
//    public int solution(int A, int B, int K){
//        int count =0;
//        for(int i = A; i<= B; i++){
//            if(i%K==0) count++;
//        }
//        return count;
//    }


    @Test
    public void testExample1(){
        CountDiv c = new CountDiv();
        Assert.assertEquals(c.solution(6, 11, 2), 3);
    }

    @Test
    public void testExample2(){
        CountDiv c = new CountDiv();
        Assert.assertEquals(c.solution(0, 11, 2), 6);
    }
    @Test
    public void testExample3(){
        CountDiv c = new CountDiv();
        Assert.assertEquals(c.solution(1, 1, 11), 0);
    }
    @Test
    public void testExample4(){
        CountDiv c = new CountDiv();
        Assert.assertEquals(c.solution(0, 0, 11), 1);
    }

    @Test
    public void testExample5(){
        CountDiv c = new CountDiv();
        Assert.assertEquals(c.solution(0, 1, 11), 1);
    }

    @Test
    public void testExample6(){
        CountDiv c = new CountDiv();
        Assert.assertEquals(c.solution(11, 46, 17), 2);
    }
}
