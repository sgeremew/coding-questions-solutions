/** 4-8-2023 3:32PM */
import java.util.*;

public class SumOfThree{


   /**
    * Sort the array first. This prevents us from writing an O(N^3) solution. Now set the first 
    * value int the array i=0 and then two pointers, one at i+1 (low) and one at the end (high). 
    * Traverse the right side while low < high and look for the target which can be rewritten as 
    * newTarget = target - nums[i]. If not found, increment i and try the while loop search again.
    */ 
   public static boolean findSumOfThree(int[] nums, int target) {
      
      Arrays.sort(nums); // sorts nums in ascending order O(NlogN) time
      // nums = [1,2,4,6,8,20] target = 16

      //nums[i] + nums[low] + nums[high] = target
      //nums[low] + nums[high] = target - nums[i]
      // rename target - nums[i] --> newTarget
      for(int i = 0; i < nums.length - 2; i++) {
         int newTarget = target - nums[i];
         int low = i + 1, high = nums.length - 1;

         // use low and high pointers to solve for newTarget
         while(low < high) {
            int sum = nums[low] + nums[high];
            if(sum == newTarget) return true;

            if(sum < newTarget) {
               int oldLow = low;
               while(nums[low] == nums[oldLow]) low++;
            } else {
               int oldHigh = high;
               while(nums[high] == nums[oldHigh]) high--;
            }
         }
      }

      return false;
   }
}