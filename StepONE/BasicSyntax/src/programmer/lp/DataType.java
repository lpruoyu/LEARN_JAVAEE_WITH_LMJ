package programmer.lp;

public class DataType {

    public static void main(String[] args) {
        // 是否是Java支持的标识符的开头字符
        System.out.println(Character.isJavaIdentifierStart('$')); // true
        System.out.println(Character.isJavaIdentifierStart('￥')); // true
        System.out.println(Character.isJavaIdentifierStart(1)); // false
        char ￥a = 'c';
        System.out.println(￥a);
        // 是否是Java支持的标识符的部分字符
        System.out.println(Character.isJavaIdentifierPart(1)); // true
        System.out.println(Character.isJavaIdentifierPart('_')); // true
        System.out.println(Character.isJavaIdentifierPart('#')); // false
        System.out.println(Character.isJavaIdentifierPart('}')); // false
        System.out.println(Character.isJavaIdentifierPart('^')); // false
    }

    public static void main1(String[] args) {
        // 八进制：以0开头
        System.out.println(012); // 相当于十进制的10
    }

    public static void main2(String[] args) {
        System.out.println(Byte.MAX_VALUE); // 1个字节
        System.out.println(Short.MAX_VALUE); // 2个字节
        System.out.println(Character.MAX_VALUE); // 2个字节
        System.out.println(Integer.MAX_VALUE); // 4个字节
        System.out.println(Float.MAX_VALUE); // 4个字节
        System.out.println(Long.MAX_VALUE); // 8个字节
        System.out.println(Double.MAX_VALUE); // 8个字节
    }

}
