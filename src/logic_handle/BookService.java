package logic_handle;

import entity.Sach;
import main.MainRun;

import java.util.Scanner;

public class BookService {
    public static void inputSach() {
        // xử lý nhập sách mới
        System.out.println("Nhập số lượng sách mới muốn thêm: ");
        int newSachNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newSachNumber; i++) {
            System.out.println("Nhập thông tin cho đầu sách thứ " + (i + 1));
            Sach sach = new Sach();
            sach.inputInfo();

            // lưu thông tin vào hệ thống  ==> lưu vào mảng sach đã khai báo bên trên
            saveBook(sach);
        }
    }

    public static void saveBook(Sach sach) {
        for (int j = 0; j < MainRun.SACH.length; j++) {
            if (MainRun.SACH[j] == null) {
                MainRun.SACH[j] = sach;
                break;
            }
        }
    }

    public static void showAllBook() {
        for (int i = 0; i < MainRun.SACH.length; i++) {
            if (MainRun.SACH[i] == null) {
                continue;
            }
            System.out.println(MainRun.SACH[i]);
        }
    }

    public static boolean isEmtyBook() {
        for (int i = 0; i < MainRun.SACH.length; i++) {
            if (MainRun.SACH[i] != null) {
                return false;
            }
        }
        return true;
    }
}
