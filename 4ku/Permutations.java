/*In this kata, your task is to create all permutations of a non-empty 
input string and remove duplicates, if present.Create as many "shufflings" as you can!

Examples:

With input 'a':
Your function should return: ['a']
With input 'ab':
Your function should return ['ab', 'ba']
With input 'abc':
Your function should return ['abc','acb','bac','bca','cab','cba']
With input 'aabb':
Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']

Note: The order of the permutations doesn't matter. */

import java.util.*;

public class Permutations {
    public static List<String> singlePermutations(String s) {
        // Your code here!
        // 其实就是实现全排列
        List<String> list = new ArrayList<>();
        list.add(s.charAt(0) + "");

        for (int i = 1; i < s.length(); i++) {
            List<String> newList = new ArrayList<>();
            char c = s.charAt(i);
            for (String str : list) {
                if (!newList.contains(c + str)) //在前面加上新字符
                    newList.add(c + str);
                if (!newList.contains(str + c)) //在后面加上新字符
                    newList.add(str + c);
                for (int j = 1; j < str.length(); j++) { //在中间加上新字符
                    String newStr = str.substring(0, j) + c + str.substring(j);
                    if (!newList.contains(newStr))
                        newList.add(newStr);
                }
            }
            list = newList;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(singlePermutations("ab").toString());
    }
}

// 有人用递归做，但我想不出
// public static List<String> singlePermutations(String s) {
//         Set<String> set = new HashSet<>();
//         if (s.length() == 1) {
//             set.add(s);
//         } else {
//             for (int i = 0; i < s.length(); i++) {
//                 List<String> temp = singlePermutations(s.substring(0, i) + s.substring(i + 1));
//                 for (String string : temp) {
//                     set.add(s.charAt(i) + string);
//                 }
//             }
//         }

//         return new ArrayList<>(set);
//  }
