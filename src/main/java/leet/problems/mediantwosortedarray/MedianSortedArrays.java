package leet.problems.mediantwosortedarray;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MedianSortedArrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * <p>
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * The median is 2.0
     * Example 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1==null && nums2 ==null) || (nums1.length ==0 && nums2.length ==0)){
            return 0;
        }
        int[] fullList;
        if(nums1 == null || nums1.length == 0){
            fullList = nums2;
        }
        else if (nums2 == null || nums2.length == 0){
            fullList = nums1;
        }
        else{
            fullList = new int[nums1.length+nums2.length];
            int j=0;
            int k=0;
            for(int i=0; i<nums1.length+nums2.length; i++){
                if(j >= nums1.length){
                    fullList[i] = nums2[k];
                    k++;
                } else if ( k >= nums2.length) {
                    fullList[i] = nums1[j];
                    j++;
                } else {
                    if (nums1[j] < nums2[k]) {
                        fullList[i] = nums1[j];
                        j++;
                    } else {
                        fullList[i] = nums2[k];
                        k++;
                    }
                }
            }
        }

        if(fullList.length%2 == 0){//even
            double v= fullList[fullList.length/2] + fullList[fullList.length/2-1];
            return v/2;
        }
        return fullList[fullList.length/2];
    }

    @Test
    public void baseCase1Test(){
        MedianSortedArrays msa = new MedianSortedArrays();
        Assert.assertEquals(msa.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 2.0);
    }


    @Test
    public void baseCase2Test(){
        MedianSortedArrays msa = new MedianSortedArrays();
        Assert.assertEquals(msa.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 2.5);
    }
}
