package P02_NewApi;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author: okhoogh
 * @date: 2021/12/30 10:32
 * @description: 在JDK10中给IO流中的很多类都添加了带Charset参数的方法，比如PrintStream,PrintWriter,Scanner。
 * 通过Charset可以指定编码来操作文本。Charset是一个抽象类，我们不能直接创建对象，需要使用Charset的静态方法
 * forName("编码")，返回Charset的子类实例。
 */
public class T03_Charset {

    public static void main(String[] args) throws IOException {
        gbk();
        utf8();
    }

    private static void gbk() throws IOException {
        PrintStream ps = new PrintStream("JDK10\\src\\main\\resources\\gbk.txt", Charset.forName("GBK"));
        ps.println("你好");
        ps.close();
    }

    private static void utf8() throws IOException {
        PrintStream ps = new PrintStream("JDK10\\src\\main\\resources\\utf8.txt", StandardCharsets.UTF_8);
        ps.println("你好");
        ps.close();
    }
}
