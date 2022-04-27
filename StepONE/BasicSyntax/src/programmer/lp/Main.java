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
public class Main {


    public static void main3(String[] args) {
        char[] charArr = new char[]{'每', '天', '进', '步', '一', '点', '点'}; // 比较特殊
        System.out.println(charArr); // 每天进步一点点
        System.out.println(charArr[1]); // 随机访问 速度非常快 O(1)
    }


    public static void main2(String[] args) {
        char[] charArr = new char[]{'每', '天', '进', '步', '一', '点', '点'}; // 比较特殊
        System.out.println(charArr); // 每天进步一点点
        Character[] characterArr = {'每', '天', '进', '步', '一', '点', '点'};
        System.out.println(characterArr); // [Ljava.lang.Character;@1b6d3586

        for (char c : charArr) {
            System.out.println(c);
        }

        System.out.println("=========");

        for (int i = 0; i < characterArr.length; i++) {
            System.out.println(characterArr[i]);
        }

        int[] intArr = {1, 2};
        System.out.println(intArr); // [I@4554617c
        Integer[] integerArr = {1, 2};
        System.out.println(integerArr); // [Ljava.lang.Integer;@74a14482
    }

    public static void main1(String[] args) {
        // 这是一段很有用的代码
        System.out.println("HelloWorld\n基础语法");
    }

}
