/*The goal of this exercise is to convert a string to a new string where each character 
in the new string is "(" if that character appears only once in the original string, 
or ")" if that character appears more than once in the original string. 
Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))((" 
 */

import java.util.*;

public class DuplicateEncoder {
	static String encode(String word){
        Map<Character, Integer> m = new HashMap<>();
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            if (m.containsKey(word.charAt(i))) {
                int value = m.get(word.charAt(i));
                m.put(word.charAt(i), ++value);
            } else {
                m.put(word.charAt(i), 1);
            }
        }

        String output = "";
        for (int i = 0; i < word.length(); i++) {
            if (m.get(word.charAt(i)) > 1) {
                //原来还可以这样
                output += ")";
            } else {
                output += "(";
            }
        }

        return output;
    }
}

/*
Best solution:
public class DuplicateEncoder {
	static String encode(String word){
    word = word.toLowerCase();
    String result = "";
    for (int i = 0; i < word.length(); ++i) {
      char c = word.charAt(i);
      result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
    }
    return result;
  }
}
 */