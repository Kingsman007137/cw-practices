//https://www.codewars.com/kata/51e056fe544cf36c410000fb/train/java

import java.util.*;

public class TopWords {
    
    public static List<String> top3(String s) {
        // Your code here
        String[] strings = s.toLowerCase().split("\\s+");// regex, delete all space
        Map<String, Integer> m = new HashMap<>();
        for (String str: strings) {
            if (str == "") {
                continue;
            }
            str = str.replaceAll("[^a-zA-Z']", "");

            if (!m.containsKey(str) && !str.equals("") && 
                str.replaceAll("'", "").length() != 0) {
                m.put(str, 1);
            } else if (m.containsKey(str)){
                m.put(str, m.get(str) + 1);
            }
        }

        List<String> res = new ArrayList<>();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(m.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //这是降序排序
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> mapping: list) {
            res.add(mapping.getKey());
            if (res.size() == 3) 
                break;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(top3("  , e   .. ").toString());
    }
}

// I can not solve this, just quit it now, and solve it in the future
