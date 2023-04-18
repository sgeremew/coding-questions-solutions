import java.util.*;

class SlidingWindowMaximum {
	public static int[] findMaxSlidingWindow(int[] nums, int w) {
		// your code will replace the placeholder return statement below

		List<Integer> result = new ArrayList<>();
		// max number will always be at the top
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

		// initially fill max heap with first window max
		int end = 0;
		for(; end < w; end++) {
			maxHeap.add(nums[end]);
		}
		result.add(maxHeap.peek());

		int start = 0;
		for(end = w; end < nums.length; start++, end++) {
			if(nums[start] == maxHeap.peek()) {
				maxHeap.poll();
			}
			maxHeap.add(nums[end]);
			result.add(maxHeap.peek());
		}

		int[] resultArr = new int[result.size()];
		for(int i = 0; i < resultArr.length; i++) {
			resultArr[i] = result.get(i).intValue();
		}

		return resultArr;
	}
}
