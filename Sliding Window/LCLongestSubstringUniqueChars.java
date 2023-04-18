class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return -1;
        if(s.length() == 1) return 1;

        int start = 0;
        int end = 1;

        Map<Character, Integer> positions = new HashMap<>();
        positions.put(s.charAt(0), 0);

        int max = positions.size();

        while(end < s.length()) {
            if(positions.containsKey(s.charAt(end))) {
                start = positions.get(s.charAt(end)) + 1;
            }
            positions.put(s.charAt(end), end);
            max = Math.max(max, end - start);
            end++;
        }

        // p:0 w:1
        // p w w k e w
        // 0 1
        //
        return Math.max(max, end - start);
    }
}