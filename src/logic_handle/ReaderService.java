package logic_handle;

import entity.BanDoc;
import main.MainRun;
import sun.applet.Main;

import java.util.Scanner;

public class ReaderService {
    public static void inputReader() {
        // xử lý nhập sách mới
        System.out.println("Nhập số lượng bạn đọc mới muốn thêm: ");
        int newReaderNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newReaderNumber; i++) {
            System.out.println("Nhập thông tin cho bạn đọc thứ " + (i + 1));
            BanDoc reader = new BanDoc();
            reader.inputInfo();

            // lưu thông tin vào hệ thống  ==> lưu vào mảng bạn đọc đã khai báo bên trên
            saveReader(reader);
        }
    }

    public static void saveReader(BanDoc reader) {
        for (int j = 0; j < MainRun.BAN_DOC.length; j++) {
            if (MainRun.BAN_DOC[j] == null) {
                MainRun.BAN_DOC[j] = reader;
                break;
            }
        }
    }

    public static void showAllReader() {
        for (int i = 0; i < MainRun.BAN_DOC.length; i++) {
            if (MainRun.BAN_DOC[i] == null) {
                continue;
            }
            System.out.println(MainRun.BAN_DOC[i]);
        }
    }

    public static boolean isEmtyReader() {
        for (int i = 0; i < MainRun.BAN_DOC.length; i++) {
            if (MainRun.BAN_DOC[i] != null) {
                return false;
            }
        }
        return true;
    }
}
