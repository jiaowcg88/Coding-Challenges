/**
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

*/


/**
idea: 
we need to calculate using the number before the current number and the numbers after the current number. Thus, we need to scan
the array twice. First caculate the running product of the part before the current number, second, we calculate the runnin product of the part after the current number through scanning from the end of the array
input: A[a0, a1, a2,a3];
the first output: result[1, a0, a0*a1, a0*a1*a2]
the second output : result [ a1*a2*a3,a0*a2*a3,a0*a1*a3,a0*a1*a2]

*/

// Solution 

public class Solution {
	public int[] productExceptSelf(int[] nums){
		int[] result = new int[nums.length];
		if(nums.length == 0) return result;
		int pre = 1;
		for (int i = 0; i<nums.length; i++){
			result[i] = pre; // mutiple the previous element
			pre *= nums[i]; 
		}

		int post = 1;
		for (int i = nums.length-1; i>=0; i--){
			result[i] *= post;  // mutiple the post element 
			post *= nums[i];
		}
		return result;

	}
}