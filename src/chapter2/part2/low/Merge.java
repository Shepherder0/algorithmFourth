package chapter2.part2.low;

/**
 * 2.2.1
 * 
 * @author mulw
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Merge {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
            
            /********测试用********/
            System.out.print(a[k] + " ");
        }
        System.out.println();
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 排序左半边
        sort(a, lo, mid);
        // 排序右半边
        sort(a, mid + 1, hi);
        // 归并结果
        merge(a, lo, mid, hi);
        
    }

    public static void main(String[] args) {
        Comparable[] test = { "A", "E", "Q", "S", "U", "Y", "E", "I", "N", "O", "S", "T" };
        Merge.sort(test);
    }
}
