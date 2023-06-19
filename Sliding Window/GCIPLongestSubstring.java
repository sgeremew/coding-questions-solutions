import java.util.*;
public class Main{
    public static int findLongestSubstring(String str) {
        // your code will replace this placeholder return statement



        /*

        PSEUDO CODE:

        a, b, c, d, e, f, g, a, b, c, a, b, c, d, e, f, g, h
                             l        r

        freq = {a, b, c, }
        currWindowSize = 7
        max = 7

        abcaaaa

        l and r start at 0
        move r to the right while adding chars to freq map
          if char is not in freq add it
            move r to the right (make window bigger)
            save curr size of window and update max size

          if char is a duplicate in freq 
            loop l to the right deleting any chars from the map until one past the duplicate
            reset currWindowSize to freq map size

        */



        if (str == null) return -1;

        // window map with character counts
        Map<Character> window = new HashMap<>();

        int max = 0;
        int windowSize = 0;
        int left = 0, right = 0;

        for(; right < str.length(); right++) {
            Character newChar = new Character(str.charAt(right));

            if(!window.containsKey(newChar) {
                window.put(newChar, 1);
                windowSize = window.size();
                max = Math.max(max, windowSize);
            } else {
                for(; left < right; left++) {
                    if(newChar.equals(str.charAt(left).valueOf())) {
                        break;
                    }
                    window.remove(str.charAt(left));
                }
            }
        }
        /*

        a, b, c, d, e, f, g, a, b, c, a, b, c, d, e, f, g, h
                                      l                    r
        window = {a:1, b:1, c:1, d:1 , e, f, g, h:1}
        windowSize = 8
        max = 8

        */




        return max;
    }
}