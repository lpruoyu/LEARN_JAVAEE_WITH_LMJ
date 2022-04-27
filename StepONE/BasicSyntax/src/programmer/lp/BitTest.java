package programmer.lp;

public class BitTest {

    public static void main(String[] args) {
        // 测试进制的转换
        System.out.println(10); // 十进制
        System.out.println(0b10); // 二进制 // 2
        System.out.println(010); // 八进制 // 8
        System.out.println(0x10); // 十六进制 // 16
        System.out.println("===========================");
        int num = (int) (Math.random() * 100);
        System.out.println("num : " + num);
        System.out.format("十进制：%d，二进制：%s，八进制：%o，十六进制：%x", num, Integer.toBinaryString(num), num, num);
    }

    public static void main5(String[] args) {
        // 00000000000000000000000000001010
        System.out.println(Integer.toBinaryString(10));

        // ~：按位取反
        // 11111111111111111111111111110101
        System.out.println(Integer.toBinaryString(~10));

        System.out.println(true & true); // true
        System.out.println(false & false); // false
        System.out.println(true & false); // false

        System.out.println(true | true); // true
        System.out.println(false | false); // false
        System.out.println(true | false); // true

        System.out.println(true ^ true); // false
        System.out.println(false ^ false); // false
        System.out.println(true ^ false); // true
    }


    public static void main4(String[] args) {
        System.out.println(true && true); // true
        System.out.println(false && false); // false
        System.out.println(true && false); // false

        System.out.println(true || true); // true
        System.out.println(false || false); // false
        System.out.println(true || false); // true

        System.out.println(!true); // false
        System.out.println(!false); // true
    }

    public static void main2(String[] args) {
        System.out.println(10 & 6); // 与   1010 & 0110 = 0010 = 2
        System.out.println(10 | 7); // 或   1010 | 0111 = 1111 = 15
        System.out.println(10 ^ 8); // 异或 1010 ^ 1000 = 0010 = 2
        System.out.println(~10);    // 取反 ~1010 = 0101 = 5
    }

    public static void main1(String[] args) {
        // 11111111111111111111111110000000
        System.out.println(Integer.toBinaryString(-128));
        // 00000000000000000000000010000000
        System.out.println(Integer.toBinaryString(128));

        // 11111111111111111111111111100000
        System.out.println(Integer.toBinaryString(-128 >> 2));
        // 00111111111111111111111111100000
        System.out.println(Integer.toBinaryString(-128 >>> 2));
    }

}
