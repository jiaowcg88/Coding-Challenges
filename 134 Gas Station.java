/**
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

*/

/**
idea: we can use two variables to check whether we can continue traveling . one variable is 'sum' to see if the starting gas station will satisfy the requirement. sum += gas[i] - cost[i], if sum < 0 then, we need restart our traveling at i gas station. We used another variable 'total' to calculate the remaining amount of gas during the total jounery. if the 'total' > 0 ,then we can travel around the circuit once, otherwise return -1;

(Whenever the sum is negative, reset it and let the car start from next point.
In the mean time, add up all of the left gas to total. If it's negative finally, return -1 since it's impossible to finish.
If it's non-negative, return the last point saved in res;)

*/

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost){
		int total = 0, sum = 0;
		int j = -1;
		for (int i = 0; i<gas.length; i++){
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0){
				j = i;
				sum = 0;
			}

		}
		return (total >= 0)? j+1:-1;
	}
}