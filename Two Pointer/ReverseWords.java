/** 4-9-23 9:17PM */
import java.util.*;
public class Main{
    public static String reverseWords(String sentence) {
    	// creates a new StringBuilder that is the old String reversed and trimmed of 
    	// leading/trailing white space
    	char[] charArray = sentence.toCharArray();
    	String trimmedStr = cleanSpaces(charArray, charArray.length);
    	StringBuilder sentenceSb = new StringBuilder(trimmedStr);

    	// reverse the whole string using the strRev() function
	    reverseStringBuilder(sentenceSb, 0, sentenceSb.length() - 1);

    	int start = 0, end = 0, length = sentenceSb.length();
    	while (start < length) {
    		// move end pointer up to the last char before a white space or the end of 
    		// the sentence
    		while(end < length && !Character.isWhitespace(sentenceSb.charAt(end))) {
    			++end;
    		}

    		// reverse the word... olleH --> Hello
    		// olleH --> Hlleo --> Hello
    		reverseStringBuilder(sentenceSb, start, end - 1);

    		// move start forward to the end of the current word (into the white space)
    		// and move end 
    		start = end + 1;
    		end++;
    	}

        return sentenceSb.toString();
    }

	// trim leading, trailing and multiple spaces
	static String cleanSpaces(char[] a, int n) {
		// Convert character array to string
		String str = new String(a, 0, n);

		// Trim extra spaces at the beginning and end of the string
		// And replace multiple spaces with a single space
		str = str.replaceAll("\\s+", " ").trim();

		return str;
	}

	// reverse a StringBuilder from position start to poisition end
	static void reverseStringBuilder(StringBuilder sb, int start, int end) {
		while(start < end) {
			char temp = sb.charAt(start);
			sb.setCharAt(start, sb.charAt(end));
			sb.setCharAt(end, temp);
			start++;
			end--;
		}
  	}
}
