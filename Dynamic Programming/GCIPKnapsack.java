/*

given n items
knapsack has a max weight capacity
maximize total value of items carried in the knapsack


return 0 if there is no combo of weights whose sum is within the knapsack capacity


*/

import java.util.*;

class FindMaxKnapsackProfit {
    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        // Your code will replace the placeholder below
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        //fill dp with -1's
        for(int i = 0; i < dp.length; i++) {
        	Arrays.fill(dp[i], -1);
        }

        return knapsackHelper(capacity, weights, values, n, dp);
    }

    public static int knapsackHelper (int cap, int[] weights, int[] vals, int n, int[][] dp) {
    	// base case: knapsack is full or no more items to consider
    	if( n == 0 || cap == 0) {
    		return 0;
    	}

    	if(dp[n][cap] != -1) {
    		return dp[n][cap];
    	}


    	// if this item can fit in knapsack compare including it vs excluding it and 
    	//  choose the one that maximizes profit
    	if(weights[n-1] <= cap) {
    		// include this item
    		// add items value + the max value of the knapsack without this item
    		int include = vals[n-1] + knapsackHelper(cap - weights[n-1], weights, vals, n-1, dp);
    		// exclude this item
    		int exclude = knapsackHelper(cap, weights, vals, n - 1, dp);

    		dp[n][cap] = Math.max(include, exclude);
    		return dp[n][cap];
    	}

		// exclude this item
		dp[n][cap] = knapsackHelper(cap, weights, vals, n - 1, dp);
		return dp[n][cap];
    }
}



