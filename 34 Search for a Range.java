/**
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

*/

/**
since requirement of runtime is O(logn), we think that we need to use binary search method to solve this problem
search the middle element, if the middle value is less than target, then we need to search through the right side of the current middle value, if the middle value is greater then target, then we need to search through the left side of the current middle value. the last case is that if the middle value equals the target. then we have to search the right and left side of the current middle value. 

*/

public class Solution {
	public int[] searchRange(int[] nums, int target){
		int[] result = new int[]{-1,-1};  // pay attendtion here
		int left = 0;
		int right = nums.length -1;
		while (left <= right){
			int mid = left + (right - left)/2;
			// if the middle value equals target
			if (nums[mid] == target){
				int i = mid;
				while (i+1 < nums.length && nums[i+1] == target) {// skip the repeating value to find the first different one
					i++;
				}
				result[1] = i;
				int j = mid;
				while (j-1 >= 0 && nums[j-1] == target){ // skip the repeating value to find the first different one
					j--;
				}
				result[0] = j;
				return result;
			} else if (nums[mid] < target){	
				left = mid+1;

			} else {
				right = mid-1;
			}

		}
		return result;

	}
}


// Solution two using binary search template
ublic class Solution {
	public int[] searchRange(int[] nums, int target){
		int[] result = new int[2];
		if (nums.length == 0 ) {
			return new int[]{-1,-1};
		}

		// find the first position of target 
		int start = 0, end = nums.length - 1; 
		while (start + 1 < end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target){
				end = mid;
			}else if (nums[mid] < target){
				start = mid;
			}else {
				end = mid;
			}
		}

		if (nums[start] == target){
			result[0] = start;
		} else if(nums[end] == target){
			result[0] = end;
		} else {
			result[0] = result [1] = -1;
		}
        // find the last position of  target
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end){
			int mid = start + (end - start)/2;
			if (nums[mid] <= target){
				start = mid;
			}else {
				end = mid;
			}
		}
		if (nums[end] == target){
			result[1] = end;
		} else if (nums[start] == target){
			result[1] = start;
		} else {
			result[0] = result [1] = -1;
		}

        return result;
	}
}
