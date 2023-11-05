/*Move the first letter of each word to the end of it, then add "ay"
  to the end of the word. Leave punctuation marks untouched.

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !
 */

public class PigLatin {
    public static String pigIt(String str) {
        // Write code here
        String[] strs = str.split(" ");
        String ret = "";
        for (String s: strs) {
            if ((s.charAt(0) >= 'a' && s.charAt(0) <= 'z') || (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z')) {
                s = s.length() > 1 ? s.substring(1) + s.charAt(0) + "ay" : s + "ay";
            }
            ret += s + " ";
        }
        //remove the last space, this no include the char at ret.length() - 1
        ret = ret.substring(0, ret.length() - 1);

        return ret;
    }
}

// regex? never learn that
// public class PigLatin {
//     public static String pigIt(String str) {
//         return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
//     }
// }