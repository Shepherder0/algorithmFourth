package chapter1.part2.high;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.2.15
 * @author mulw
 *
 */
public class ReadInt {
    
    public static int[] readInts(String name) {
        In in = new In(name);
        String inputString = StdIn.readAll();
        String[] wordStrings = inputString.split("\\s+");
        int[] ints = new int[wordStrings.length];
        for (int i = 0; i < wordStrings.length; i++) {
            ints[i] = Integer.parseInt(wordStrings[i]);
        }
        return ints;
    }
}
