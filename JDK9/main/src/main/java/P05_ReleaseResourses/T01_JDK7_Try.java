package P05_ReleaseResourses;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: okhoogh
 * @date: 2021/11/24 17:06
 * @description: JDK7版try-catch
 * 释放资源代码非常累赘，如果释放资源较多的时候，很容易就会出现释放资源代码多于正常业务的代码.
 */
public class T01_JDK7_Try {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            //1. 建立程序与文件的数据通道
            fileInputStream = new FileInputStream("D:\\WorkProjects\\JDK\\JDK9\\src\\main\\resources\\a.txt");
            //2. 创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0;
            //3. 读取数据，并且输出
            while ((length = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}