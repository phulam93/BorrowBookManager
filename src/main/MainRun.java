package main;

import entity.BanDoc;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Sach;
import logic_handle.BookService;
import logic_handle.BorrowBookService;
import logic_handle.ReaderService;

import java.util.Comparator;
import java.util.Scanner;

public class MainRun {

    public static Sach[] SACH = new Sach[100]; // một tập hợp các đầu sách
    public static BanDoc[] BAN_DOC = new BanDoc[100];
    public static BookBorrow[] BOOK_BORROWS = new BookBorrow[100];

    public static void demoSortReader() {
        for (int i = 0; i < BAN_DOC.length - 1; i++) {
            for (int j = +1; j < BAN_DOC.length; j++) {
                if (BAN_DOC[i].compareTo(BAN_DOC[j]) > 0) {
                    BanDoc temp = BAN_DOC[i];
                    BAN_DOC[i] = BAN_DOC[j];
                    BAN_DOC[j] = temp;
                }
            }
        }
    }

    public static void demoSortReader2() {
        // sử dụng annonymus class
        // mục đích để chỉ so sánh 1 lần và không cần dùng lại hàm so sánh
        Comparator<BanDoc> comparator = new Comparator<BanDoc>() {
            @Override
            public int compare(BanDoc o1, BanDoc o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        for (int i = 0; i < BAN_DOC.length - 1; i++) {
            for (int j = +1; j < BAN_DOC.length; j++) {
                if (comparator.compare(BAN_DOC[i], BAN_DOC[j]) > 0) {
                    BanDoc temp = BAN_DOC[i];
                    BAN_DOC[i] = BAN_DOC[j];
                    BAN_DOC[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        boolean isExit = false;
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    BookService.inputSach();
                    break;
                case 2:
                    BookService.showAllBook();
                    break;
                case 3:
                    ReaderService.inputReader();
                    break;
                case 4:
                    ReaderService.showAllReader();
                    break;
                case 5:
                    BorrowBookService.borrowBook();
                    BorrowBookService.showBorrow();
                    break;
                case 6:
                    BorrowBookService.sortBorrow();
                    break;
                case 7:
                    BorrowBookService.searchBorrowByReader();
                    break;
                case 8:
                    System.out.println("Xin cảm ơn bạn đã sử dụng phần mềm của chúng tôi.");
                    isExit = true;
            }
        } while (!isExit);
    }

    private static int functionChoice() {
        System.out.println("\nPhần mền quản lý mượn sách thư viện!\n");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("1. Nhập danh sách đầu sách mới.");
        System.out.println("2. In ra danh sách đầu sách đã có.");
        System.out.println("3. Nhập danh sách bạn đọc mới.");
        System.out.println("4. In ra danh sách bạn đọc trong thư viện.");
        System.out.println("5. Thực hiện cho mượn sách.");
        System.out.println("6. Sắp xếp danh sách mượn sách.");
        System.out.println("7. Tìm kiếm trong danh sách mượn sách theo tên bạn đọc.");
        System.out.println("8. Thoát chương trình.");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ vui lòng chọn lại: ");
        } while (functionChoice > 8 || functionChoice < 1);
        return functionChoice;
    }

}
