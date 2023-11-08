/*Consider a sequence u where u is defined as follows:

The number u(0) = 1 is the first one in u.
For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
There are no other numbers in u.
Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]

1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...

Task:
Given parameter n the function dbl_linear (or dblLinear...) returns 
the element u(n) of the ordered (with <) sequence u (so, there are no duplicates).

Example:
dbl_linear(10) should return 22

Note:
Focus attention on efficiency */

import java.util.*;

public class DoubleLinear {
    public static int dblLinear (int n) {
        // your code
        // 参考动态规划思想了, 当然首先要学习SortedSet是什么:https://www.geeksforgeeks.org/sortedset-java-examples/
        SortedSet<Integer> s = new TreeSet<>();

        s.add(1);
        for (int i = 0; i < n; i++) {
            int x = s.first();
            s.add(2 * x + 1);
            s.add(3 * x + 1);
            //没考虑过删除（以及每一次循环都排序）的操作
            s.remove(x);
        }

        return s.first();

        // Failed!!!
        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // //dont't use iterator here
        // for (int i = 0; list.size() <= 4 * n; i++) {
        //     //avoid duplicates
        //     if (!list.contains(2 * list.get(i) + 1)) {
        //         list.add(2 * list.get(i) + 1);
        //     }
        //     if (!list.contains(3 * list.get(i) + 1)) {
        //         list.add(3 * list.get(i) + 1);
        //     }
        // }

        // int ret = 0;
        // int cnt = 0;
        // list.sort(null);
        // for (int i : list) {
        //     if (cnt == n) {
        //         ret = i;
        //         break;
        //     }
        //     cnt++;
        // }
        // return ret;
    }
}
