package chapter1.part4.high;

import java.util.Arrays;

/**
 * 1.4.15
 * @author mulw
 *
 */
public class TwoSumFaster {
    
    /**
     * 
     * @param arr 有序数组
     * @return 和为0的整数对的数量
     */
    public static int count(int[] arr)
    {
        int cnt = 0;
        //此时arr[hi]为数组里面的最大值元素
        int hi = arr.length-1;
        for (int i = 0; i < hi; ) {
            if (arr[i] + arr[hi] < 0)
                i++;
            else if (arr[i] + arr[hi] > 0)
                hi--;
            else
            {
                cnt++;
                i++;
                hi--;
            }
        }
       return cnt;
    }
    
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,8,-1,-2,-3,-5};
        Arrays.sort(a);
        int i = TwoSumFaster.count(a);
        System.out.println(i);
    }
}
