import java.util.*;

/*

2  1  0  4  1 -1  2  1 -10  4 -2  5
l           r
continuosly increasing -> currSum = 8

-1 is next.. do we include it?
2  1  0  4  1 -1  2  1 -10  4 -2  5
l                    r

if at any point the subarray sum goes below 0
- stop, check the max, and then restart from next value

-5 -4 -10 -1 0 5
             l  r




*/


public class MaxSubArray{
   public static int maxSubArray(int[] nums) {
      // Your code will replace the placeholder return statement.
      int left = 0;
      int right = 0;
      int sum = 0;
      int max = Integer.MIN_VALUE;

      while(right < nums.length && left <= right) {
         int temp = sum + nums[right];
         
         if(temp <= 0) {
            max = Math.max(Math.max(temp, sum), max);
            left = right + 1;
            right = left;
         } else {
            sum = temp;
            max = Math.max(sum, max);
            right++;
         }
      }
         
      return max;
   }
}