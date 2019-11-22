package chapter1.part3.low;

import java.util.Stack;

/**
 * 1.3.10
 * @author mulw
 *
 */
public class MiddleToAfter {
    //存放表达式
    private static Stack<String> mainStack = new Stack<String>();
    private static String mainString = "";
    
    public static String changeMiddleToAfter(String s)
    {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            String str = String.valueOf(chars[i]);
            if (chars[i] >= '0' && chars[i] <= '9')
                mainString += str;
            else if ("(".equals(str))
                mainStack.push(str);
            else if (")".equals(str))
            {
                while (!"(".equals(mainStack.peek()))
                {
                    mainString += mainStack.pop();
                }
                mainStack.pop();
            }else {
                // 操作符->将栈顶输出,直到栈顶优先级小于该操作符,最后把该操作符压入栈
                while (!mainStack.isEmpty() && checkLevel(mainStack.peek(),str))
                {
                    mainString += mainStack.pop();
                }
                mainStack.push(str);
            }
        }
        while (!mainStack.isEmpty())
        {
            mainString += mainStack.pop();
        }
        return mainString;
    }
    
    /**
     * 判断操作符a的优先级是否不小于b
     * @param a
     * @param b
     * @return
     */
    public static boolean checkLevel(String a,String b)
    {
        if ("*".equals(a) || "/".equals(a))
        {
            if ("+".equals(b) || "-".equals(b))
                return true;
            else if("*".equals(b) || "/".equals(b))
                return true;
            else return false;
        }else if ("+".equals(a) || "-".equals(a))
        {
            if ("+".equals(b) || "-".equals(b))
                return true;
            else return false;
        }else return false;
    }
    public static void main(String[] args) {
        String string = "2*3/(2-1)+3*(4-1)";
        System.out.println(changeMiddleToAfter(string));
    }
}
