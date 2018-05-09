package codility.lesson4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SmallestMissingNum {

    /**
     * This is a demo task.
     *
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     *
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     *
     * Given A = [1, 2, 3], the function should return 4.
     *
     * Given A = [−1, −3], the function should return 1.
     *
     * Assume that:
     *
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     * Complexity:
     *
     * expected worst-case time complexity is O(N);
     * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
     */
    public int solution(int[] A) {
        if(A == null || A.length == 0){
            return 1;
        }
        if(A.length == 1){
            if(A[0] == 1) return 2;
            else return 1;
        }
        Arrays.sort(A);

        int holder = 0;
        for(int i: A){
            if(i >= 1){
                if(holder+1 < i){
                    return holder + 1;
                } else {
                        holder = i;

                }
            }
        }
        return holder +1;
    }
    @Test
    public void testw0(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{1,2,3}), 4);
    }

    @Test
    public void test0(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{-1,2,3,5}), 1);
    }

    @Test
    public void test00(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{-1,-2,-3,-5}), 1);
    }
    @Test
    public void test1(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{1,2,3,5}), 4);
    }

    @Test
    public void test2(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{}), 1);
    }

    @Test
    public void test3(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{-1}), 1);
    }

    @Test
    public void test4(){
        SmallestMissingNum s = new SmallestMissingNum();
        Assert.assertEquals(s.solution(new int[]{1}), 2);
    }
}
