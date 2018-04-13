package problems.twosum;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            int pos = findInArray(nums, diff);
            if(pos != -1 && pos != i) {
                return new int[]{i, pos};
            }
        }
        return new int[2];
    }

    public int findInArray(int[] n, int target){
        for(int i =0; i<n.length;i++){
            if(n[i] == target){
                return i;
            }
        }
        return -1;
    }

    @Test
    public static void baseTest(){
        TwoSum twoSum = new TwoSum();
        Assert.assertEquals(twoSum.twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
    }

    @Test
    public static void scatteredTest(){
        TwoSum twoSum = new TwoSum();
        Assert.assertEquals(twoSum.twoSum(new int[]{2,4,7,11,15}, 22), new int[]{2,4});
    }

    @Test
    public static void multipleAnswersTest(){
        TwoSum twoSum = new TwoSum();
        Assert.assertEquals(twoSum.twoSum(new int[]{2,4,5,6,7,15}, 11), new int[]{1,4});
    }

}
