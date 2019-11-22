package chapter1.part2.low;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.4
 * 1.2.5
 * @author mulw
 *
 */
public class StringTrainning {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
        
        String s = "Hello world";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
    }
}
