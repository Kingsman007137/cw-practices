//https://www.codewars.com/kata/550f22f4d758534c1100025a/train/java

import java.util.*;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        // Your code here.
        Map<String, Integer> map = new HashMap<>();
        map.put("NORTH", 1);
        map.put("SOUTH", -1);
        map.put("WEST", 2);
        map.put("EAST", -2);
        Deque<String> deque = new ArrayDeque<>();

        for (String s : arr) {
            //realize that it should always operate the last element of the deque
            if (deque.isEmpty()) {
                deque.addLast(s);
            } else if (map.get(deque.getLast()) + map.get(s) == 0) {
                deque.removeLast();
            } else {
                deque.addLast(s);
            }
        }

        String[] ret = new String[deque.size()];
        if (deque.size() == 0) {
            return ret;
        }

        int i = 0;
        for (String s : deque) {
            ret[i] = s;
            i++;
        }

        return ret;
    }

}

// I should use stack like this, and learn the way this code deals with return

// public static String[] dirReduc(String[] arr) {
//     final Stack<String> stack = new Stack<>();

//     for (final String direction : arr) {
//         final String lastElement = stack.size() > 0 ? stack.lastElement() : null;

//         switch(direction) {
//             case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//             case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//             case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//             case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//         }
//     }
//     return stack.stream().toArray(String[]::new);
// }
