package entity;

public class BookBorrowDetail {

    private Sach sach;
    int soLuong;

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BookBorrowDetail(Sach sach, int soLuong) {
        this.sach = sach;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "BookBorrowDetail{" +
                "sach=" + sach +
                ", soLuong=" + soLuong +
                '}';
    }
}