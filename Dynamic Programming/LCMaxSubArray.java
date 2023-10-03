class Solution {

    /*

    [-2, 1,-3, 4,-1, 2, 1,-5, 4]
    i

    anytime nextNum + sum <= 0 restart creating sub array from nextNum
    - why? because [-3,1,-2] -3+1 = -2 but 1 > -2 so we shouldn't even
      consider adding them

    while loop from 0 - num.length-1 {
        if(num[next] + sum <= 0) {
            sum = 0;
            curr = next;
            max = Math.max(max, num[curr]);
        } else {
            sum += num[next];
            max = Math.max(max, sum);
        }
    }
    */
    /** 10-2-2023: Kadane's Algorithm makes this an Easy tier problem */
    public int maxSubArray(int[] nums) {
        
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(nums[i] + sum <= 0) {
                sum = 0;
            } else {
                sum += nums[i];
                temp = sum;
            }
            max = Math.max(max, temp);
            // System.out.printf("i:%d, sum:%d, max:%d\n-----\n",
            // i,sum,max);
        }

        return max;
    }

/*

[-2, 1,-3, 4,-1, 2, 1,-5, 4]
        i
[-2, 1, ,        ]
 max = -2
 -----
 dp[1] = Math.max(dp[1-1] + nums[1], nums[1])
 dp[1] = Math.max(-2 + 1, 1)
 dp[1] > max? update
 max = 1
 -----
 dp[2] = Math.max(dp[2-1] + nums[2], nums[2])
 dp[2] = Math.max(1 + -3, -3) = -2
 dp[2] > max? update
 max = -2
 ------
 dp[3] = Math.max(dp[3-1] + nums[3], nums[3])
 dp[3] = Math.max(-2 + 4, 4)
 dp[3] > max? update
 max = 4
 ------
 etc

*/
    /** 10-2-23: Dynamic Programming approach - bottom up*/
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];
        int max = nums[0];
        dp[0] = nums[0];
        System.out.println("dp: " + arrayToString(dp));
        for(int i = 1; i < nums.length; i++) {
            System.out.printf("----\ni:%d, max:%d\n",i,max);

            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if(dp[i] > max) {
                max = dp[i];
            }
            System.out.printf(">>> dp[i-1]:%d, dp[i]:%d\n",
            dp[i-1],dp[i]);
            System.out.println("dp: " + arrayToString(dp));
        }

        return max;
    }

    public String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if(i < array.length - 1 ){
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }






}