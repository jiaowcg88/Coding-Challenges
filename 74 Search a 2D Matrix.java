/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/

/**
idea: using binary search to solve this problem
the main point we make this two D array to be one D array to solve,
the row index of element at 2D array can be written be position of 1D array/# columns, 
the column index of element at 2D array can be written be position of 1D array % # columns.
*/

// pay attention to two corner cases, such as input as [], or [[]]
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        int m = matrix.length;   // # of rows
        int n = matrix[0].length; // # of columns
        int start = 0, end = m*n - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (matrix[mid/n][mid%n] == target){
                return true;
            }else if(matrix[mid/n][mid%n] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if (matrix[start/n][start%n] == target)
            return true;
        if (matrix[end/n][end%n] == target)
            return true;
        return false;
        
    }
}