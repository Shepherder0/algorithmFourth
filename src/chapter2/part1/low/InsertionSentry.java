package chapter2.part1.low;

import chapter2.part1.breforeTrainning.Example;

/**
 * 2.1.24
 * @author mulw
 *
 */
public class InsertionSentry extends Example{
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] a) {
        int len = a.length;
        int sentry = 0;
        //ps：找到最小元素的索引
        for (int i = 1; i < len; i++) {
            if (less(a[i], a[i-1])) {
                sentry = i;
            }
        }
        //把最小元素放在第一位
        exch(a, 0, sentry);
        //ps:后面有j-1，所以i从2开始
        //实现有问题
        for (int i = 2; i < len; i++) {
            for (int j = i; less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
    
    public static void main(String[] args) {
        //在SortCompare中比较
        
    }
}
