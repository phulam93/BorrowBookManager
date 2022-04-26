package entity;

import constant.BookCategory;

import java.util.Scanner;

public class Sach implements InputTable {
    private static int AUTO_ID = -1;

//    public static final String KH_TN = "Khoa học tự nhiên";
//    public static final String VH_NT = "Văn học - Nghệ thuật";
//    public static final String DTVT = "Điện tử viễn thông";
//    public static final String CNTT = "Công nghệ thông tin";

    private int id;
    private String name;
    private String author;
//    private String bookCategory;
    private BookCategory bookCategory;
    private int yearPublish;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookCategory=" + bookCategory.value +
                ", yearPublish=" + yearPublish +
                '}';
    }

    public Sach() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.id = AUTO_ID;
            return;
        } else {
            this.id = ++AUTO_ID;
        }
    }

    public Sach(String name, String author, BookCategory bookCategory, int yearPublish) {
        this.name = name;
        this.author = author;
        this.bookCategory = bookCategory;
        this.yearPublish = yearPublish;
    }

    @Override
    public void inputInfo() {

        // thực hiện nhập thông tin cho đầu sách
        System.out.println("Nhập tên cho đầu sách");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập tác giả cho đầu sách");
        this.setAuthor(new Scanner(System.in).nextLine());
        System.out.println("Nhập chuyên nghành đầu sách là một trong các lựa chọn dưới đây: ");
        System.out.println("1. Khoa học tự nhiên");
        System.out.println("2. Văn học - Nghệ thuật");
        System.out.println("3. Điện tử viễn thông");
        System.out.println("4. Công nghệ thông tin");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.print("Chuyên nghành sách được chọn không hợp lệ vui lòng chọn lại: ");
        } while (choice > 4 || choice < 1);
        switch (choice) {
            case 1:
                this.setBookCategory(BookCategory.KH_TN);
                break;
            case 2:
                this.setBookCategory(BookCategory.VH_NT);
                break;
            case 3:
                this.setBookCategory(BookCategory.DTVT);
                break;
            case 4:
                this.setBookCategory(BookCategory.CNTT);
                break;
        }
        System.out.println("Nhập năm sản xuất của đầu sách");
        this.setYearPublish(new Scanner(System.in).nextInt());
    }
}


