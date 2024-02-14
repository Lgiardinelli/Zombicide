package zombicide.util;

public enum Color {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    BACK_RED("\u001B[41m"),
    BACK_PURPLE("\u001B[45m"),
    BACK_BLUE("\u001B[44m"),
    BACK_GREEN("\u001B[42m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
