package codility.lesson1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 Task description
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

 For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

 Write a function:

 class Solution { public int solution(int N); }

 that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

 For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

 Assume that:

 N is an integer within the range [1..2,147,483,647].
 Complexity:

 expected worst-case time complexity is O(log(N));
 expected worst-case space complexity is O(1).
 *
 */
public class BinaryGap {
    public int solution(int N){
        String bn = Integer.toBinaryString(N);
        System.out.println(bn);
        int max = 0;
        int count = 0;
        for(char c: bn.toCharArray()){
            if(c == '0'){
                count++;
            } else {
                if(max < count){
                    max = count;
                }
                count = 0;
            }
        }
        return max;
    }

    @Test
    public void test1041(){
        BinaryGap b = new BinaryGap();
        assertEquals( b.solution(1041), 5);
    }

    @Test
    public void test9(){
        BinaryGap b = new BinaryGap();
        assertEquals( b.solution(9), 2);
    }
    @Test
    public void test529(){
        BinaryGap b = new BinaryGap();
        assertEquals( b.solution(529), 4);
    }

    @Test
    public void testMax(){
        BinaryGap b = new BinaryGap();
        assertEquals(b.solution(Integer.MAX_VALUE), 0);
    }


}
