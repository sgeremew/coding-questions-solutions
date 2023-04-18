/**
 * Write a function that takes a string as input and checks whether it can be a valid palindrome by 
 * removing at most one character from it.
 */ 

import java.util.*;
public class Main{
    public static boolean isPalindrome(String s) {
        // Write your code here
        // Tip: You may use the code template provided
        // in the TwoPointers.java file

        if(s == null || s.length() == 0) return false;

        int mismatches = 0;
        while(front < back) {
            char frontChar = s.charAt(front);
            char backChar = s.charAt(back);

            if(mismatches > 1) return false;

        }
    
        return true;
    }
}