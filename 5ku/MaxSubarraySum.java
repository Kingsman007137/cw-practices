/*The maximum sum subarray problem consists in finding the maximum sum of a contiguous
 subsequence in an array or list of integers:

Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}

Easy case is when the list is made up of only positive numbers and the maximum sum 
is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
Empty list is considered to have zero greatest sum. Note that the empty list or array 
is also a valid sublist/subarray.
 */

import java.util.ArrayList;
import java.util.Comparator;

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        ArrayList<Integer> alist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                alist.add(sum);
            }
        }
        alist.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return alist.get(alist.size() - 1) > 0 ? alist.get(alist.size() - 1) : 0;
    }
}

//can not understand --- https://zhuanlan.zhihu.com/p/96014673
//     public static int sequence(int[] arr) {
//         int max_ending_here = 0, max_so_far = 0;
//         for (int v : arr) {
//             max_ending_here = Math.max(0, max_ending_here + v);
//             max_so_far = Math.max(max_so_far, max_ending_here);
//         }
//         return max_so_far;
//     }
