package chapter1.part3.low;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1.3.4
 * @author mulw
 *
 */
public class Parentheses {
    private static Stack<String> textStack = new Stack<String>();
    private static Stack<String> leftStack = new Stack<String>();
    
    public static boolean isParenthesesFixed(String s) {
        char[] temp = s.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            String tempString = String.valueOf(temp[i]);
            if ("(".equals(tempString)||"[".equals(tempString)||"{".equals(tempString)) {
                leftStack.push(tempString);
            }else if (")".equals(tempString)||"]".equals(tempString)||"}".equals(tempString)) {
                leftStack.pop();
            }else {
                textStack.push(tempString);
            }
        }
        //如果完全匹配，则left应为空
        if (leftStack.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(Parentheses.isParenthesesFixed(string));
    }
}
