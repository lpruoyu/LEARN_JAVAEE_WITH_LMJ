package programmer.lp;

public class Variable {

    public static void main(String[] args) {
        // 只是不能单独使用下划线而已，下面这种写法就可以：
        int __ = 100;
        System.out.println(__);
        // 可以单独使用$
        int $ = 100;
        System.out.println($);
    }

    public static void main1(String[] args) {
        int minute = 0;
        int second = 47;
        System.out.println(minute);
        System.out.println(second);
        System.out.println(100);
    }

}
