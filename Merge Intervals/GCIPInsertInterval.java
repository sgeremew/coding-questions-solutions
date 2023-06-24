// insert new interval while maintaining sorted order and non-overlapping
// may need to join intervals together to maintain non-overlapping

import java.util.*;
class InsertInterval {
	// given class
	class Interval{
	    int start;
	    int end;
	    boolean closed;
	    public Interval(int start, int end)
	    {
	        this.start = start;
	        this.end = end;
	        this.closed = true; // by default, the interval is closed
	    }
	    public int getStart()
	    {
	        return start;
	    }
	        
	    public int getEnd(){
	        return end;
	    }
	    public void setEnd(int end)
	    {
	        this.end = end;
	    }
	        
	    // set the flag for closed/open
	    public void setClosed(boolean closed)
	    {
	        this.closed = closed;
	    }
	    
	}


	// WRONG answer
 	public static List <Interval> insertInterval(List <Interval> existingIntervals,
 	 																Interval newInterval) {
    	List <Interval> output = new ArrayList <Interval> ();

    	// Write your code here

    	// exist = [[1,3], [4,5], [7, 8] [9, 12] [13, 14]]
    	// new = [2,10]

    	/*
    	i=0
    	c=[1,3] n=[2,10]
    	out=[ [1,3] ]



    	*/

    	int length = existingIntervals.size();
    	Interval temp = new Interval(newInterval.getStart(), newInterval.getEnd());

    	for(int i = 0; i < length; i++) {
    		// where do we insert and when do we join
    		Interval curr =  existingIntervals.get(i);

    		// insert newInterval before curr 
    		if (temp.getStart() < curr.getStart()) {
    			if (i > 0) {
    				Interval prev = existingIntervals.get(i-1);
    				if (prev.getEnd() > temp.getStart()) {
    					//join newInterval and prev
    					// prev=[2,5] curr=[6,8] n=[3,7] 
    					temp = new Interval(prev.getStart(), Math.max(prev.getEnd(), temp.getEnd()));
    					// n=[2,7] curr=[6,8]
    				}
    			}
    			
				for (;temp.getEnd() >= curr.getStart() && i < length; i++) {
					curr = existingIntervals.get(i);
					// n=[2,7] curr=[6,8]
					//join newInterval and curr
					temp.setEnd(Math.max(curr.getEnd(), temp.getEnd()));
					// n=[2,8]
				}
				output.add(temp);
    		} else if (temp.getStart() < curr.getEnd()) {
    			temp = new Interval(curr.getStart(), Math.max(curr.getEnd(), temp.getEnd()));
    		} else {
    			output.add(curr);
    		}
    	}


    	return output;
  	}
}










