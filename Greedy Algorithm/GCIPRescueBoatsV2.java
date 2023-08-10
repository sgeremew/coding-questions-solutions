import java.util.*;

public class RescueBoats{
/*

Use the least number of boats:
- pair the heaviest person and the lightest person
- pointer at beginning of sorted list and one at the end of the sorted list
- traverse until you overlap/pass pointers

[3, 1, 4, 2, 4] , 4

1 4 4 4 4 (4)
ab

bC=1
w=4

*/

   public static int rescueBoats(int[] people, int limit) {
      // sort in ascending order
      Arrays.sort(people);

      int boatCount = 0;
      int l = 0, r = people.length - 1;
      int weight = 0;

      while(l <= r) {
         int light = people[l];
         int heavy = people[r];

         if(weight + heavy <= limit) {
            weight += heavy;
            r--;
         }
         if(weight + light <= limit) {
            weight += light;
            l++;
         }

         boatCount++;
         weight = 0;
      }

      return boatCount;
   }

}