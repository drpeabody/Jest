package Util;

import java.io.*;
import java.util.Arrays;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 */

public class Util {

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

    public static String[] cleanCommand(String a){
        return Arrays.stream(a.split(" "))
                .filter( s -> !s.isEmpty() )
                .map( s -> s.toLowerCase() )
                .toArray(s -> new String[s] );
    }

    public static String getSystemOutput(String cmd){
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            p.waitFor();
            StringBuilder sb = new StringBuilder();
            while(br.ready())
                sb.append(br.readLine() + "\n");
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static Process exec(String cmd){
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            return p;
        } catch (IOException e) {
            return null;
        }
    }

    public static Process execAndWait(String cmd){
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            return p;
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}
