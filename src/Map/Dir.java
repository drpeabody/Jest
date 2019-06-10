package Map;

import Util.Util;

import java.util.Random;

/**
 * @author Abhishek
 * @since 08 Jun, 2019
 */
class Dir {
    private int descriptor;
    private String name;
    Dir parent;
    Dir subdirs[];
    private boolean isGenerated;

    private Dir(long seed, int dirDescriptor, Dir parent, Dir child){
        // Only generates The name of this directory so Map can be lazy generated
        this.descriptor = dirDescriptor & 0x00ffffff;
        name = makeNewDirName(getRand(seed));
        // Parent can be null, in which case it will be generated along with other data.
        this.parent = parent;
        // subdirs can be null, in which case it will be generated along with other data.
        if(child == null)
            subdirs = null;
        else
            subdirs = new Dir[]{ child };
        isGenerated = false;
    }

    static Dir getNewDirectory(long seed, int descriptor){
        return new Dir(seed, descriptor, null, null);
    }

    void generate(long seed){
        // Generates all features of the Directory such as sub directories and Hex Lists.

        if(isGenerated) return;
        isGenerated = true;

        Random r = getRand(seed);

        if(parent == null)
            parent = new Dir(seed, r.nextInt(), null, this);

        double decider = r.nextDouble();
        // Sub Dir might already have a directory in it.
        // 25% chance Dir has only 1 child
        // 50% chance DIr has 2 children and another 25% for 3 children

        if(subdirs == null) {
            subdirs = new Dir[]{ new Dir(seed, r.nextInt(), this, null) };
        }
        if(decider > 0.25 && decider < 0.75) {
            subdirs = new Dir[]{
                    subdirs[0],
                    new Dir(seed, r.nextInt(), this, null)
            };
        } else if (decider > 0.75) {
            subdirs = new Dir[]{
                    subdirs[0],
                    new Dir(seed, r.nextInt(), this, null),
                    new Dir(seed, r.nextInt(), this, null)
            };
        }

    }

    public String toString(){
        if(subdirs != null)
            return String.format("%s -> %s -> %s",
                    parent.name, name, Util.str(Util.map(subdirs, s -> s.name)));
        else
            return parent.name + " -> " + name + " -> NULL";
    }

    private String makeNewDirName(Random r){
        return Map.adjectives[r.nextInt(Map.adjectives.length)] + " " +
                Map.nouns[    r.nextInt(Map.nouns.length)     ];
//                    conjuncions[r.nextInt(conjuncions.length)];
    }
    private Random getRand(long seed){
        return new Random(seed + descriptor);
    }
}