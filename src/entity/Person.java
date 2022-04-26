package entity;

import java.util.Scanner;

public abstract class Person implements InputTable {
    protected int id;
    protected String name;
    protected String address;
    protected String phoneNumber;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void inputInfo() {
        // thực hiện nhập thông tin cho bạn đọc
        System.out.println("Nhập tên cho bạn đọc");
        this.setName(new Scanner(System.in).nextLine());
        System.out.println("Nhập địa chỉ cho bạn đọc");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.println("Nhập số điện thoại cho bạn đọc");
        this.setPhoneNumber(new Scanner(System.in).nextLine());
    }
}
