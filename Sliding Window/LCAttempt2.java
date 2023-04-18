/** 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Pseudo:
 * 
 * max: 3
 * map: { a:0, b:1, c:2}
 * "a b c a b c b b"
 *            s
 *                e
 * 
 * max: 2
 * map: {a:3, b:2}
 * "a b b a"
 *      s
 *        e
 * 
 * max: 0
 * map: 
 * 
 * 
 * loop:
 *      have we seen this character yet? 
 *          no -> add char,pos to the map; 
 *          yes -> update start to 1 in front of where we last saw this character || leave start 
 *                  alone if stored position is behind (start and end should never go backwards),
 *                  update map char to have new position
 *      calculate new max substring length
 *      move end forward
 * 
 */ 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // null or empty string results in length of 0
        if (s == null || s.length() == 0) return 0;

        // store unique character positions
        Map<Character, Integer> charPos = new HashMap<>();


        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            if(!charPos.containsKey(endChar)) {
                charPos.put(endChar, end);
            } else {
                start = Math.max(charPos.get(endChar), start) + 1;
            }

            // max substring length calc using "window" length
            max = Math.max(end - start + 1, max);
        }

        return max;
    }
}