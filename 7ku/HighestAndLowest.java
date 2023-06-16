/**
https://www.codewars.com/kata/554b4ac871d6813a03000035/java

DESCRIPTION:
In this little assignment you are given a string of space separated numbers, 
and have to return the highest and lowest number.

Examples
highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"
 */

public class HighestAndLowest {
    public static String highAndLow(String numbers) {
        // Code here or
        //原来Java也有split函数，去掉字符串中特定字符。
        String[] withoutSpace = numbers.split(" ");
        int[] num = new int[withoutSpace.length];

        //把字符串变为整数
        for (int i = 0; i < withoutSpace.length; i++) {
            num[i] = Integer.valueOf(withoutSpace[i]);
        }

        int min = num[0], max = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > max)
                max = num[i];
            if (num[i] < min)
                min = num[i];
        }

        return String.valueOf(max) + " " + String.valueOf(min);
    } 
}

/**Best solution:
import static java.util.Arrays.stream;

class Kata {
  static String highAndLow(String numbers) {
    var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
    return stats.getMax() + " " + stats.getMin();
  }
}
 */