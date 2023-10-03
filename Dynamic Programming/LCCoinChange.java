class Solution {
    /*
c=[1  2  5]
a=11

                      125
         1             2             5
     1   2   5     1   2   5     1   2   5
    125 125 125   125 125 125   125 125 125

        1. 2. 5.  amount=11

dp[0] = 0
dp[1] = 1 
dp[2] = 1 (dp[2-1] = dp[1] = 1 + 1 = 2 vs coins[2] = 1)
dp[3] = 2 (dp[3-1] = dp[2] = 1 + 1 = 2, dp[3-2] = dp[1] + 1 = 2, dp[3-5] = dp[-2] XXX
dp[4] = 2 (dp[4-1] = dp[3] + 1 = 3, dp[4-2] = dp[2] + 1 = 2, dp[4-5] = dp[-1] XXX

    */
    public int coinChange(int[] coins, int amount) {
        // init dp array
        int[] dp = new int[amount + 1];
        // fill with larger number to know which problems are unsolved
        Arrays.fill(dp, amount+1);
        // init amount=0 to 0 coins
        dp[0] = 0;

        for(int currAmount = 1; currAmount < (amount + 1); currAmount++) {
            for(int coin : coins) {
                if(currAmount - coin >= 0) {
                    dp[currAmount] = Math.min(dp[currAmount - coin] + 1, dp[currAmount]);
                }
            }
        }
        // if dp[amount] > amount than we could not solve problem, return -1
        // else return the number of coins
        return dp[amount] > amount ? -1 : dp[amount];
    }
}