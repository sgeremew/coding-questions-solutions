import java.util.*;
public class Main{
    public static String minWindow(String s, String t) {
        
        // your code will replace the following placeholder return statement

        // find the minimum length substring, substringS, in s where t is a substring of substringS

        /*

        PSEUDO CODE
        // forwards to find the end of window
        loop through s from 0 -> s.length - 1 using index i
            loop through t from 0 -> t.length - 1 using index j
                only move j forward when s[i] == t[j]
            end loop when j == t.length or when i == s.length
            if j == t.length, then we found every character of t in a window of s
                save i as the end of the window

            loop backwards to find minimu window subsequence

        // repeat the above starting from the 2nd character in window
        // continue doing this until the end of s has been reached
        // return the minimum window





        */


        // string and substring tings
        int sLength = s.length();
        int tLength = t.length();
        int mainIndex = 0;
        int tIndex = 0;
        // window tings
        int start = 0,end = 0;
        String minSubsequence = "";
        int length = Integer.MAX_VALUE;

        // stop when all characters been considered
        while (mainIndex < sLength) {
            // found substring char in main string
            if (s.charAt(mainIndex) == t.charAt(tIndex)) {
                tIndex += 1;
                // found ALL substring chars in main string
                if (tIndex == tLength) {
                    // initialize start and end of window
                    start = mainIndex;
                    end = mainIndex + 1;
                    tIndex -= 1;
                    // loop backwards to find minimum window subsequence
                    while (tIndex >= 0) {
                        if (s.charAt(start) == t.charAt(tIndex)) {
                            tIndex -= 1;
                        }
                        start -= 1;
                    }
                }
                start += 1;
                if ((end - start) < length) {
                    length = end - start;
                    minSubsequence = s.substring(start, end);
                }
                // start the process again from the second character of the window
                mainIndex = start;
                tIndex = 0;
            }
            mainIndex += 1;
        }
        
        return minSubsequence;
    }
}