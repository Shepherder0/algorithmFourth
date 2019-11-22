package chapter1.part4.high;

/**
 * 1.4.18
 * 未能成功实现
 * @author mulw
 *
 */
public class LocalMin {
    /**
     * 数组的局部最小元素
     * @param a
     */
    public static void getLocalMin(int[] a)
    {
        int len = a.length;
        int mid = len/2;
        while (mid > 0 && mid < len)
        {
            if (a[mid] < a[mid+1] && a[mid] < a[mid-1])
            {
                System.out.println(mid);
                break;
            }
            else if (a[mid+1] <= a[mid-1])
                mid++;
            else if (a[mid-1] <= a[mid+1])
                mid--;
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1,3,5,7,8,11,9,10,4,8,6,9};
        LocalMin.getLocalMin(a);
    }
}
