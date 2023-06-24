import java.util.*;
class Intersection {

  // MY SOLUTION
  // Function to find the intersecting points between two intervals
  public static List <Interval> intervalsIntersection(List <Interval> listA, List <Interval> listB) {
    List <Interval> intersections = new ArrayList <>(); // to store all intersecting intervals
    // Your code will replce this placeholder return statement

/*
   a=    [2   6] [7 9] [10 13] [14     19] [20 24]
   b= [1  4] [6    8]            [15 18]

    [2 4] [6 6] [6 8] [15 18]

a[0]=[2 6] i=0
b[0]=[1 4] j=0
out=[ [2 4] ]

a[0]=[2 6] i=0
b[1]=[6 8] j=1 //j++ because b[0].end ends earlier than a[0].end
out=[ [2 4] [6 6] ]

a[0]=[7 9] i=1 //i++ because a[0].end ends earlier than b[1].end
b[1]=[6 8] j=1
out=[ [2 4] [6 6] [7 8]]

... continue until finish one of the lists and there are no more intersections
*/

    int i = 0, j = 0;
    while(i < listA.size() && j < listB.size()) {
      Interval a = listA.get(i);
      Interval b = listB.get(j);
      //is there an intersection
      // if (a.getStart() <= b.getEnd() && a.getStart() >= b.getStart()
      //     || b.getStart() <= a.getEnd() && b.getStart() >= a.getStart()) {}

      // if ((A <= D && A >= B) || B <= C && B >= A) {}


      if (a.getStart() <= b.getEnd() && a.getStart() >= b.getStart()
          || b.getStart() <= a.getEnd() && b.getStart() >= a.getStart()) {
        // capture intersection
        Interval inter = new Interval(Math.max(a.getStart(), b.getStart()),
            Math.min(a.getEnd(), b.getEnd()));
        // add intersection to output list
        intersections.add(inter);
      } 

      // move forward in list where curr end is least
      if(a.getEnd() < b.getEnd()) {
        i++;
      } else {
        j++;
      }
    }

    return intersections;
  }


// GCIP SOLUTION
    public static List<Interval> intervalsIntersection(List<Interval> intervalLista, List<Interval> intervalListb) {
        List<Interval> intersections = new ArrayList<>(); // to store all intersecting intervals
        // index "i" to iterate over the length of list a and index "j"
        // to iterate over the length of list b
        int i = 0, j = 0;
        // while loop will break whenever either of the lists ends
        while (i < intervalLista.size() && j < intervalListb.size()) {
            // Let's check if intervalLista[i] intervalListb[j]
            // 1. start - the potential startpoint of the intersection
            // 2. end - the potential endpoint of the intersection
            int start = Math.max(intervalLista.get(i).getStart(), intervalListb.get(j).getStart());
            int end = Math.min(intervalLista.get(i).getEnd(), intervalListb.get(j).getEnd());
            if (start <= end) // if this is an actual intersection
                intersections.add(new Interval(start, end)); // add it to the list

            // Move forward in the list whose interval ends earlier
            if (intervalLista.get(i).getEnd() < intervalListb.get(j).getEnd())
                i += 1;
            else
                j += 1;
        }
        return intersections;
    }


}