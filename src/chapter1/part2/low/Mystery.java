package chapter1.part2.low;

/**
 * 1.2.7
 * 字符串反转
 * @author mulw
 *
 */
public class Mystery {
    public static String myseryString(String s) {
        int N = s.length();
        if(N <= 1) return s;
        String aString = s.substring(0,N/2);
        String bString = s.substring(N/2,N);
        return myseryString(bString)+myseryString(aString);
    }
    
    public static void main(String[] args) {
        String string = myseryString("hello");
        System.out.println(string);
    }
}
