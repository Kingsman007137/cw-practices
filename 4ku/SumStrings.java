/*Given the string representations of two integers, return the string representation of the sum of those integers.

For example:

sumStrings('1','2') // => '3'
A string representation of an integer will contain no characters besides the ten numerals "0" to "9". */

public class SumStrings {
    public static String sumStrings(String a, String b) {
        //不能用BigInteger类（但这是个好东西）
        a = a.length() == 0 ? "0" : a;
        b = b.length() == 0 ? "0" : b;
        int minLength = Math.min(a.length(), b.length());
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int ten = 0;
        String sum = "";

        for (int i = minLength - 1; i >= 0; i--) {
            int numSum = (a.charAt(al) - '0') + (b.charAt(bl) - '0') + ten;
            sum += numSum % 10; // 个位
            ten = numSum >= 10 ? 1 : 0; //考虑是否要进一
            al--;
            bl--;
        }

        StringBuilder input = new StringBuilder(sum);

        if (al == bl) {
            if (ten == 1) {
                sum = new StringBuilder(sum + "1").reverse().toString();
            } else {
                sum = input.reverse().toString();
            }
        } else if (al == -1) { //b数长度更长
            sum = b.substring(0, bl+1) + input.reverse().toString();//useful reverse method
            if (ten == 1) { //考虑边界也要进一位的情况
                int change = (sum.charAt(bl) - '0') + 1;
                sum = sum.substring(0, bl) + change + sum.substring(bl + 1);
            }
        } else {
            sum = a.substring(0, al+1) + input.reverse().toString();
            if (ten == 1) {
                int change = (sum.charAt(al) - '0') + 1;
                sum = sum.substring(0, al) + change + sum.substring(al + 1);
            }
        }

        //6，还要去掉前面的0
        return sum.replaceFirst("0*", ""); //还可以这样！！
    }
}

//我这想法还是太复杂了，用了很多判断才搞完，应该还有很多可优化的地方 ===> 要善用StringBuilder！！！
//看看别人写的简洁代码，不懂的地方去查一下：https://www.codewars.com/kata/5324945e2ece5e1f32000370/solutions/java