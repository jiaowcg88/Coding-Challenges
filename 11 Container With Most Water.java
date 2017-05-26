/**
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

*/

/**
Idea:
using two pointers to solve this problem.
one pointer starts at the begining of the array, the other pointer starts at the end of the array.
to calculate the area of the container, we do Area = (right - left) * min(height(right), height(left)), to choose the maximum of the Area.
while loop : left < right,
calculate area and choose the maximum area;
if(the height of the right pointer is greater than the height of the left pointer)
    we increment left pointer.
else 
    we decrement right pointer. 



*/

public class Solution {
	public int maxArea(int[] height){
		int left = 0;
		int right = height.length-1;
		int maxArea = 0;
		while (left < right) {
			maxArea= Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));
			if ( height[right] > height[left]){
				left++;
			}else {
				right--;
			}
		}
		return maxArea;
	}
}