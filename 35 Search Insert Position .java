/**
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

/**

using binary search O(logn) to solve this problem
the idea to find the first position of element which is greater than target.
the corner case is that if the target is greater than the last elment, then return the length of array.

*/




public class Solution {
    // find the first postion of element >= target
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int start = 0, end = nums.length -1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }    
            if (nums[start] >= target){
                return start;
            }else if (nums[end] >= target){
                return end;
            }else {
                return nums.length;
            }
    }
}