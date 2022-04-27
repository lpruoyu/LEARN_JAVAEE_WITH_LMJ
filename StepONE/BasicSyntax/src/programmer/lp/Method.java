package programmer.lp;

/***
 *               女神保佑 永无BUG
 *
 *                    .::::.
 *                  .::::::::.
 *                 :::::::::::
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::
 *      .::'        :::::::::::::::'         ::::.
 *  ...:::         ::::::::::::::'             ::::.
 * ````':.          ':::::::::'                  ::::..
 *                    ':::::'                    ':'````..
 *
 */
public class Method {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double sum(int a, double b) {
        return a + b;
    }

    public static double sum(double... args) {
        double result = 0;
        for (double d : args) {
            result += d;
        }
        return result;
    }

    public static int sum(int... args) {
        int result = 0;
        for (int d : args) {
            result += d;
        }
        return result;
    }

//    public static void main(String[] args) {
//        System.out.println(sum(1, 2, 3));
//    }
//
//    private static int sum(int... args) {
//        int result = 0;
////        for (int arg : args) {
////            result += arg;
////        }
//        for (int i = 0; i < args.length; i++) {
//            result += args[i];
//        }
//        return result;
//    }
//
//    public static void main1(String[] args) {
//        test(null);
////        test();
//    }
//
//    private static void test(int... args) {
//        System.out.println(args == null); // true
////        System.out.println(args == null); // false
//    }
}
