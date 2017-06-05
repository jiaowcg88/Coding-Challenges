/**
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

*/

/**
using two pointers to solve this problem

*/

public class Solution {
	public List<String> summaryRanges(int[]nums){
		List<String> list = new ArrayList<>();
		if(nums.length == 1){
		  list.add(nums[0] + "");
		  return list;
		}
		for (int i = 0 ; i<nums.length; i++){
			int a = nums[i];
			while (i+1<nums.length && nums[i]+1 == nums[i+1]){
				i++;
			}
			if (a != nums[i]){
				list.add(a + "->" + nums[i]);
			} else {
				list.add(a + "");
			}
		}
		return list;

	}
}