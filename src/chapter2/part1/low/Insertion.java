package chapter2.part1.low;

import chapter2.part1.breforeTrainning.Example;

/**
 * 2.1.4
 * @author mulw
 *
 */
public class Insertion extends Example {
    
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        //将a[i]插入到a[i-1],a[i-2]...中
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                exch(a, j, j-1);
            }
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String[] test = {"E", "A","S", "Y", "Q", "U",
                "E", "T", "I", "O", "N" };
        Insertion.sort(test);
    }
}
