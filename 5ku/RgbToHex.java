/* The rgb function is incomplete. Complete it so that passing in RGB decimal values
 * will result in a hexadecimal representation being returned. Valid decimal values 
 * for RGB are 0 - 255. Any values that fall out of that range must be rounded to the 
 * closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

Examples (input --> output):
255, 255, 255 --> "FFFFFF"
255, 255, 300 --> "FFFFFF"
0, 0, 0       --> "000000"
148, 0, 211   --> "9400D3" */

import java.util.HashMap;
import java.util.Map;

public class RgbToHex {
    public static String rgb(int r, int g, int b) {
        String rgb = "";
        int[] rgbNums = {r, g, b};
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        
        for (int i = 0; i < rgbNums.length; i++) {
            if (rgbNums[i] > 255) {
                rgbNums[i] = 255;
            } else if (rgbNums[i] < 0) {
                rgbNums[i] = 0;
            }

            int tmp = rgbNums[i] / 16;
            int leave = rgbNums[i] % 16;
            rgb += tmp > 9 ? map.get(tmp) : tmp;
            rgb += leave > 9 ? map.get(leave) : leave;
        }

        return rgb;
    }

    public static void main(String[] args) {
        System.out.println(rgb(255, 255, 255));
        System.out.println(rgb(33, 122, 323));
    }
}

// emm...
// public class RgbToHex {
//     public static String rgb(int r, int g, int b) {
//         return String.format("%02X%02X%02X", verify(r), verify(g), verify(b));
//     }
//     private static int verify(int i) {
//         return i > 0 ? Math.min(255, i) : 0;
//     }
// }
