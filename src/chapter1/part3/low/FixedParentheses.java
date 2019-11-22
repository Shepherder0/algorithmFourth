package chapter1.part3.low;

import java.util.Stack;

/**
 * 1.3.9
 * 建议使用调试模式查看每个栈的元素信息
 * @author mulw
 *
 */
public class FixedParentheses {
    //存放* /
    private static Stack<String> stack = new Stack<String>();
    //存放表达式
    private static Stack<String> stackMain = new Stack<String>();
    //存放临时表达式
    private static Stack<String> stackTemp = new Stack<String>();
    
    public static String fixingParentheses(String s) {
        //将字符串转为字符数组，方便取出单个字符
        char[] temp = s.toCharArray();
        //用于判断最后两个括号，需要进行另外的操作
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            String tempStr = String.valueOf(temp[i]);
            if ("*".equals(tempStr)||"/".equals(tempStr)) {
                stack.push(tempStr);
            }else if (!")".equals(tempStr)) {
                count = 0;
                stackTemp.push(tempStr);
            }else if(!stack.isEmpty() && count > 0) {
                //去stackMain里面两个元素和stack里面的一个元素做字符串拼接
                String tempString = stackMain.pop();
                tempString = "("+stackMain.pop()+ stack.pop()+tempString+")";
                stackMain.push(tempString);
                count++;
            }else {
                count++;
                stackTemp.push(tempStr);
                String str = "";
                while(!stackTemp.isEmpty()) {
                    str += stackTemp.pop();
                }
                str += "(";
                StringBuilder sb = new StringBuilder(str);
                stackMain.push(sb.reverse().toString());
            }
        }
        //最后的stackMain里面应该只有一个元素，及所求的完整表达式
        String reString = stackMain.pop();
        return reString;
    }
    
    public static void main(String[] args) {
        String string = fixingParentheses("1+2)*3-4)*5-6)))");
        System.out.print(string);
    }
}
