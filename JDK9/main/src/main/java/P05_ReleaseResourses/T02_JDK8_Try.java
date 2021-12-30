package P05_ReleaseResourses;

import java.io.FileInputStream;

/**
 * @author: okhoogh
 * @date: 2021/11/24 17:14
 * @description: JDK8版try-catch
 * JDK8开始已经不需要我们再手动关闭资源，只需要把要关闭资源的代码放入try语句中即可
 * 但是要求初始化资源的语句必须位于try语句中
 */
public class T02_JDK8_Try {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("D:\\WorkProjects\\JDK\\JDK9\\src\\main\\resources\\a.txt")) {
            byte[] bytes = new byte[1024];
            int length = 0;
            while((length = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, length));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
