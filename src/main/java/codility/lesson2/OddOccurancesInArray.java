package codility.lesson2;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OddOccurancesInArray {

    /**
     * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
     *
     * For example, in array A such that:
     *
     *   A[0] = 9  A[1] = 3  A[2] = 9
     *   A[3] = 3  A[4] = 9  A[5] = 7
     *   A[6] = 9
     * the elements at indexes 0 and 2 have value 9,
     * the elements at indexes 1 and 3 have value 3,
     * the elements at indexes 4 and 6 have value 9,
     * the element at index 5 has value 7 and is unpaired.
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
     *
     * For example, given array A such that:
     *
     *   A[0] = 9  A[1] = 3  A[2] = 9
     *   A[3] = 3  A[4] = 9  A[5] = 7
     *   A[6] = 9
     * the function should return 7, as explained in the example above.
     *
     * Assume that:
     *
     * N is an odd integer within the range [1..1,000,000];
     * each element of array A is an integer within the range [1..1,000,000,000];
     * all but one of the values in A occur an even number of times.
     * Complexity:
     *
     * expected worst-case time complexity is O(N);
     * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
     */

    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer,Integer> m = new HashMap<>();
        for(int a: A){
            if(m.get(a) == null){
                m.put(a, a);
            } else {
                m.put(a, null);
            }
        }
        for(Integer v: new HashSet<>(m.values())){
            if(v !=null) return v.intValue();

        }
        return 0;
    }

    @Test
    public void testExample(){
        OddOccurancesInArray o = new OddOccurancesInArray();
        assertEquals(o.solution(new int[]{9,3,9,9,7,3,9}), 7);
    }
    @Test
    public void testExample2(){
        OddOccurancesInArray o = new OddOccurancesInArray();
        assertEquals(o.solution(new int[]{1,2,3,4,5,4,3,2,1}), 5);
    }
    @Test
    public void testExampleEmpty(){
        OddOccurancesInArray o = new OddOccurancesInArray();
        assertEquals(o.solution(new int[]{}), 0);
    }
    @Test
    public void testExampleSingleElement(){
        OddOccurancesInArray o = new OddOccurancesInArray();
        assertEquals(o.solution(new int[]{7}), 7);
    }



}
