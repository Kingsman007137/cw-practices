//https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/java

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        // Write your code here
        Map<Character, Integer> m = new HashMap<>();
        text = text.toLowerCase();
        int cnt = 0;

        for (int i = 0; i < text.length(); i++) {
            if (m.containsKey(text.charAt(i))) {
                int value = m.get(text.charAt(i));
                m.put(text.charAt(i), ++value);
            } else {
                m.put(text.charAt(i), 1);
            }
        }

        for (Character c : m.keySet()) {
            if (m.get(c) > 1) {
                cnt ++;
            }
        }
        return cnt;
    }
}

// public class CountingDuplicates {
//   public static int duplicateCount(String text) {
//     int ans = 0;
//     text = text.toLowerCase();
//     while (text.length() > 0) {
//       String firstLetter = text.substring(0,1);
//       text = text.substring(1);
//       if (text.contains(firstLetter)) ans ++;
//       text = text.replace(firstLetter, "");
//     }
//     return ans;
//   }
// }
