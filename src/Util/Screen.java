package Util;

import java.util.ArrayList;

/**
 * @author Abhishek
 * @since 03 Jun, 2019
 */

public class Screen {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String PURPLE_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BG = "\u001B[47m";

    public static final int ALIGN_LEFT = 66;
    public static final int ALIGN_MIDDLE = 67;
    public static final int ALIGN_RIGHT = 68;

    String left[];
    int height, width;



    public Screen(int height, int width){
        this.height = height;
        this.width = width;
        left = new String[height];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void clearScreen(){
        Util.logp("\033[H\033[2J");
        for (int i = 0; i < height; i++){
            left[i] = null;
        }
    }

    public void drawText(String text, int row, int col){
        if(text== null || text.isEmpty()){
            return;
        }
        Util.logp(String.format("%c[%d;%df", 0x1B, row, col));
        Util.logp(text);
    }

    public void fillLne(String pattern, int height){
        if(pattern == null || pattern.isEmpty()){
            pattern = "  ";
        }
        while(width > pattern.length()) pattern = pattern.concat(pattern);
        Util.logp(String.format("%c[%d;0f", 0x1B, height));
        Util.logp(pattern.substring(0, width));
    }

    public void setLine(String line, int height){
        if(height < 0 || height > this.height) return;
        left[height] = line;
    }

    public void refresh(){
        for (int i = 0; i < height; i++){
            if(left[i] != null){
                Util.logp(String.format("%c[%d;0f", 0x1B, i));
                Util.logp(left[i]);
            }
        }
    }




}
