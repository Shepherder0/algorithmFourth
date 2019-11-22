package chapter2.part1.low;

import chapter2.part1.breforeTrainning.Example;

/**
 * 2.1.1
 * @author mulw
 *
 */
public class Selection extends Example {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        String[] testArray = {"E", "A","S", "Y", "Q", "U",
                "E", "T", "I", "O", "N" };
        Selection.sort(testArray);
    }
}
