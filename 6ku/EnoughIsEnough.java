/*Given a list and a number, create a new list that contains 
each number of list at most N times, without reordering.
For example if the input number is 2, and the input list 
is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] 
since this would lead to 1 and 2 being in the result 3 times, 
and then take 3, which leads to [1,2,3,1,2,3]. With list 
[20,37,20,21] and number 1, the result would be [20,37,21].*/

import java.util.*;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) {
            return new int[0];
        }

        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            Integer n = m.put(elements[i], m.getOrDefault(elements[i], 1) + 1);
            if (n == null || n <= maxOccurrences) {
                tmp.add(elements[i]);
            }
        }

        int[] arr = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            arr[i] = tmp.get(i);
        }

		return arr;
	}
}
