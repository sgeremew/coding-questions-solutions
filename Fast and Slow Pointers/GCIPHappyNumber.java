/**
Identify if repeatedly computing the sum of squares of the digits of number 19 results in 1

n=19

slow: 1 + 81 = 82
fast: 64 + 4 = 68

slow: 68
fast: 36 + 64 = 100 => 1 + 0 + 0 = 1*** return true

You can use Fast and Slow pointers approach to solve this sum of squares question.

*/

/**
 * Happy Number
 * Write an algorithm to determine if a number n is happy.
 *
 *	A happy number is a number defined by the following process:
 *
 *	- Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *	- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *	- Those numbers for which this process ends in are happy.
 *	Return TRUE if n is a happy number, and FALSE if not.
 *
 *	Constraints: 1 ≤ n ≤ 2^31 − 1  
 */ 

public class Main{
    public static boolean isHappyNumber(int n) {
        if(n == 1) return true;

        int slow = calcSumOfSquares(n);
        int fast = calcSumOfSquares(calcSumOfSquares(n));

        while (fast != 1) {
            if (slow == fast) return false;
        	slow = calcSumOfSquares(slow);
        	fast = calcSumOfSquares(calcSumOfSquares(fast));
        }

        return true;
    }

    public static int calcSumOfSquares(int n) {
    	int sum = 0;
/*
		EXAMPLE:
		n > 10? true
    	827 % 10 = 7;
    	sum += 7*7; // sum == 49
    	n = 827/10 = 82;

		n > 10? true
    	82 % 10 = 2;
    	sum += 2*2; // sum == 49 + 4 == 53
    	n = 82/10 = 8;

		n > 10? false
    	sum += 8*8; // sum == 53 + 64 == 117

    	return 117;
*/
    	while (n >= 10) {
    		int digit = n % 10;
    		sum += digit*digit;

    		n /= 10;
    	}
    	sum += n*n;

    	return sum;
    }
}
