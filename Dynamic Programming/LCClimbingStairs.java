class ClimbingStairs {
    /*

                n=2
        /               \
    n=1,r=1             n=0,r=1
    /     \             /       \
 n=0,r=1   n=-1X  n=-1X         n=-2X

                        n=4,r=5
                /                       \
             n=3,r=3                      n=2,r=2
            /         \                 /       \
        n=2,r=2      n=1,r=1          n=1,r=1   n=0,r=1
        /    \        /     \         /   \      / \
    n=1,r=1 n=0,r=1 n=0,r=1 n=-1. n=0,r=1 n=-1  X   X

    pattern? --v
        n=0 returns 1
        n=1 returns 1
        n=2 returns 2
        n=3 returns 3
        n=4 returns 5 --> theres 3 ways for n-1 and 2 ways for n-2
                            3+2 = 5 ways for n
                            n = n-1 + n-2

    */

    // good but needs time improvement -- use memoization
    // save known path outcomes in a cache
    public int climbStairs(int n) {
        int[] cache = new int[n+1];

        return climbOptimized(n, cache);
    }

    public int climbOptimized(int n, int[] cache) {
        if(n == 0 || n == 1)
            return 1;
        if(n < 0)
            return 0;
        
        if(cache[n] > 0)
            return cache[n];
        cache[n] = climbOptimized(n-1, cache) + climbOptimized(n-2, cache);

        return cache[n];
    }

/********************************************************************************/
/********************************************************************************/
/********************************************************************************/

    // we have figured out that the number of ways to reach
    // n is (n-1) + (n-2)
    // so if we treat this as a dp bottom up approach we can use
    //   dp[i] is n
    //   so dp[i] = dp[i-1] + dp[i-2]
    public int climbStairsBottomUp(int n) {
        int[] dp = new int[n+1];

        // base cases
        dp[0] = 1;
        dp[1] = 1;

        // bottom up approach using our rule
        for(int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
}