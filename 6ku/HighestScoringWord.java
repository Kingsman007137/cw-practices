//https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/java
/*Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
For example, the score of abad is 8 (1 + 2 + 1 + 4).
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid. */

public class HighestScoringWord {
    public static String high(String s) {
        int highest = 0;
        int score = 0;
        String ret = "";
        String[] words = s.split(" ");
        for (String str : words) {
            score = 0;
            for (int i = 0; i < str.length(); i++) {
                score += str.charAt(i) - 'a' + 1;
            }
            if (score > highest) {
                highest = score;
                ret = str;
            }
        }

        return ret;
    }
}