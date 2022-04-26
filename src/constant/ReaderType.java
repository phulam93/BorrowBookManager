package constant;

public enum ReaderType {
    SINH_VIEN("Sinh Viên"),
    HV_CAO_HOC("Học Viên Cao Học"),
    GIAO_VIEN("Giáo Viên");

    public final String value;

    ReaderType(String value) {
        this.value = value;
    }
}
