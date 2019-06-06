package Map;

import java.util.ArrayList;

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

    private ArrayList<Block> blocks;

    public Map() {
        blocks = new ArrayList<>(2);
        blocks.add(new Block.KernelBlock());
    }
}
