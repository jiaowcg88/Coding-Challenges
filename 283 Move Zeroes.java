/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*

/**
idea: 
solution 1: using two pointers, 
traverse the array, if find there is zero, then do not add to the new array, else add to the new array. 
After traversing the entire array,
we add zero the remaining array.

solution 2: swap method,//Solution 2: swap method. there are two index i and j, i to traverse the element in the array,  
and index j to record the element which need to be swapped. 
if find the elment which is not zero, then swap the element at i and j

*/

// Solution 1:
public class Solution {
	public void moveZeroes(int[] nums){
		int index = 0;
		for (int num : nums){
			if(num !=0)
				nums[index++] = num;
		}
		for (int i = index; i<nums.length; i++){
			nums[i] = 0;
		}
	}
}

//Solution 2: swap method. there are two index i and j, i to traverse the element in the array,  and index j to record the element which need to be swapped. if find the elment which is not zero, then swap the element at i and j
public class Solution {
	public void moveZeroes(int[] nums){
		int j = 0;
		for (int i = 0 ; i<nums.length; i++){
			if (nums[i] != 0){
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++; // after swap, increment j
			}

		}
	}
}