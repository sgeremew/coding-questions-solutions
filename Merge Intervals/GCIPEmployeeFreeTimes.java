import java.util.*;

class EmployeeFreeTimes {
  public static List <Interval> employeeFreeTime(ArrayList <ArrayList <Interval>> schedule) {
    // Your code will replace this placeholder return statement

    List<Interval> ans = new ArrayList<Interval>();

    // MERGING OR COMPARING K INTERVALS USUALLY REQUIRES A HEAP

    // min-heap sorted by interval start times
    PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.getStart() - b.getStart());

    // add first sched of each employee to the heap
    int firstSchedIndex = 0;
    for(int i = 0; i < schedule.size(); i++) {
      ArrayList<Interval> empSched = schedule.get(i);
      if(firstSchedIndex < empSched.size()) {
        minHeap.offer(empSched.get(firstSchedIndex)); // add interval to heap
      }
    }


    Interval prev = minHeap.peek();
    while(!minHeap.isEmpty()) {
      Interval curr = minHeap.poll();

    }

    return ans;
  }
  
}



//GCIP SOLUTION

public static List<Interval> employeeFreeTime(ArrayList<ArrayList<Interval>> schedule) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Iterate for all employees' schedules
        // and add start of each schedule's first interval along with
        // its index value and a value 0.
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> employeeSchedule = schedule.get(i);
            Interval interval = employeeSchedule.get(0);
            heap.offer(new int[]{interval.getStart(), i, 0});
        }
        
        // Take an empty list to store results.
        List<Interval> result = new ArrayList<>();
        
        // Set 'previous' to the start time of the first interval in heap.
        int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).getStart();
        
        // Iterate until the heap is empty
        while (!heap.isEmpty()) {
            // Poll an element from the heap and get values of i and j
            int[] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];
            
            // Select an interval
            Interval interval = schedule.get(i).get(j);
            
            // If the selected interval's start value is greater than the previous value,
            // it means that this interval is free. So, add this interval
            // (previous, interval's end value) into the result.
            if (interval.getStart() > previous) {
                result.add(new Interval(previous, interval.getStart()));
            }
            
            // Update the previous as the maximum of previous and interval's end value.
            previous = Math.max(previous, interval.getEnd());
            
            // If there is another interval in the current employee's schedule,
            // push that into the heap.
            if (j + 1 < schedule.get(i).size()) {
                Interval nextInterval = schedule.get(i).get(j + 1);
                heap.offer(new int[]{nextInterval.getStart(), i, j + 1});
            }
        }
        
        // When the heap is empty, return the result.
        return result;
    }