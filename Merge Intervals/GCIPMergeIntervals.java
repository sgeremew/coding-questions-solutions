import java.util.*;

class MergeInterval {
/*
provided class
  class Interval {
    int start;
    int end;
    boolean closed;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }
    public int getStart() {
        return start;
    } 
    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }   
    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
  }
  */


  public static List <Interval> mergeIntervals(List <Interval> intervals) {
    // Replace this placeholder return statement with your code

    // two pointers - curr and next
    // if curr interval ends within or after the start of next interval, merge them

    // merge two intervals by setting the start as the earliest of the two and the end
    //  as the latest of the two

    if (intervals == null || intervals.isEmpty()) 
      return Collections.<Interval>emptyList();

    List<Interval> merged = new ArrayList<>();
    Interval temp = null;

    
    Interval curr = intervals.get(0);

    int i = 1;
    while(i < intervals.size()) {

      Interval next = intervals.get(i);

      // they overlap
      if (curr.getEnd() >= next.getStart()) {
        //merge
        curr.setEnd(Math.max(curr.getEnd(), next.getEnd()));
      } else {
        merged.add(curr);
        curr = next;
      }
      i++;
    }

    merged.add(curr);

    /*
           i
    [1,3] [2,5] [3,6]  merged=[]
    curr   next
                 i
    [1,5] [2,5] [3,6]  merged=[]
    curr         next

    [1,6] [2,5] [3,6]  merged=[1,6]
    curr         next

///////////////
           i
    [1,3] [2,5] [6,7]  merged=[]
    curr   next
                 i
    [1,5] [2,5] [6,7] merged=[[1,5]]
                 next
                 curr
                     i
    [1,5] [2,5] [6,7] merged=[[1,5], [6,7]]
                 curr             
      

*/

    return merged;
  }
}



