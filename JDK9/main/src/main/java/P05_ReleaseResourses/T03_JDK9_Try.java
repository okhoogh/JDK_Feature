package P05_ReleaseResourses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author: okhoogh
 * @date: 2021/11/24 17:17
 * @description: JDK9版try-catch
 * 需要释放资源的流，其变量名填写在try()中
 */
public class T03_JDK9_Try {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("D:\\WorkProjects\\JDK\\JDK9\\src\\main\\resources\\a.txt");
        try (fis) {
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
