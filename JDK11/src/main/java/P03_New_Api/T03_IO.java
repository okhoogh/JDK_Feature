package P03_New_Api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author: okhoogh
 * @date: 2022/1/4 13:39
 * @description: Path.of 获取文件路径
 * Files.readString、Files.writeString 文件读写字符串
 * Reader、Writer、InputStream、OutputStream 定义一个不执行任何操作的对象XXX.nullXXX()
 */
public class T03_IO {
    public static void main(String[] args) throws IOException {
        // 1.此前我们需要使用 Paths.get()。现在，我们像其他类一样使用of()
        // PS: Paths.get()已用Path.of重写
        // 2.往文件里写一个字符串
        Files.writeString(Path.of("JDK11/src/main/resources/test1.txt"), "Hello World");
        // 3.从文件读取一个字符串
        String str = Files.readString(Path.of("JDK11/src/main/resources/test1.txt"), StandardCharsets.UTF_8);
        System.out.println(str);
        // 4.定义一个不执行任何操作的 Reader
        Reader nullReader = Reader.nullReader();
        // 5.定义一个不执行任何操作的 Writer
        Writer nullWriter = Writer.nullWriter();
        // 6.定义一个不执行任何操作的 InputStream
        InputStream nullInputStream = InputStream.nullInputStream();
        // 7.定义一个不执行任何操作的 OutputStream
        OutputStream outputStream = OutputStream.nullOutputStream();

        // JDK9的输入输出流传输
        try (var is = new FileInputStream("JDK11/src/main/resources/test1.txt");
             var os = new FileOutputStream("JDK11/src/main/resources/test2.txt")) {
            is.transferTo(os);
        }

        String str2 = Files.readString(Path.of("JDK11/src/main/resources/test2.txt"));
        System.out.println(str2);
    }
}
