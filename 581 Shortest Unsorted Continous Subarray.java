/**
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

*/

/**
using sort method, compare the element in unsorted and sorted, then find the start index of the unsorted continuous subarray and the end index of the unsorted continuous subarray. using two while loop and two pointers, start and end pointer. if tmp[start] = nums[start], then keep in while loop until find the first index that two elements are different. in the second while loop, if tmp[end] = nums[end], keep in while loop until find the last index that two elements are different. then return end - start + 1;

*/


public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = new int[nums.length];
        int index = 0;

        for (int num : nums){
            tmp[index++] = num;
        }
        Arrays.sort(tmp);
        int start = 0;
        int end = nums.length -1;
        while ( start <= nums.length-1 && tmp[start] == nums[start]) start ++;
        while ( end > start && tmp[end] == nums[end]) end--;
        return end - start +1;
        
    }
}