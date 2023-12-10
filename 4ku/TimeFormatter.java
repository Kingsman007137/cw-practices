//https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java

import java.util.*;

public class TimeFormatter {
    //my solution is stupid
    public static String formatDuration(int seconds) {
        // your code goes here
        if (seconds == 0) {
            return "now";
        }

        int leaveSeconds;
        String ret = "";
        List<Integer> time = new ArrayList<>();
        String[] timeTypes = {"year", "day", "hour", "minute", "second"};
        int years = seconds / (365 * 24 * 60 * 60);
        time.add(years);
        leaveSeconds = seconds % (365 * 24 * 60 * 60);
        int days = leaveSeconds / (24 * 60 * 60);
        time.add(days);
        leaveSeconds = leaveSeconds % (24 * 60 * 60);
        int hours = leaveSeconds / (60 * 60);
        time.add(hours);
        leaveSeconds = leaveSeconds % (60 * 60);
        int minutes = leaveSeconds / 60;
        time.add(minutes);
        leaveSeconds = leaveSeconds % 60;
        seconds = leaveSeconds;
        time.add(seconds);

        for (int i = 0; i < time.size(); i++) {
            if (time.get(i) != 0) {
                ret += time.get(i) + " " + timeTypes[i];
                if (time.get(i) > 1) {
                    ret += "s";
                }
                ret += ", ";
            }
        }

        ret = ret.substring(0, ret.length() - 2); //remove the last ", "
        String[] temp = ret.split(" ");
        if (temp.length > 2) {
            ret = "";
            //the final should add "and"
            temp[temp.length - 3] = temp[temp.length - 3].replace(',', ' ') + "and";
            for (String s: temp) {
                ret += s + " ";
            }
            ret = ret.substring(0, ret.length() - 1); //remove the last " "
        }

        return ret;
    }
}

//     I should do like him, calculate the divisor first, and him combines a lot of redunctory code together to make it clean
//     public static String formatDuration(int seconds) {
//         String res = "";
//         int[] units = new int[] {31536000, 86400, 3600, 60, 1};
//         String[] labels = new String[] {"year", "day", "hour", "minute", "second"};
        
//         if (seconds == 0) return "now";
        
//         for (int i = 0; i < 5; i++) {
//           if (seconds >= units[i]) {
//             int q = seconds / units[i];
//             seconds = seconds % units[i];
//             res += (res.equals("") ? "" : (seconds == 0 ? " and " : ", "))
//                    + q + " " + labels[i] + (q > 1 ? "s" : "");              
//           }
//         }
//         return res;
//     }