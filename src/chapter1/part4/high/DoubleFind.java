package chapter1.part4.high;

/**
 * 1.4.20
 * @author mulw
 *
 */
public class DoubleFind
{
    /**
     * 找到双调数组的最大值的索引
     * @param a
     * @return
     */
    public static int getMax(int[] a)
    {
        int left = 0;
        int right = a.length-1;
        while(true)
        {
            int mid = (left+right)/2;
            if(a[mid] > a[mid-1] && a[mid] > a[mid+1])
                return mid;
            else if (a[mid-1] > a[mid+1]) right = mid -1;
            else if(a[mid-1] < a[mid+1]) left = mid+1;
            else return mid;
        }
    }
    
    public static boolean getKey(int[] a, int key)
    {
        boolean symbol = false;
        int max = getMax(a);
        if (key > a[max]) return symbol;
        else if (key == a[max]) return true;
        else
        {
            //左边,二分法查询
            int low = 0;
            int hi = max;
            while(low <= hi)
            {
                int mid = (low+hi)/2;
                if (key < a[mid]) hi = mid-1;
                else if (key > a[mid]) low = mid+1;
                else
                {
                    symbol = true;
                    break;
                }
            }
            //右边，二分法查询
            int low2 = max;
            int hi2 = a.length-1;
            while(symbol == false && low2 <= hi2)
            {
                int mid = (low2+hi2)/2;
                if (key < a[mid]) hi = mid+1;
                else if (key > a[mid]) low = mid -1;
                else
                {
                    symbol = true;
                    break;
                }
            }
        }
        return symbol;
        
    }
    
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,5,4,3};
        int i = DoubleFind.getMax(a);
        System.out.println(i);
        boolean symbol = DoubleFind.getKey(a, 10);
        System.out.print(symbol);
    }
}
