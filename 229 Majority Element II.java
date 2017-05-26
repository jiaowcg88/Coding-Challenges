/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

*/

/**
idea: 
this question to find all elements that appear more than ⌊ n/3 ⌋ times, then we know that there are at most 2 elements existing in the input array. Therefore using the same method which is used to solve 169 majority element. But here we choose two candidates, two count. i) If the currrent element equals one of candidate, then we increment the specfic count
ii). if count == 0, then assign the current element to candidate.
iii). else decrement the count.
finally, we have to check whether two candidates are majority elment.

*/
public class Solution{
    public List<Integer> majorityElement(int[] nums){
    	List<Integer> res = new ArrayList<>();
    	if(nums.length == 0) return res;
    	int cnt1 = 0, cnt2 =0;
    	int candidate1 = 0, candidate2 = 0;
    	for (int i = 0; i<nums.length; i++){
    		if(nums[i] == candidate1){
    			cnt1++;
    		}else if(nums[i] == candidate2){
    			cnt2++;
    		}else if(cnt1 == 0){
    			cnt1++;
    			candidate1 = nums[i];
    		}else if(cnt2 == 0){
    			cnt2++;
    			candidate2 = nums[i];
    		}else {
    			cnt1--;
    			cnt2--;
    		}
    	}

	    // to confirm whether these candidate meets the condition that count more than length/3
	    int tcnt1 = 0, tcnt2 = 0;
	    for (int i = 0; i< nums.length; i++){
	    	if(nums[i] == candidate1){
	    		tcnt1++;
	    	} else if(nums[i] == candidate2){
	    		tcnt2++;
	    	}
	    }
	    	if (tcnt1 > nums.length/3)
	    		res.add(candidate1);
	    	if (tcnt2 > nums.length/3)
	    		res.add(candidate2);
	    	return res;
     }
}