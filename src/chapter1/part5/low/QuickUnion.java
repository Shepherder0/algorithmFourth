package chapter1.part5.low;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.5.2
 * @author mulw
 *
 */
public class QuickUnion {
    private int[] id;
    private int count;
    private int arrayAccessTime;
    
    public QuickUnion(int N) {
        arrayAccessTime = 0;
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    public int count() {
        return count;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    public int find(int p) {
        arrayAccessTime++;
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        arrayAccessTime++;
        id[pRoot] = qRoot;
        count--;
    }
    
    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnion qu = new QuickUnion(N);
        while (!StdIn.isEmpty()) {
            //读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            //如果已经连通则忽略
            if (qu.connected(p, q)) continue;
            //归并分量
            qu.union(p, q);
            for (int i = 0; i < qu.id.length; i++) {
                StdOut.print(qu.id[i] + " ");
            }
            System.out.println();
            System.out.println("数组访问次数: " + qu.arrayAccessTime);
            qu.arrayAccessTime = 0;
        }
    }
}
