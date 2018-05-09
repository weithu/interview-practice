package leet.problems.searchinsertposition;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchInsertPosition {
    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You may assume no duplicates in the array.
     *
     * Example 1:
     *
     * Input: [1,3,5,6], 5
     * Output: 2
     * Example 2:
     *
     * Input: [1,3,5,6], 2
     * Output: 1
     * Example 3:
     *
     * Input: [1,3,5,6], 7
     * Output: 4
     * Example 4:
     *
     * Input: [1,3,5,6], 0
     * Output: 0
     */

    public int searchInsert(int[] nums, int target) {

        if(nums[0] >= target){
            return 0;
        }
        if(nums[nums.length-1] < target){
            return nums.length;
        }

        int lower = 0;
        int upper = nums.length-1;

        boolean greater = true;
        int mid = 0;
        while(lower <= upper){
            mid = (lower+upper)/2;
            int val = nums[mid];
            //System.out.println("mid: " + mid + " val: " + val);

            if( val == target){
                System.out.println("found!");
                return mid;
            }
            else if(val < target){
                lower = mid+1;
                greater = true;
            }
            else{
                greater = false;
                upper = mid-1;
            }
        }

        return greater? mid+1: mid;
    }

    /**
     * Example 1:
     *      *
     *      * Input: [1,3,5,6], 5
     *      * Output: 2
     *      * Example 2:
     *      *
     *      * Input: [1,3,5,6], 2
     *      * Output: 1
     *      * Example 3:
     *      *
     *      * Input: [1,3,5,6], 7
     *      * Output: 4
     *      * Example 4:
     *      *
     *      * Input: [1,3,5,6], 0
     *      * Output: 0
     */
    @Test
    public void existsUpperHalf(){
        SearchInsertPosition sip = new SearchInsertPosition();
        Assert.assertEquals(sip.searchInsert(new int[]{1,3,5,6}, 5), 2);
    }
    @Test
    public void doesNotExistsLowerHalf(){
        SearchInsertPosition sip = new SearchInsertPosition();
        Assert.assertEquals(sip.searchInsert(new int[]{1,3,5,6}, 2), 1);
    }
    @Test
    public void doesNotExistsMax(){
        SearchInsertPosition sip = new SearchInsertPosition();
        Assert.assertEquals(sip.searchInsert(new int[]{1,3,5,6}, 7), 4);
    }
    @Test
    public void doesNotExistsMin(){
        SearchInsertPosition sip = new SearchInsertPosition();
        Assert.assertEquals(sip.searchInsert(new int[]{1,3,5,6}, 0), 0);
    }
}
