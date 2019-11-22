package chapter1.part5.low;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.5.3
 * @author mulw
 *
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;
    private int arrayAccessTimes;
    
    public WeightedQuickUnionUF(int N) {
        arrayAccessTimes = 0;
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = i;
        }
    }
    
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int find(int p) {
        while (p != id[p]) {
            arrayAccessTimes++;
            p = id[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        arrayAccessTimes++;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            //读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            //如果已经连通则忽略
            if (wqu.connected(p, q)) continue;
            //归并分量
            wqu.union(p, q);
            for (int i = 0; i < wqu.id.length; i++) {
                StdOut.print(wqu.id[i] + " ");
            }
            System.out.println();
            System.out.println("数组访问次数: "+ wqu.arrayAccessTimes);
            //将每一次的访问次数清零
            wqu.arrayAccessTimes = 0;
        }
    }
}
