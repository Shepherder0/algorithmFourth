package chapter2.part1.low;

import java.awt.Color;
import java.util.Random;

import chapter2.part1.breforeTrainning.Example;
import edu.princeton.cs.algs4.StdDraw;

/**
 * 2.1.17
 * 
 * @author mulw
 *
 */
public class SortingAnimation extends Example {
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int len = a.length;
        int gap = 1;
        while (gap < len / 3) {
            gap = 3 * gap + 1;
        }
        while (gap >= 1) {
            // 一个i表示一个间隔组,每个间隔组内都进行一次插入排序
            for (int i = gap; i < len; i++) {
                for (int j = i; j >= gap && less(a[j], a[j - gap]); j -= gap) {
                    exch(a, j, j - gap);
                }
            }
            gap = gap / 3;
//            for (int i = 0; i < a.length; i++) {
//                System.out.print(a[i] + " ");
//            }
//            System.out.println();
            show(a);
        }
    }

    @SuppressWarnings("rawtypes")
    public static void show(Comparable[] a) {
        StdDraw.clear();
        StdDraw.setPenColor(Color.gray);
        StdDraw.setPenRadius(0.005);
        double x0 = 0.02;
        double y0 = 0;
        double x1 = 0.02;
        for (int i = 0; i < a.length; i++) {
            x0 += 0.01;
            x1 += 0.01;
            double y1 = Double.parseDouble(a[i].toString()) / 2;
            StdDraw.line(x0, y0, x1, y1);
        }
    }

    public static void main(String[] args) {
        Random randomX = new Random();
        String[] test = new String[40];
        for (int i = 0; i < 40; i++) {
            double x = randomX.nextDouble();
            test[i] = String.valueOf(x);
        }
        SortingAnimation.sort(test);
    }
}
