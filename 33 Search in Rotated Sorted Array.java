/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

/**
using revised binary search to solve the problem
two condition, if nums[mid] > nums[start], then if target is between nums[start] and nums[mid], to search target at the array between start to mid.else search target at the array between mid to end,
else if nums[mid] < nums[start], then if target is betwen nums[mid] and nums[end], to search target at the array between mid to end else search target the other side. 

*/

// O(logn)
public class Solution {
    public int search(int[]nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > nums[start]){
                if (nums[start] <= target && target <= nums[mid]){
                    end = mid;
                } else {
                    start = mid;
                }
            }else {
                if (nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}