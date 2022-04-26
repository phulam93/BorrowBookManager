package constant;

public enum BookCategory {
    KH_TN("Khoa học tự nhiên"),
    VH_NT("Văn học - Nghệ thuật"),
    DTVT("Điện tử viễn thông"),
    CNTT("Công nghệ thông tin");

    public final String value;

    BookCategory(String value) {
        this.value = value;
    }
}
