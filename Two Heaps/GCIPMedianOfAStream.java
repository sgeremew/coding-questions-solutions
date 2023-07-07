/*
        i
8 3 5 6 9 3 - median = 5+6/2 = 5.5

3 3 5 6 9 8 - median =

minheap

6
8
9

maxheap

5
3
3


Add to minheap initially

if next val is less than minheap root - add to maxheap
else add to minheap

if minheap.length > maxheap.length + 1 - pop head and add to maxheap
if maxheap.length > minheap.length + 1 - pop head and add to minheap


functions needed: insert, _reorganize, getMedian, constructor
*/


import java.util.*;

class MedianOfAStream {
	PriorityQueue<Integer> leftMaxHeap;
	PriorityQueue<Integer> rightMinHeap;

	public MedianOfAStream() {
		leftMaxHeap = new PriorityQueue<>((a,b) -> b - a);
		rightMinHeap = new PriorityQueue<>(); // default is min-heap
	}

	public void insertNum(int num) {
		if (rightMinHeap.isEmpty()) {
			rightMinHeap.offer(num);
			return;
		}

		if (num < rightMinHeap.peek()) {
			leftMaxHeap.offer(num);
		} else {
			rightMinHeap.offer(num);
		}

		// maintain that left heap and right heap size differs by a max of 1
		// if this invariable is broken - reorgainze
		if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
			rightMinHeap.offer(leftMaxHeap.poll());
		} else if (rightMinHeap.size() > leftMaxHeap.size() + 1) {
			leftMaxHeap.offer(rightMinHeap.poll());
		}

		return;
	}

	public double findMedian() {
		if (leftMaxHeap.isEmpty()) return Double.valueOf(rightMinHeap.peek());
		if (rightMinHeap.isEmpty()) return Double.valueOf(leftMaxHeap.peek());

		double left = Double.valueOf(leftMaxHeap.peek());
		double right = Double.valueOf(rightMinHeap.peek());

		if (leftMaxHeap.size() == rightMinHeap.size()) {
			return (left + right) / 2.0;
		} else if (leftMaxHeap.size() > rightMinHeap.size()) {
			return left;
		} else {
			return right;
		}
	}
}





