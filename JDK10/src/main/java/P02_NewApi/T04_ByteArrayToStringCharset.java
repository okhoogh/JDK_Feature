package P02_NewApi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author: okhoogh
 * @date: 2021/12/30 10:40
 * @description: ByteArrayOutputStream 新增重载 toString(Charset charset) 方法，
 * 通过指定的字符集编码字节，将缓冲区的内容转换为字符串。
 */
public class T04_ByteArrayToStringCharset {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "你好中国";
        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("GBK"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        System.out.println(bos.toString());
        System.out.println(bos.toString("GBK"));
    }

}
