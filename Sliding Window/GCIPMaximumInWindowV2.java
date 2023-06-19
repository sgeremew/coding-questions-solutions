import java.util.*;


/**
 * nums = [-4, 2, -5, 3, 6]
 * wSize = 3
 * 
 *
 * [-4,2-5] -> [2, -5, 3] -> [-5, 3, 6]
 * 		2			3			6
 * return [2, 3, 6]
 * 
 * 
 * USE A FUCKING HEAP STOP TRYING TO BE CUTE
 * 
 * --> LOL heap still not the best, use Dequeue instead
 * 
 */ 

class SlidingWindowMaximum {
	public static int[] findMaxSlidingWindow(int[] nums, int w) {
		// pseudo code
		// -> set left and right to 0
		// move right forward by 1 until reach window size
		// add each element to max heap, keeps max element of window at top
		// -> move window forward by moving left and right pointer forward
		// if left pointer is leaving the max value pop it from the max heap
		// add the right pointer value to the max heap
		// the root is the max, add it to ouptput list
		// -> repeat
		// -> return output list

		// max-heap initialization
		// note: b - a can cause overflow for large ints
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		// output list initialization
		int length = 1;
		if (w < nums.length) {
			length = nums.length - w + 1;
		}
		int[] output = new int[length];

		// create first window
		int left = 0, right = 0;
		for (; right < w; right++) {
			maxHeap.offer(nums[right]);
		}
		// add first window max
		output[left] = maxHeap.peek();

		// finish traversing the windows
		while (right < nums.length) {
			if(nums[left] == maxHeap.peek()) {
				maxHeap.poll();
			}

			left++;
			right++;

			maxHeap.offer(nums[right]);
			output[left] = maxHeap.peek();
		}


		return output;
	}
}