package codility.lesson4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PermCheck {
    /**
     * A non-empty array A consisting of N integers is given.
     *
     * A permutation is a sequence containing each element from 1 to N once, and only once.
     *
     * For example, array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     *     A[3] = 2
     * is a permutation, but array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     * is not a permutation, because value 2 is missing.
     *
     * The goal is to check whether array A is a permutation.
     *
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
     *
     * For example, given array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     *     A[3] = 2
     * the function should return 1.
     *
     * Given array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     * the function should return 0.
     *
     * Assume that:
     *
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [1..1,000,000,000].
     * Complexity:
     *
     * expected worst-case time complexity is O(N);
     * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     */
    public int solution(int[] A) {
        Arrays.sort(A);
        int pos = 1;
        for(int a: A){
            if(a==pos) pos++;
            else
                return 0;
        }
        return 1;
    }

    public int solutionw(int[] A) {
        int n = A.length;
        int sum = n*(n+1)/2;
        int actualSum=0;
        for(int a: A){
            actualSum+=a;
        }
        return sum==actualSum? 1: 0;
    }

    @Test
    public void testFailedSample(){
        PermCheck p = new PermCheck();
        Assert.assertEquals(p.solution(new int[]{1,4,1}), 0);
    }
    @Test
    public void testExample(){
        PermCheck p = new PermCheck();
        Assert.assertEquals(p.solution(new int[]{1,2,3,4,5}), 1);
    }
    @Test
    public void testExample2(){
        PermCheck p = new PermCheck();
        Assert.assertEquals(p.solution(new int[]{1,2,3,4,5,8}), 0);
    }
    @Test
    public void testExample3(){
        PermCheck p = new PermCheck();
        Assert.assertEquals(p.solution(new int[]{1}), 1);
    }
    @Test
    public void testExample4(){
        PermCheck p = new PermCheck();
        Assert.assertEquals(p.solution(new int[]{2}), 0);
    }
}
