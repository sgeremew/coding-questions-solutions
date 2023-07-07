/*
Greedy algorithm
Builds solution piece by piece
Always makes the choice that seems best at the time (locally-optimal choice)
Used to solve optimization problems
*/

/*

[3,2,0,1,4]

traverse array in reverse

start from last node
ask - can I be reached by the next node [i-1]?
 move i-- and ask again

if you get to the last node and the answer is still no then return false
else return true



3 2 0 1 4
  c
i
canJump = true
 

*/


public class JumpGame{
	public static boolean jumpGame(int[] nums) {
	   	// current node we are checking
	   	int curr = nums.length - 1;

		boolean canJump = true;
	   	// i traverses array in reverse
	   	for(int i = curr - 1; i >= 0; i--) { // stop 1 before the beginning of array
	   		if(nums[i] + i >= curr) {
	   			canJump = true;
	   			curr = i;
	   		} else {
	   			canJump = false;
	   		}
	   	}

	   	return canJump;
   }
}
