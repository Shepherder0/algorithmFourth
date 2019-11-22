package chapter2.part1.low;

import chapter2.part1.breforeTrainning.Example;

/**
 * 
 * @author mulw
 *
 */
public class Shell extends Example{
    
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int len = a.length;
        int gap = 1;
        while (gap < len/3) {
            gap = 3*gap + 1;
        }
        while (gap >= 1) {
            //一个i表示一个间隔组,每个间隔组内都进行一次插入排序
            for (int i = gap; i < len ; i++) {
                for (int j = i; j >= gap && less(a[j], a[j-gap]); j -= gap) {
                    exch(a, j, j-gap);
                }
            }
            gap = gap/3;
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        String[] test = {"A", "A","S", "Y", "S", "H", "E", "L", "L",
                "S", "O", "R", "T", "Q", "U",
                "E", "T", "I", "O", "N" };
        Shell.sort(test);
    }
}
