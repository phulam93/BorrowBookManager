package entity;

import constant.ReaderType;

import java.util.Scanner;

public class BanDoc extends Person implements Comparable<BanDoc> {
//    public static final String SINH_VIEN = "Sinh viên";
//    public static final String HV_CAO_HOC = "Học Viên Cao Học";
//    public static final String GIAO_VIEN = "Giáo viên";

    private static int AUTO_ID = -1;

    private static ReaderType categoryReader;

    public ReaderType getCategoryReader() {
        return BanDoc.categoryReader;
    }

    public void setCategoryReader(ReaderType categoryReader) {
        this.categoryReader = categoryReader;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", categoryReader=" + categoryReader.value +
                '}';
    }

    public BanDoc() {
        if (AUTO_ID == -1) {
            AUTO_ID = 10000;
            this.id = AUTO_ID;
            return;
        } else {
            this.id = ++AUTO_ID;
        }
    }

    public BanDoc(String name, String address, String phoneNumber, ReaderType categoryReader) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.categoryReader = categoryReader;
    }

    @Override
    public void inputInfo() {

        // thực hiện nhập thông tin cho bạn đọc
        super.inputInfo();
        this.inputTypeReader();
    }

    public void inputTypeReader() {
        System.out.println("Nhập loại bạn đọc là một trong các lựa chọn dưới đây: ");
        System.out.println("1. Sinh viên");
        System.out.println("2. Học viên cao học");
        System.out.println("3. Giáo viên");

        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.print("Loại bạn đọc được chọn không hợp lệ vui lòng chọn lại: ");
        } while (choice > 3 || choice < 1);
        switch (choice) {
            case 1:
                this.setCategoryReader(ReaderType.SINH_VIEN);
                break;
            case 2:
                this.setCategoryReader(ReaderType.HV_CAO_HOC);
                break;
            case 3:
                this.setCategoryReader(ReaderType.GIAO_VIEN);
                break;
        }
    }

    @Override
    public int compareTo(BanDoc banDoc) {
        return  (this.getName().compareTo(banDoc.getName()));
    }
}
