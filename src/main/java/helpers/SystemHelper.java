package helpers;

import java.io.File;

public class SystemHelper {
    public static String getCurrentDir() {
        //hàm trả về đường dẫn thư mục hiện tại có thêm ký tự phân cách ở cuối
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }
}
