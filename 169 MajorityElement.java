/**
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example: 


idea: 
solution 1: first sort the array, then return the element at ⌊ n/2 ⌋ , this solution takes O(nlogn)
solution 2: improve the time complexicity to O(n), tranvers the elements in array, first set first element as candidate, if we find the same element, we increment the count,else decrement the count, if count equals 0, then change the candidate to current element.
Sollution 3: using hashtable to count the number of each element occurrences, then return the max one.

*/

// Solution one first sort the array
public class Solution {
	public int majorityElement(int[] nums){
		Arrays.sort(nums);
		int n = nums.length - 1;
		return nums[n/2];

	}
}

// Solution 2 improved the time complexicity to O(n)
 
public class Solution {
	public int majorityElement(int[] nums){
		int candidate = nums[0];
		int count = 0;
		for (int i=0; i< nums.length; i++){
			if(nums[i] == candidate){
				count++;
			}else if(count == 0){
				candidate = nums[i];
			}else{
				count--;
			}
		}
		return candidate;
	}
}