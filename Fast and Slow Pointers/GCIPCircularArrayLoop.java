/**
 * Circular Array Loop:
 * An input array, nums containing non-zero integers, is given, where the value at each index 
 * represents the number of places to skip forward (if the value is positive) or backward (if the 
 * value is negative). When skipping forward or backward, wrap around if you reach either end of 
 * the array. For this reason, we are calling it a circular array. Determine if this circular 
 * array has a cycle. A cycle is a sequence of indices in the circular array characterized by the 
 * following:
 * 
 * • The same set of indices is repeated when the sequence is traversed in accordance with the 
 *    aforementioned rules. 
 * • The length of the sequence is at least two.
 * • The loop must be in a single direction, forward or backward.
 * 
 * Constraints:
 * • 1 ≤ nums.length ≤ 10^4
 * • -5000 ≤ nums[i] ≤ 5000
 * • nums[i] != 0
 */ 


// circular array if you wrap around atleast one end of the array AND only ONE DIRECTION
import java.util.*;
public class CircularArrayLoop{
   public static boolean circularArrayLoop(int[] nums) {
      // Your code will replace this placeholder return statement

      // if direction changes than this is not a circular array (from this starting postion)

      for(int i = 0; i < nums.length; i++) {
         int slow = i;
         int fast = i;
         boolean direction = nums[i] > 0; // TRUE == forward, FALSE == backwards;

         while (TODO) {
            slow = getNextIndex(slow);
            fast = getNextIndex(fast);
            if (nums[slow] > 0 != direction) break;
            fast = getNextIndex(fast);
            if (nums[fast] > 0 != direction) break;

            if (slow == fast) return true;
         }
      }
        
      return false;
   }

   // calculate the next index based on the current index and the value in nums array[i]
   public static int getNextIndex (int [] nums, int currIdx) {
      int length = nums.length;
      int moves = nums[currIdx]; // number of times to move

      // length is 5 [ 4, 13, 2, -7, -15 ]
      // currIdx = 4; val = -9;
      // newIdx = 4 + (- 15) = -11 + 5 = -6 + 5 = -1 + 5 = 4;
      // newIdx = 1 + 13 = 14 - 5 = 9 - 5 = 4;

      // val + currPos = temp;
      // if (temp < 0)
      //   loop: temp += length while temp < 0;
      // else if (temp >= length)
      //   loop: temp -= length while temp >= length;

      int nextIdx = moves + currIdx;

      // while (nextIdx < 0) {
      //    nextIdx += length;
      // }

      // while (nextIdx >= length) {
      //    nextIdx -= length;
      // }

      return nextIdx%length;

   }

   /**
    * 
    * GCIP's answer -- DID NOT FINISH MINE
    */ 

      public static boolean circularArrayLoop(int[] nums) {
    // Set slow and fast pointer at first element.
    int slow = 0, fast = 0;
    int size = nums.length;
    for (int i = 1; i <= size; i++) {
      // Save slow pointer's value before moving.
      int prev = slow;
      // Move slow pointer to one step.
      slow = nextStep(slow, nums[slow], size);
      // Check if cycle is impossible, then set both pointers to next value
      // and move to the next iteration.
      if (isNotCycle(nums, prev, slow)) {
        fast = i;
        slow = i;
        continue;
      }
      // This flag indicates whether we need to move to the next iteration.
      boolean nextIter = false;
      // Number of moves of fast pointer.
      int moves = 2;
      for (int j = 0; j < moves; j++) {
        // Save fast pointer's value before moving.
        prev = fast;
        // Move fast pointer check cycle after every move.
        fast = nextStep(fast, nums[fast], size);
         // If cycle is not possible, set slow and fast to next element
         // set 'next_iter' to true and break this loop.
        if (isNotCycle(nums, prev, fast)) {
          fast = i;
          slow = i;
          nextIter = true;
          break;
        }
      }
      // Move to the next iteration
      if (nextIter) {
        continue;
      }
      // If both pointers are at same position after moving both, a cycle is detected.
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  // A function to calculate the next step.
  private static int nextStep(int pointer, int value, int size) {
    int result = (pointer + value) % size;
    if (result < 0) {
      result += size;
    }
    return result;
  }

  // A function to detect a cycle doesn't exist
  private static boolean isNotCycle(int[] nums, int prev, int pointer) {
    // If signs of both pointers are different or moving a pointer takes back to the same value,
    // then the cycle is not possible, we return True, otherwise return False.
    if ((nums[prev] >= 0 && nums[pointer] < 0) || (Math.abs(nums[pointer] % nums.length) == 0)) {
      return true;
    } else {
      return false;
    }
  }
}