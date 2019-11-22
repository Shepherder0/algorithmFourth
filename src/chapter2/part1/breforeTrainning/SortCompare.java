package chapter2.part1.breforeTrainning;

import chapter2.part1.low.InsertionSentry;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 比较两种排序算法
 * @author mulw
 *
 */
public class SortCompare {
    public static double time(String alg, Double[] a)
    {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("InsertionSentry")) InsertionSentry.sort(a);
        return timer.elapsedTime();
    }
    
    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++)
        {
            for (int i = 0; i < N; i++)
            {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }
    
    public static void main(String[] args) {
        String alg1 = "InsertionSentry";
        String alg2 = "Insertion";
        
        int N = 10000;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is ", N, alg1);
        StdOut.printf("%.4f times faster than %s\n", t2/t1, alg2);
    }
}
