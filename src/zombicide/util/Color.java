package zombicide.util;

public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    BLACK_BOLD("\u001B[1;30m"),
    BLUE_BOLD_BRIGHT("\u001B[1;94m"),
    CYAN_BOLD_BRIGHT("\u001B[1;96m"),
    GREEN_BG_BRIGHT("\u001B[102m"),
    PURPLE_BG_BRIGHT("\u001B[105m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
