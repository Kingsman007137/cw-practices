/*A Hamming number is a positive integer of the form 2^i 3^j 5^k, 
for some non-negative integers i, j, and k.

Write a function that computes the nth smallest Hamming number.

Specifically:

The first smallest Hamming number is 1 = 2^0 3^0 5^0
The second smallest Hamming number is 2 = 2^1 3^0 5^0
The third smallest Hamming number is 3 = 2^0 3^1 5^0
The fourth smallest Hamming number is 4 = 2^2 3^0 5^0
The fifth smallest Hamming number is 5 = 2^0 3^0 5^1 */

import java.util.SortedSet;
import java.util.TreeSet;

public class Hamming {
    public static long hamming(int n) {
        // TODO: Program me
        SortedSet<Long> s = new TreeSet<>();

        s.add((long) 1);
        for (int i = 1; i < n; i++) {
            long smallest = s.first();
            s.add(smallest * 2);
            s.add(smallest * 3);
            s.add(smallest * 5);
            s.remove(smallest);
        }
        return s.first();
    }
}

//这个非常像前面的DoubleLinear题目，但是要找到目前最小的数和下面的数有什么函数关系
//刚开始一直在纠结乘方的问题，其实只需要把存在Set里面最小的数一直乘2或3或5就行，这就是这道题的函数关系
