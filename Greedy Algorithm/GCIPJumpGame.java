public class JumpGame{

   /** ITERATIVE APPROACH */
   public static boolean jumpGame(int[] nums) {
      if(nums.length == 1) return true;

      int target = nums.length - 1;

      // traverse array backwards
      for(int i = target - 1; i > -1; i--) {
         // can the target be reached from this postion?
         if(i + nums[i] >= target) {
            // update the target to this position
            target = i;
         } else if (i == 0) {
            // reached the first index with no way to reach target
            return false;
         }
      }

      return true;
   }


   /**  BACKTRACKING APPROACH */
   public static boolean jumpGame(int[] nums) {
      return backtrack(nums, 0);
   }

   public static boolean backtrack(int[] nums, int index) {
      if(index >= nums.length - 1) {
         return true;
      }

      int num = nums[index];
      boolean success = false;
      for(int i = num; i > 0; i--) {
         success = backtrack(nums, index + i);
         if(success == true) {
            return true;
         }
      }
      return false;
   }

}

// 15:30 time to solve
// Note: reversing the array and using a greedy approach is optimal. The BACKTRACKING 
// approach solves in exponential time complexity. The DYNAMIC PROGRAMMING approach 
// results in quadratic time complexity!

/*

0 1 2 3 4
----------
2 3 1 1 4 |
----------
t

target = 4
i = 3
================

0 1 2 3 4
----------
3 2 1 0 4 |
----------
i       t

target = 4
i = 3
*/