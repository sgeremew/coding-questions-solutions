import java.util.*;

class SlidingWindowMaximum {

/*


nums = [ -4, 2, -5, 6, 3 ]
w = 3

-4,  2, -5,  6,  3
         l       r

currWin = 6, 3
// when entering a new element into the window, we iterate over currWin 
// backwards and remove any elements equal to or less than the new element 
// because they will never be the max of any following windows!!!

max = [2,]

*/

	// method to remove candidates from being a potential max in the currentWindow
	public static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
		while (currentWindow.size() != 0 && nums[i] >= nums[currentWindow.getLast()]) {
			currentWindow.removeLast();
		}
		return currentWindow;
	}

	// function to find the maximum in all possible windows
	public static int[] findMaxSlidingWindow(int[] nums, int w) {
		// no nums, return empty list
		if (nums.length == 0) {
			return new int[0];
		}

		// if window is larger than the nums list, get the max of the entire list
		if (w > nums.length) {
			w = nums.length;
		}

		// output list will be of length --> nums length - windowSize + 1
		// nums.length = 5; w = 3;
		// output.length = 5 - 3 + 1 == 3
		int [] output = new int[nums.length - w + 1];

		// reduce push and pop time to O(1) with deque vs O(w) for an array
		Deque<Integer> currentWindow = new ArrayDeque<>();
		// store indexes in deque to reduce access time when indexing nums array
		// establish first window
		for (int i = 0; i < w; i++) {
        	currentWindow = cleanUp(i, currentWindow, nums);
			currentWindow.add(i);
		}

		// deque is maintained in descending order so max is always first
		output[0] = nums[currentWindow.getFirst()];
		
		// iterate from 2nd window until the end of nums array
		for (int i = w; i < nums.length; i++) {
			cleanUp(i, currentWindow, nums);
			// if the currentWindow max is outside of the window, get rid of it
			if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
				currentWindow.removeFirst();
			}
			currentWindow.add(i);
			// store currentWindow's max
			output[i - w + 1] = nums[currentWindow.getFirst()];
		}
		return output;
	}
}