import java.util.*;

public class Main{
    public static int calculator(String expression) {
        int number = 0; // current developing number
        int sign = 1; // sign +/-
        int result = 0; // the left hand evaluted portion

        Stack<Integer> components = new Stack<>();

        // iterate characters in the expression
        for(char c : expression.toCharArray()) {
            if(c - '0' >= 0 && c - '0' <= 9) {
                number *= 10;
                number += c - '0';
            } else if (c == '(') {
                // save the current result and sign
                components.push(result);
                components.push(sign);
                result = 0;
                sign = 1;
            } else if (c == '+' || c == '-') {
                result += (number * sign);
                if (c == '+') sign = 1;
                else sign = -1;
                number = 0;
            } else if (c == ')') {
                result += (number * sign);
                int savedSign = components.pop();
                result *= savedSign;

                int savedNumber = components.pop();
                result += savedNumber;
                number = 0;
            }
        }

        return result + number * sign;
    }
}

// 28 min DID NOT SOLVE stuck on the case of c == ')'