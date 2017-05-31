/**

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/

/**
idea: if the running time is not required, we can solve this problem by sorting this array then find the longest sequence.

However, it is required that the algorithm should run in O(n) complexity.
We think it may can use hashSet to solve this problem. 
First we save all elements in a set, then traverse the element in a set. For each element, we try to find the decresing consecutive squence and 
the increasing consecutive sequence. Then compare the longest sequence. 
*/

public class Solution {
	public int longestConsecutive(int[] nums){
		HashSet<Integer> mySet = new HashSet<>();
		for (int num : nums){
			mySet.add(num);
		}
		int longest = 0;
		for (int num : nums){
			int length = 1;
			for (int i = num - 1; mySet.contains(i); i--){
				mySet.remove(i);
				length++;
			}
			for (int j = num + 1; mySet.contains(j); j++){
				mySet.remove(j);
				length++;
			}
			longest = Math.max(longest, length);
		}
		return longest;
	}
}