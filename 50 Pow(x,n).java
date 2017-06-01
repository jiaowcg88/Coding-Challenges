/**
implement pow(x,n)
*/

/**
using two solutions
first : using math pow(double a, double b) method to solve 
second: using binary search, recursion to solve


*/

// Solution one
public class Solution {
	public double myPow(double x, int n){
		double i = (double)n;
		return Math.pow(x,i);
	}
}

// Solution two (O(logn))
public class Solution {
	public double myPow(double x, int n){
		double temp = 0.0d;
		if (n==0) return 1;
		temp = myPow(x,n/2);   // like the medium value
		if (n % 2 == 0){
			return temp*temp;
		}else {
			if (n>0){
				return x*temp*temp;
			}else {
                return temp*temp/x;
			}
		}

	}
}