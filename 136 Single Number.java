/**
Given an array of integers, every element appears twice except for one. Find that single one.

*/

/**
idea: using XOR to solve, if two element is same, XOR is 0, else is 1. 

*/

public class Solution {
	public int singleNumber(int[] nums){
		int result = nums[0];
		for (int i = 1; i<nums.length; i++){
			result ^= nums[i];
		}
		return result;
	}
}