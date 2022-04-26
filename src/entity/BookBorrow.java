package entity;

import java.util.Arrays;

public class BookBorrow implements Comparable<BookBorrow> {
    public BookBorrow(BanDoc reader, BookBorrowDetail[] bookBorrowDetails) {
        this.reader = reader;
        this.bookBorrowDetails = bookBorrowDetails;
    }

    private BanDoc reader;
    private BookBorrowDetail[] bookBorrowDetails;

    public BanDoc getReader() {
        return reader;
    }

    public void setReader(BanDoc reader) {
        this.reader = reader;
    }

    public BookBorrowDetail[] getBookBorrowDetails() {
        return bookBorrowDetails;
    }

    public void setBookBorrowDetails(BookBorrowDetail[] bookBorrowDetails) {
        this.bookBorrowDetails = bookBorrowDetails;
    }

    @Override
    public String toString() {
        return "BookBorrow{" +
                "reader=" + reader +
                ", bookBorrowDetails=" + Arrays.toString(bookBorrowDetails) +
                '}';
    }


    @Override
    public int compareTo(BookBorrow o) {
        //so sánh số lượng sách mà bạn đọc đã mượn với 1 bạn đọc khác
        int bookQuantity1 = this.getBookBorrowDetails().length;
        int quantity1 = 0;
        for (int i = 0; i < this.getBookBorrowDetails().length; i++) {
            quantity1 += this.bookBorrowDetails[i].getSoLuong();
        }
        int quantity2 = 0;
        for (int i = 0; i < o.getBookBorrowDetails().length; i++) {
            quantity2 += o.bookBorrowDetails[i].getSoLuong();
        }
        return (quantity1 - quantity2);
    }
}
