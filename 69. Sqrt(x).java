/**
Implement int sqrt(int x).

Compute and return the square root of x.

*/

/**
Math.sqrt(double i), return double type
easy solution: using Math sqrt to solve this problem


*/

public class Solution {
	public int mySqrt(int x){
		double i =(double) x;
		if (x < 0);
		   return x;
		else 
			return (int)Math.sqrt(i);
	}
}


// Solution two, 

public class Solution {
    public int mySqrt(int x){
        if (x <= 0) return x;
        int r = 1;
        while (r <= x/r){
            if (r*r == x)
                return r;
            else 
                r++;
        }
        return r-1;
    }
}

// Solution three using binary search 
public class Solution {
	public int mySqrt(int x){
		if (x== 0) return 0;
		int left = 0, right = Integer.MAX_VALUE;
		while(true){
			int mid = left + (right - left)/2;
			if (mid > x/mid){
				right = mid - 1;
			} else {
				if (mid + 1 > x/(mid+1))
					return mid;
				left = mid + 1;
			}
		}
	}
}

// another method of using binary search
public class Solution {
	public int mySqrt(int x){
		long start = 1, end = x;
		while(start + 1 < end){
			long mid = start + (end-start)/2;
			if (mid*mid <= x){
				start = mid;
			}else {
				end = mid;
			}
		}
		if (end*end <= x)
			return (int)end;
        else
		   return (int)start;
		
	}
}
