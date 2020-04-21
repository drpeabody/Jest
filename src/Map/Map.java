package Map;

import Util.Util;
import jdk.nashorn.api.scripting.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * @author Abhishek
 * @since 02 Jun, 2019
 */

public class Map {
    /*
    The Map Concept

    Over the next several day,s the following will be the philosophy along which
    he Map code is written.

    Map is composed of may Blocks, each Block is composed of many Directories.
    Directories are like rooms in a Block like House. They contain NPCs (Processes)
    and Hex-Codes. Hex-Codes can later be used to craft tools tat allow you to play with the system.

    The Directories within a Block have to procedurally generated.

    Each Block contains the following Directories at the start:
    1) The Output Dir
    2) The Metadata Dir

    But they will be forbidden for now.

    The Kernel Block is the only persistent and default Block. It is restricted by the highest
    security badge.

     */

    static final String[] nouns = {
            "Table", "Chair", "Sky", "Earth", "Child"
    };
    static final String[] adjectives = {
            "Small", "Big", "Dark", "Bright", "Normal"
    };
    static final String[] conjuncions = {
            "and", "of", "in"
    };


    private Dir currDir;
    private final long seed;

    public Map(String seed){
        this(seed.hashCode());
    }

    public Map(long seed) {
        this.seed = seed;
        currDir = Dir.getNewDirectory(seed, 0);
        currDir.generate(seed);
    }

    public void chageDir(int childIndex){
        if(childIndex < 0 || childIndex > currDir.subdirs.length - 1){
            return;
        }
        currDir = currDir.subdirs[childIndex];
        currDir.generate(seed);
    }

    public void goUp(){
        currDir = currDir.parent;
        currDir.generate(seed);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Map m = new Map("Does this work?");

        String input;

        do {
            input = br.readLine();
            switch (input){
                case "exit":
                    System.exit(0);
                    break;
                case "ls":
                    System.out.println(m.currDir);
                    break;
                case "up":
                    m.goUp();
                    break;
                case "mem":
                    Util.log(Util.getMemUsage('m') + "MB");
                default:
                    String st[] = input.split(" ");
                    if(st[0].equals("cd") && st.length > 1){
                        m.chageDir(Integer.parseInt(st[1]));
                    }
            }
        } while (true);

    }
}
