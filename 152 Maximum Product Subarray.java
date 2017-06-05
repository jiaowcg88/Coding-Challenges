/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.


*/
/**

the idea, math concept, if mutiply a negative, will make the big number smaller, and make small number bigger. 
takes O(N)

*/



public class Solution {
    public int maxProduct(int[] nums) {
       int result = nums[0];
       int imax = nums[0], imin = nums[0];
       for (int i = 1; i<nums.length ; i++){
           // if mutiply a negative number will make the big number smaller, and make the small numer bigger.
           // so we need to swap them
           if (nums[i] < 0){
               int tmp = imax;
               imax = imin;
               imin = tmp;
           }
           
           // the bigger one should either a current value, or the max * current value
           imax = Math.max(nums[i], imax*nums[i]);
           imin = Math.min(nums[i], imin*nums[i]);
           
           result = Math.max(result, imax);
       }
       
       return result;
    }
}