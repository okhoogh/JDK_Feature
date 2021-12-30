package P02_NewApi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: okhoogh
 * @date: 2021/12/29 18:19
 * @description: InputStream 和 Reader 类中新增了 transferTo 方法
 * transferTo 方法的作用是将输入流读取的数据使用字符输出流写出，可用于复制文件等操作。
 */
public class T02_TransferTo {
    public static void main(String[] args) throws IOException {
//        before();
        now();
    }

    private static void before() throws IOException {
        // 字符流复制文本文件
        FileReader fis = new FileReader("JDK10\\src\\main\\resources\\a.txt");
        FileWriter fos = new FileWriter("JDK10\\src\\main\\resources\\b.txt");
        char[] chs = new char[1024 * 8];
        int len;
        while ((len = fis.read(chs)) != -1) {
            fos.write(chs, 0, len);
        }
        fos.close();
        fis.close();
    }

    private static void now() throws IOException {
        FileReader fis = new FileReader("JDK10\\src\\main\\resources\\a.txt");
        FileWriter fos = new FileWriter("JDK10\\src\\main\\resources\\b.txt");
        fis.transferTo(fos);
        fos.close();
        fis.close();
    }

}