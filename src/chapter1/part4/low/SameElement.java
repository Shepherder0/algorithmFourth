package chapter1.part4.low;

/**
 * 1.4.11
 * @author mulw
 *
 */
public class SameElement
{
    public static void getSameElement(int[] a, int[] b)
    {
        //找到更小的循环次数
        int count = a.length < b.length ? a.length : b.length;
        for (int i = 0; i < count; i++)
        {
            if (a[i] == b[i]) System.out.println(b[i]);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,1,1,1,2,3,3,4,5,67};
        int[] b = {1,1,1,1,2,2,2,5,5,67};
        SameElement.getSameElement(a, b);
    }
}
