/** 4-8-2023 3:12PM */
import java.util.*;
public class Main{
    /**
     * Write a function that takes a string s as input and checks whether it’s a palindrome or not.
     * Note: A phrase, word or sequence is a palindrome that reads the same backwards as forwards.
     * Constraints:
     *  1 ≤ s.length ≤ 2×10^5
     *  The string won’t have any spaces and will only consist of ASCII characters.
     */

    /**
     * use two pointers starting from the ends and compare the values while moving towards the
     * middle
     * time: O(N)
     * space: O(1)
     */ 
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return false;

        // left and right are pointers used to compare
        // characters starting from the ends of the string
        // and moving towards the middle
        int left = 0, right = s.length() - 1;

        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}