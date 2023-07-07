import java.util.*;
/*

3 1 4 2 4
        l r

b=4
w=4=0

resc={0,1,2,3}

*/

      /*
      pseudo
      sort from lightest to heaviest in ascending order
      use 2 pointers - 1 at start and 1 at end (lightest and heaviest persons)
      try to pair up the lightest and heaviest in order to optimize the number of boats!

      */

public class RescueBoats{
   public static int rescueBoats(int[] people, int limit) {
      
        // Sort the array of people in ascending order
        Arrays.sort(people);
        
        // pointers for the lightest and heaviest person
        int left = 0; 
        int right = people.length - 1;

        int boats = 0; 

        // rescue everyone
        while (left <= right) {
            // Check if the lightest and heaviest person can fit on the same boat
            if (people[left] + people[right] <= limit) {
                // If they can, move on to the next lightest person
                left++;
            }
            // next heaviest person
            right--;

            boats++;
        }

        return boats;
   }
}