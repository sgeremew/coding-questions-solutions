import java.util.*;

public class Main{
   public static List<String> findRepeatedSequences(String s, int k) {
      // handling bad arguments
      if(s == null || k < 1) return Collections.emptyList();

      // 0 1 2 3 4 5 6 7 8 9
      // A A A A C C C C A A A A C C C C
      //       s
      //             e
      // store substrings into hashmap where the value is the frequency
      
      Map<String, Integer> substringFreq = new HashMap<>();
      StringBuilder substring = new StringBuilder();

      //skip end forward to make a window of size k 
      int end = 0;
      for(;end < k; end++) {
         substring.append(s.charAt(end));
      }

      // first substring has frequency of 1
      substringFreq.put(substring.toString(), 1);
      substring.deleteCharAt(0);

      int start = 1;
      for(end = k; end < s.length(); start++, end++) {
         substring.append(s.charAt(end));
         // increment the frequency
         substringFreq.put(substring.toString(), substringFreq.getOrDefault(substring.toString(), 0) + 1);
         substring.deleteCharAt(0);
      }

      List<String> repeatingSequences = new ArrayList<>();

      for(Map.Entry<String, Integer> entry : substringFreq.entrySet()) {
         if(entry.getValue() > 1) repeatingSequences.add(entry.getKey().toString());
      }

      return repeatingSequences;
   }
}