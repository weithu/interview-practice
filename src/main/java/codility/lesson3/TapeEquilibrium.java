package codility.lesson3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibrium {
    /**
     * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
     *
     * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
     *
     * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
     *
     * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
     *
     * For example, consider array A such that:
     *
     *   A[0] = 3
     *   A[1] = 1
     *   A[2] = 2
     *   A[3] = 4
     *   A[4] = 3
     * We can split this tape in four places:
     *
     * P = 1, difference = |3 − 10| = 7
     * P = 2, difference = |4 − 9| = 5
     * P = 3, difference = |6 − 7| = 1
     * P = 4, difference = |10 − 3| = 7
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
     *
     * For example, given:
     *
     *   A[0] = 3
     *   A[1] = 1
     *   A[2] = 2
     *   A[3] = 4
     *   A[4] = 3
     * the function should return 1, as explained above.
     *
     * Assume that:
     *
     * N is an integer within the range [2..100,000];
     * each element of array A is an integer within the range [−1,000..1,000].
     * Complexity:
     *
     * expected worst-case time complexity is O(N);
     * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     */
    public int solution(int[] A) {

        int left = A[0];
        int right = 0;
        for(int i=1; i<A.length; i++) right+=A[i];

        int smallestDiff = Math.abs(left - right);
        if(A.length == 2) return smallestDiff;
        for(int i=1; i<A.length-1; i++){
            left += A[i];
            right -= A[i];
            int diff = Math.abs(left - right);
            if(diff < smallestDiff) smallestDiff = diff;
        }
        return smallestDiff;

    }

    @Test
    public void testExample00(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{-10, -20, -30, -40, 100}), 20);//-10
    }
    @Test
    public void testExample(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{3,1,2,4,3}), 1);
    }
    @Test
    public void testExample2(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{7,1,2,4,3}), 1); //3, 1, 3, 11
    }
    @Test
    public void testExample3(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{4,6,2,-1,4,3}), 2); //10, 2, 6, 3, 12
    }
    @Test
    public void testExample4(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{-10, -5, -3, -4, -5}), 3); //7, 3, 9, 19
    }
    @Test
    public void testALimists(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{-1000,1000}), 2000);
        assertEquals(t.solution(new int[]{1000,-1000}), 2000);
    }

    @Test
    public void testZero(){
        TapeEquilibrium t = new TapeEquilibrium();
        assertEquals(t.solution(new int[]{-1000,-1000}), 0);
        assertEquals(t.solution(new int[]{1000,1000}), 0);
    }
}
