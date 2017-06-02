/**
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/


/**
idea:
solution one: Using two boolean type arrays to store whether the row or column has zero or not. then it uses O(m+n) space
the better one: using two boolean values to check whehter the first row or first column has zero or not, then it uses O(1) space

*/


// Solution one:
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // using two boolean array to record to whether there is zero  in row or col
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        // two for loop whether it contains 0
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        // for loop to check whether the row has zero or not, if so then fill the whole row with 0
        for (int i = 0; i< m; i++){
            if(row[i])
              Arrays.fill(matrix[i],0);
        }
        
        // for loop to check whether the column has zero or not, if so then fill the whole column with 0
        for (int j = 0; j<n; j++){
            if(col[j]){
                for(int i = 0; i<m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}



// Solution two:
public class Solution {
	public void setZeroes(int[][] matrix){
		int m = matrix.length;   // number of rows
		int n = matrix[0].length; // number of columns
		boolean row_has_zero = false;
		boolean col_has_zero = false;

		for (int i = 0; i<m; i++){
			for (int j = 0; j<n; j++){
				if (matrix[i][j] == 0){
					matrix [0][j] = 0;
					matrix[i][0] = 0;
					if (i == 0) row_has_zero = true;  // first row has zero
					if (j == 0) col_has_zero = true;  // first column has zero
				}
			}
		}

		//Let the first row as marker to see whether the columns has zero, if so, set the whole column as zero     
		for (int j = 1; j<n; j++){
			if(matrix[0][j] == 0){
				for (int i = 1; i<m; i++){
					matrix[i][j] = 0;
				}
			}
		}

		// Let the first column as marker to see whether the row has zero, if so, se the whole row as zero
		for (int i = 1; i<m; i++){
			if(matrix[i][0] == 0){
				for (int j = 1; j<n; j++)
					matrix[i][j] = 0;
			}
		}

		// if row has zero is true, set the whole row is 0;
		if (row_has_zero){
			for (int j = 0; j<n; j++){
				matrix[0][j] = 0;

			}
		}

		if (col_has_zero){
			for (int i = 0; i<m; i++){
				matrix[i][0] = 0;

			}
		}

	}
}
