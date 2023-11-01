/*In this example you have to validate if a user input string is alphanumeric. 
The given string is not nil/null/NULL/None, so you don't have to check that.

The string has the following conditions to be alphanumeric:

At least one character ("" is not valid)
Allowed characters are uppercase / lowercase latin letters and digits from 0 to 9
No whitespaces / underscore */

public class SecureTester {
    public static boolean alphanumeric(String s) {
        if (s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                return false;    
            }
        }

        return true;
    }

    public static void main(String[] args) {
        alphanumeric("sdfasdfDDUFHAFHA087086");
    }
}

//or just...
//return s.matches("[A-Za-z0-9]+");
