package chapter1.part2.low;

import java.util.Arrays;

/**
 * 1.2.9
 * @author mulw
 *
 */
public class BinarySearch {
    
    /**
     * 二分法查找
     * @param k 需要查找的元素
     * @param array 数组
     * @return
     */
    public static int binarySearh(int k, int[] array) {
        Arrays.sort(array);
        int mid = 0;
        int low = 0;
        int high = array.length-1;
        while(low <= high) {
            mid = (low+high)/2;
            if (k < array[mid])
                high = mid-1;
            else if (k > array[mid])
                low = mid+1;
            else
                return k;
        }
        return -1;
    }
    
    /**
     * 带查询次数统计的二分查找
     * @param k
     * @param array
     * @param counter
     * @return
     */
    public static int rank(int k,int[] array,Counter counter) {
        Arrays.sort(array);
        int mid = 0;
        int low = 0;
        int high = array.length-1;
        while(low <= high) {
            counter.increment();
            mid = (low+high)/2;
            if (k < array[mid])
                high = mid-1;
            else if (k > array[mid])
                low = mid+1;
            else
                return k;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] array = {1,2,7,4,5,6};
//        int a = binarySearh(5, array);
//        System.out.print(a);
        Counter counter = new Counter("counter");
        rank(7, array, counter);
        System.out.println(counter.getCount());
        
    }
}
