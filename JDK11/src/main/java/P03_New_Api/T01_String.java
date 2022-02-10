package P03_New_Api;

/**
 * @author: okhoogh
 * @date: 2022/1/4 11:41
 * @description:
 */
public class T01_String {
    public static void main(String[] args) {
        // 判断字符串是否为空白
        System.out.println("     ".isBlank());
        // 去除首尾空白
        System.out.println("　haha　".strip());   // 可以去除全角的空白字符
        System.out.println("　haha　".trim());    // 不能去除全角的空白字符
        // 去除首/尾部空格
        System.out.println("　haha　".stripLeading());
        System.out.println("　haha　".stripTrailing());
        // 复制字符串
        System.out.println("　haha　".repeat(3));
        // 行数统计
        System.out.println("A\nB\nC\n\n\b\b\b"); // 5;
    }
}
