package chapter1.part2.low;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 1.2.10
 * @author mulw
 *
 */
public class VisualCounter {
    private long N;
    private long total;
    private long max;
    /**
     * 
     * @param N 执行的最大次数
     * @param max 最大绝对计数值
     */
    public VisualCounter(long N,long max) {
        long newMax = Math.abs(max);
        this.max = newMax;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-newMax, newMax);
        StdDraw.setPenRadius(.005f);
    }
    
    public int increment() {
        if (total >= max) {
            System.out.println("超过了本计数器的最大计数范围，结束计数");
            return -1;
        }
        N++;
        total++;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, total);
        return 0;
    }
    
    public int decrement() {
        if (total <= -max) {
            System.out.println("超过了本计数器的最大计数范围，结束计数");
            return -1;
        }
        N++;
        total--;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, total);
        return 0;
    }
    
    
    
    @Override
    public String toString() {
        return "VisualCounter [N=" + N + ", total=" + total + ", max=" + max + "]";
    }

    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter(500, 500);
        for (int i = 0; i < 1000; i++) {
            double temp = Math.random();
            if (temp >= 0.5) {
                counter.increment();
            }else {
                counter.decrement();
            }
        }
        System.out.println(counter);
    }
}
