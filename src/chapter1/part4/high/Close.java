package chapter1.part4.high;

import java.util.Arrays;

/**
 * 1.4.16
 * @author mulw
 *
 */
public class Close
{
    public static void getClosePair(int[] a)
    {
        //没有计算此处的时间消耗
        Arrays.sort(a);
        int len = a.length;
        int symbol = 0;
        int min = Math.abs(a[0] - a[len-1]);
        for (int i = 0; i < len-1; i++)
        {
            if (a[i+1] - a[i] < min)
            {
                symbol = i;
                min = a[i+1] - a[i];
            }
        }
        System.out.println("相隔距离最近的其中一对数是：");
        System.out.print(a[symbol] + ", " + a[symbol+1]);
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 6, 12, 12, 33, -1, -2};
        Close.getClosePair(a);
    }
}
