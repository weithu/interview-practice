package lesson4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxCounters {
    /**
     * You are given N counters, initially set to 0, and you have two possible operations on them:
     *
     * increase(X) − counter X is increased by 1,
     * max counter − all counters are set to the maximum value of any counter.
     * A non-empty array A of M integers is given. This array represents consecutive operations:
     *
     * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
     * if A[K] = N + 1 then operation K is max counter.
     * For example, given integer N = 5 and array A such that:
     *
     *     A[0] = 3
     *     A[1] = 4
     *     A[2] = 4
     *     A[3] = 6
     *     A[4] = 1
     *     A[5] = 4
     *     A[6] = 4
     * the values of the counters after each consecutive operation will be:
     *
     *     (0, 0, 1, 0, 0)
     *     (0, 0, 1, 1, 0)
     *     (0, 0, 1, 2, 0)
     *     (2, 2, 2, 2, 2)
     *     (3, 2, 2, 2, 2)
     *     (3, 2, 2, 3, 2)
     *     (3, 2, 2, 4, 2)
     * The goal is to calculate the value of every counter after all operations.
     *
     * Write a function:
     *
     * class Solution { public int[] solution(int N, int[] A); }
     *
     * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
     *
     * The sequence should be returned as:
     *
     * a structure Results (in C), or
     * a vector of integers (in C++), or
     * a record Results (in Pascal), or
     * an array of integers (in any other programming language).
     * For example, given:
     *
     *     A[0] = 3
     *     A[1] = 4
     *     A[2] = 4
     *     A[3] = 6
     *     A[4] = 1
     *     A[5] = 4
     *     A[6] = 4
     * the function should return [3, 2, 2, 4, 2], as explained above.
     *
     * Assume that:
     *
     * N and M are integers within the range [1..100,000];
     * each element of array A is an integer within the range [1..N + 1].
     * Complexity:
     *
     * expected worst-case time complexity is O(N+M);
     * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     */
    public int[] solution(int N, int[] A){
        int[] counters = new int[N];
        int max = 0; //the current max for the array
        int floor = 0; //the min val for the return array
        for(int i=0; i< N; i++){
            counters[i]=0;
        }

        //if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
        //if A[K] = N + 1 then operation K is max counter.
        for(int i=0; i< A.length; i++){
            int x = A[i];

            if(x <= N && 1<= x){
                //x is creased by one;
                int val = counters[x-1];
                if(val < floor) val = floor + 1;
                else val++;

                //reset max
                if(val > max) max = val;
                counters[x-1] = val;
            } else {
                floor = max;
            }
        }
        for(int i=0; i<N;i++){
            int n = counters[i];
            if(n < floor) counters[i] = floor;
        }
        return counters;
    }

    //Correct, but fails performance
    //    public int[] wrongSolution(int N, int[] A){
    //        int[] counters = new int[N];
    //        int max = 0;
    //        for(int i=0; i< N; i++){
    //            counters[i]=0;
    //        }
    //
    //        //if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
    //        //if A[K] = N + 1 then operation K is max counter.
    //        for(int i=0; i< A.length; i++){
    //            int x = A[i];
    //
    //            if(x <= N && 1<= x){
    //                //x is creased by one;
    //                int val = counters[x-1];
    //                val++;
    //                if(val > max) max = val;
    //                counters[x-1] = val;
    //            } else {
    //                for(int j=0;j<N;j++){
    //                    counters[j] = max;
    //                }
    //            }
    //
    //        }
    //        return counters;
    //    }

    @Test
    public void testExample(){
        MaxCounters m = new MaxCounters();
        Assert.assertEquals(m.solution(5, new int[]{3,4,4,6,1,4,4}), new int[]{3, 2, 2, 4, 2});
    }
}
