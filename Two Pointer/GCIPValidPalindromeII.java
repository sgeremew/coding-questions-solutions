/**
 * Write a function that takes a string as input and checks whether it can be a valid palindrome by 
 * removing at most one character from it.
 */ 

import java.util.*;
public class Main{
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;

        // two pointers; one at each end of the string s
        int left = 0;
        int right = s.length() - 1;
        int mismatch = 0;

        while(left < right) {
            if(mismatch > 1) return false;
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            // T E B B E M
            //     L R
            // bad=1
            if(leftChar != rightChar) {
                mismatch++;
                // skip the bad character
                if(right > 0 && leftChar == s.charAt(right - 1)) {
                    right--;
                } else if (left < s.length() - 1 && rightChar == s.charAt(left + 1)) {
                    left++;
                } else {
                    mismatch++;
                    // move pointers towards the middle
                    left++;
                    right--;
                }
            } else {
                // move pointers towards the middle
                left++;
                right--;
            }
        }

        return true;
    }
}