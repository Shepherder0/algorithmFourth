package chapter1.part5.low;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.5.1
 * @author mulw
 *
 */
public class UF {
    private int[] id;
    private int count;
    private int arrayAccessTimes;
    
    public UF(int N) {
        arrayAccessTimes = 0;
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
        arrayAccessTimes++;
        return id[p];
    }
    
    public void union(int p, int q) {
        //将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);
        //如果p和q已经在相同的分量之中则不需要采取任何行动
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            arrayAccessTimes++;
            if (id[i] ==pID) id[i] = qID;
        }
        count--;
    }
    
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            //读取整数对
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            //如果已经连通则忽略
            if (uf.connected(p, q)) continue;
            //归并分量
            uf.union(p, q);
            for (int i = 0; i < uf.id.length; i++) {
                StdOut.print(uf.id[i] + " ");
            }
            System.out.println();
            System.out.println("数组访问次数: " + uf.arrayAccessTimes);
            uf.arrayAccessTimes = 0;
        }
    }
}
