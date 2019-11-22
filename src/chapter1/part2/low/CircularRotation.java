package chapter1.part2.low;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1.2.6
 * @author mulw
 *
 */
public class CircularRotation {
    
    public static boolean isRotation(String s1,String s2) {
        Queue<Character> queue = new LinkedList<Character>();
        char[] char1 = s1.toCharArray();
        int s1Length = char1.length;
        for (int i = 0; i < s1Length; i++) {
            queue.offer(char1[i]);
        }
        
        boolean symbol = true;
        
        for (int i = 0; i < s1Length; i++) {
            //将队列的第一个元素放到最后
            char loString = queue.poll();
            queue.offer(loString);
            //创建一个新的String一遍比较
            String string = "";
            for (char qu : queue) {
                string += String.valueOf(qu);
            }
            if (string.equals(s2)) {
                symbol = true;
                return symbol;
            }
            if (!string.equals(s2)&& i == s1Length-1) {
                symbol = false;
                return symbol;
            }
        }
        return symbol;
    }
    public static void main(String[] args) {
        boolean isCircuar = isRotation("ACTGACG", "TGACGAC");
        System.out.print(isCircuar);
    }
}
