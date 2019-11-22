package chapter1.part4.high;

import java.util.Arrays;

import chapter1.part2.low.BinarySearch;

/**
 * 1.4.14
 * @author mulw
 *
 */
public class Sum4 {
    
    public static int count(int[] arr)
    {
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                for (int k = j+1; k < arr.length; k++)
                {
                    //若存在四个数 a+b+c+d = 0  => -(a+b+c)就一定存在于该数组中 
                    if (BinarySearch.binarySearh(-arr[i]-arr[j]-arr[k], arr) > k)
                        cnt++;
                }
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr  = {1,1,1,1,-1,-2,-3,-4,5};
        int i = Sum4.count(arr);
        System.out.println(i);
    }
}
