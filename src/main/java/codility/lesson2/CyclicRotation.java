package codility.lesson2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CyclicRotation {
    /**
     * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by
     * one index, and the last element of the array is moved to the first place. For example, the rotation of
     * array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the
     * first place).
     *
     * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
     *
     * Write a function:
     *
     * class Solution { public int[] solution(int[] A, int K); }
     *
     * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
     *
     * For example, given
     *
     *     A = [3, 8, 9, 7, 6]
     *     K = 3
     * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
     *
     *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
     *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
     *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
     * For another example, given
     *
     *     A = [0, 0, 0]
     *     K = 1
     * the function should return [0, 0, 0]
     *
     * Given
     *
     *     A = [1, 2, 3, 4]
     *     K = 4
     * the function should return [1, 2, 3, 4]
     *
     * Assume that:
     *
     * N and K are integers within the range [0..100];
     * each element of array A is an integer within the range [−1,000..1,000].
     * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
     */

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length <2) return A;
        if(A.length == K) return A;


        int k0 = K%A.length;
        if(k0 == 0) return A;

        int pos = 0;
        int[] rotatedA = new int[A.length];
        for(int i=k0; i<A.length; i++){
            rotatedA[i] = A[pos];
            pos++;
        }
        for(int i=0; i<k0; i ++){
            rotatedA[i] = A[pos];
            pos++;
        }
        return rotatedA;
    }
    @Test
    public void testEx1(){
        CyclicRotation c = new CyclicRotation();
        Assert.assertEquals(c.solution(new int[]{3, 8, 9, 7, 6}, 3), new int[]{9, 7, 6, 3, 8});
    }
    @Test
    public void testEdgeEmpty(){
        CyclicRotation c = new CyclicRotation();
        Assert.assertEquals(c.solution(new int[]{}, 3), new int[]{});
    }
    @Test
    public void testKGtSize(){
        CyclicRotation c = new CyclicRotation();
        Assert.assertEquals(c.solution(new int[]{3, 8, 9, 7, 6}, 6), new int[]{6, 3, 8, 9, 7});
    }
    @Test
    public void testEqualSize(){
        CyclicRotation c = new CyclicRotation();
        Assert.assertEquals(c.solution(new int[]{3, 8, 9, 7, 6}, 5), new int[]{3, 8, 9, 7, 6});
    }

}
