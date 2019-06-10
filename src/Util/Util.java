package Util;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 */

public class Util {

    public static String str(Stream<?> l){
        StringBuilder res = new StringBuilder("[ ");
        l.forEach(s -> res.append(s).append(", "));
        if(res.length() > 2) res.append("\b\b ]");
        else res.append("\b]");
        return res.toString();
    }
    public static String str(Object[] var0){
        String res = "[ ";
        for(int i = 0; i < var0.length - 1; ++i) {
            res = res.concat(var0[i].toString() + ", ");
        }

        if (var0.length > 0) {
            return res.concat(var0[var0.length - 1].toString() + " ]");
        } else {
            return res.concat("\b]");
        }
    }

    public static void log(Object[] var0) {
        System.out.println(str(var0));
    }
    public static void log(Object var0) {
        System.out.println(var0.toString());
    }
    public static void logp(Object var0) {
        System.out.print(var0.toString());
    }

    public static long getMemUsage(char c){
        long us = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        c = Character.toLowerCase(c);
        if(c == 'k') return (us >> 10);
        else if(c == 'm') return (us >> 20);
        else if(c == 'g') return (us >> 30);
        return us;
    }

    public static <T, R> Stream<R> map(T o[], Function<? super T,? extends R> f){
        if(o.length == 0) return Stream.empty();
        else return Arrays.stream(o).map(f);
    }

    public static String[] cleanCommand(String a){
        return Arrays.stream(a.split(" "))
                .filter( s -> !s.isEmpty() )
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    public static String getSystemOutput(String cmd){
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            p.waitFor();
            StringBuilder sb = new StringBuilder();
            while(br.ready())
                sb.append(br.readLine()).append("\n");
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
