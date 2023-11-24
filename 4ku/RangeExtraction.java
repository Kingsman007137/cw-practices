// https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/train/java

import java.util.*;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {
        if (arr.length == 1) {
            return arr[0] + "";
        }

        String res = "";
        Queue<Integer> q = new LinkedList<>(); // "FIFO" is useful
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == 1) {
                q.add(arr[i]);
            } else {
                if (q.size() >= 2) { // more than three consecutive numbers
                    res += q.remove() + "-" + arr[i] + ",";
                    q.clear();
                } else if (q.size() == 1) { // only two
                    res += q.remove() + "," + arr[i] + ",";
                } else {
                    res += arr[i] + ",";
                }
            }
        }

        // consider the last int in the arr (maybe it can be optimized)
        if (q.size() >= 2) {
            res += q.remove() + "-" + arr[arr.length - 1];
        } else if (q.size() == 1) {
            res += q.remove() + "," + arr[arr.length - 1];
        } else {
            res += arr[arr.length - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
    }
}

// smart solution! Regex is powerful... 
// public static String rangeExtraction(int[] arr) {
//         String res = "";
//         boolean isStart = true;
//         for (int i = 0; i < arr.length - 1; i++) {
//             boolean isDiapason = (arr[i] + 1 != arr[i + 1]);
//             res += isDiapason ? arr[i] + "," : isStart ? arr[i] + "~" : "~";
//             isStart = isDiapason;
//         }
//         return res.replaceAll("([~]{2,})","-").replace("~", ",") + arr[arr.length - 1];
// }
