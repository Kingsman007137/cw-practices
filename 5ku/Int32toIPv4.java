//https://www.codewars.com/kata/52e88b39ffb6ac53a400022e/train/java

/*Take the following IPv4 address: 128.32.10.1

This address has 4 octets where each octet is a single byte (or 8 bits).

1st octet 128 has the binary representation: 10000000
2nd octet 32 has the binary representation: 00100000
3rd octet 10 has the binary representation: 00001010
4th octet 1 has the binary representation: 00000001
So 128.32.10.1 == 10000000.00100000.00001010.00000001

Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361

Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.

Examples
2149583361 ==> "128.32.10.1"
32         ==> "0.0.0.32"
0          ==> "0.0.0.0" */

public class Int32toIPv4 {
    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        long ip1 = (ip & 0b11111111000000000000000000000000) >> 24;
        long ip2 = (ip & 0b00000000111111110000000000000000) >> 16;
        long ip3 = (ip & 0b00000000000000001111111100000000) >> 8;
        long ip4 = ip & 0b00000000000000000000000011111111;
        return ip1 + "." + ip2 + "." + ip3 + "." + ip4;
    }
}

// I forget to shilft bits at first, however there is more simple solution
// public static String longToIP(long ip) {
//     return String.format("%d.%d.%d.%d", ip>>>24, (ip>>16)&0xff, (ip>>8)&0xff, ip&0xff);
// }