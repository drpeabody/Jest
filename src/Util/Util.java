package Util;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 */

public class Util {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void log(Object[] var0) {
        System.out.print("[ ");

        for(int i = 0; i < var0.length - 1; ++i) {
            System.out.print(var0[i].toString() + ", ");
        }

        if (var0.length > 0) {
            System.out.println(var0[var0.length - 1].toString() + " ]");
        } else {
            System.out.println("\b]");
        }

    }
    public static void log(Object var0) {
        System.out.println(var0.toString());
    }
    public static void logp(Object var0) {
        System.out.print(var0.toString());
    }
}
