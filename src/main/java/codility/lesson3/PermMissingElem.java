package codility.lesson3;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PermMissingElem {
    /**
     * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
     *
     * Your goal is to find that missing element.
     *
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A, returns the value of the missing element.
     *
     * For example, given array A such that:
     *
     *   A[0] = 2
     *   A[1] = 3
     *   A[2] = 1
     *   A[3] = 5
     * the function should return 4, as it is the missing element.
     *
     * Assume that:
     *
     * N is an integer within the range [0..100,000];
     * the elements of A are all distinct;
     * each element of array A is an integer within the range [1..(N + 1)].
     * Complexity:
     *
     * expected worst-case time complexity is O(N);
     * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     *
     */
    //This solution fails overflow dude to the summation calculations.
    public int solutionW(int[] A) {
        // write your code in Java SE 8
        // summation to N term  = n(n+1)/2
        if(A.length == 0) return 1;
        int sum = 0;
        for(int a: A){
            sum += a;
        }
        int n = A.length+1;
        return (n*(n+1)/2)-sum;
    }

    public int solution(int[] A){
        Arrays.sort(A);
        int pos = 1;
        for(int a: A){
            if(a == pos){
                pos++;
            } else {
                return pos;
            }
        }
        return pos;
    }

    @Test
    public void testExample(){
        PermMissingElem p = new PermMissingElem();
        assertEquals(p.solution(new int[]{2,3,1,5}), 4);
    }

    @Test
    public void testEmpty(){
        PermMissingElem p = new PermMissingElem();
        assertEquals(p.solution(new int[]{}), 1);
    }

    @Test
    public void testSingle(){
        PermMissingElem p = new PermMissingElem();
        assertEquals(p.solution(new int[]{1}), 2);
    }

    @Test
    public void testSingleLong(){
        PermMissingElem p = new PermMissingElem();
        assertEquals(p.solution(new int[]{1,2,3,4,5,6,8}), 7);
    }
}
