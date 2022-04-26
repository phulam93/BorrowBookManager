package logic_handle;

import entity.BanDoc;
import entity.BookBorrow;
import entity.BookBorrowDetail;
import entity.Sach;
import main.MainRun;

import java.util.Scanner;

public class BorrowBookService {
    public static void sortBorrow() {
        System.out.println("Nhập lựa chọn của bạn.");
        System.out.println("1. Sắp xếp theo tên bạn đọc.");
        System.out.println("1. Sắp xếp theo số lượng cuốn sách đã mượn (giảm dần).");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Lựa chọn của bạn không hợp lệ, vui lòng nhập lại:");
        } while (true);
        if (choice == 1) {
            //sắp xếp theo tên bạn đọc
            for (int i = 0; i < MainRun.BOOK_BORROWS.length - 1; i++) {
                if (MainRun.BOOK_BORROWS[i] != null) {
                    for (int j = i + 1; j < MainRun.BOOK_BORROWS.length; j++) {
                        if (MainRun.BOOK_BORROWS[j] != null) {
                            if (MainRun.BOOK_BORROWS[i].getReader().getName().compareTo(MainRun.BOOK_BORROWS[j].getReader().getName()) > 0) {
                                BookBorrow temp = MainRun.BOOK_BORROWS[i];
                                MainRun.BOOK_BORROWS[i] = MainRun.BOOK_BORROWS[j];
                                MainRun.BOOK_BORROWS[j] = temp;
                            }
                        }
                    }
                }
            }

        } else if (choice == 2) {
            //sắp xếp theo số lượng sách đã mượn
            for (int i = 0; i < MainRun.BOOK_BORROWS.length - 1; i++) {
                if (MainRun.BOOK_BORROWS[i] != null) {
                    for (int j = i + 1; j < MainRun.BOOK_BORROWS.length; j++) {
                        if (MainRun.BOOK_BORROWS[j] != null) {
                            if (MainRun.BOOK_BORROWS[i].compareTo(MainRun.BOOK_BORROWS[j]) > 0) {
                                BookBorrow temp = MainRun.BOOK_BORROWS[i];
                                MainRun.BOOK_BORROWS[i] = MainRun.BOOK_BORROWS[j];
                                MainRun.BOOK_BORROWS[j] = temp;
                            }
                        }
                    }
                }
            }
        }
        showBorrow();
    }

    public static void searchBorrowByReader() {
        System.out.print("Nhập tên của bạn đọc mà bạn muốn tìm kiếm: ");
        String keyword = new Scanner(System.in).nextLine();
        for (int i = 0; i < MainRun.BOOK_BORROWS.length; i++) {
            if (MainRun.BOOK_BORROWS[i] != null && MainRun.BOOK_BORROWS[i].getReader().getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(MainRun.BOOK_BORROWS[i]);
            }
        }
    }

    public static void showBorrow() {
        for (int i = 0; i < MainRun.BOOK_BORROWS.length; i++) {
            if (MainRun.BOOK_BORROWS[i] != null) {
                System.out.println(MainRun.BOOK_BORROWS[i]);
            }
        }
    }

    public static void borrowBook() {

        if (BookService.isEmtyBook() || ReaderService.isEmtyReader()) {
            System.out.println("Cần phải nhập người đọc và sách trước.");
            return;
        }
        System.out.print("Nhập vào số lượng bạn đọc muốn mượn sách: ");
        int readerNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < readerNumber; i++) {
            System.out.print("Nhập vào mã bạn đọc thứ " + (i + 1) + " muốn mượn sách: ");

            //nhập bạn đọc muốn mượn sách
            BanDoc reader = inputReaderInfo();

            //nhập danh sách các đầu sách
            BookBorrowDetail[] bookBorrowDetails = inputBorrowDetail();

            //lượt mượn sách
            BookBorrow bookBorrow = new BookBorrow(reader, bookBorrowDetails);
            saveBorrow(bookBorrow);

        }
    }

    private static void saveBorrow(BookBorrow bookBorrow) {
        for (int j = 0; j < MainRun.BOOK_BORROWS.length; j++) {
            if (MainRun.BOOK_BORROWS[j] == null) {
                MainRun.BOOK_BORROWS[j] = bookBorrow;
                break;
            }
        }
    }

    private static BookBorrowDetail[] inputBorrowDetail() {
        System.out.print("Nhập số lượng đầu sách mà bạn đọc muốn mượn: ");
        int bookQuantity = -1;
        do {
            bookQuantity = new Scanner(System.in).nextInt();
            if (bookQuantity > 0 && bookQuantity <= 5) {
                break;
            }
            System.out.println("Bạn chỉ được mượn tối đa 5 đầu sách, mờ nhập lại: ");

        } while (bookQuantity < 0 || bookQuantity > 5);

        BookBorrowDetail[] bookBorrowDetails = new BookBorrowDetail[bookQuantity];
        for (int j = 0; j < bookQuantity; j++) {
            System.out.print("Nhập mã đầu sách thứ " + (j + 1) + " mà bạn muốn mượn: ");
            int bookID = -1;
            Sach book = null;
            do {
                bookID = new Scanner(System.in).nextInt();
                for (int k = 0; k < MainRun.SACH.length; k++) {
                    if (MainRun.SACH[k] != null && MainRun.SACH[k].getId() == bookID) {
                        book = MainRun.SACH[k];
                        break;
                    }
                }
                if (book != null) {
                    break;
                }
                System.out.println("Không tìm thấy sách mang mã vừa nhập, vui lòng nhập lại: ");
            } while (true);

            System.out.print("Bạn muốn mượn bao nhiêu cuốn sách này: ");
            int quantity = -1;
            do {
                bookQuantity = new Scanner(System.in).nextInt();
                if (bookQuantity > 0 && bookQuantity <= 3) {
                    break;
                }
                System.out.println("Bạn chỉ được mượn tối đa 3 cuốn cho 1 đầu sách, mờ nhập lại: ");

            } while (bookQuantity < 0 || bookQuantity > 3);

            // nhập từng cuốn sách và số lượng cuốn tương ứng
            BookBorrowDetail bookBorrowDetail = new BookBorrowDetail(book, quantity);
            for (int k = 0; k < bookBorrowDetails.length; k++) {
                if (bookBorrowDetails[k] == null) {
                    bookBorrowDetails[k] = bookBorrowDetail;
                    break;
                }
            }
        }
        return bookBorrowDetails;
    }

    public static BanDoc inputReaderInfo() {
        BanDoc reader = null;
        do {
            int readerID = new Scanner(System.in).nextInt();
            for (int j = 0; j < MainRun.BAN_DOC.length; j++) {
                if (MainRun.BAN_DOC[j] != null && MainRun.BAN_DOC[j].getId() == readerID) {
                    reader = MainRun.BAN_DOC[j];
                    break;
                }
            }
            if (reader != null) {
                break;
            }
            System.out.println("Không tìm thấy bạn đọc mang mã vừa nhập, vui lòng nhập lại: ");
        } while (true);
        return reader;
    }
}
