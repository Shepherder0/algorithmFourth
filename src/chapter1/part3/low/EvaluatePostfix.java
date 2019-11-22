package chapter1.part3.low;

import java.util.Stack;

/**
 * 1.3.11
 * @author mulw
 *
 */
public class EvaluatePostfix
{
    private static Stack<String> mainStack = new Stack<String>();
    
    public static double getResultOfPostfix(String s)
    {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            String str = String.valueOf(chars[i]);
            if (chars[i] >= '0' && chars[i] <= '9')
            {
                mainStack.push(str);
            }else
            {
                double num1 = Double.parseDouble(mainStack.pop());
                double num2 = Double.parseDouble(mainStack.pop());
                switch (str)
                {
                case "+":
                    mainStack.push(String.valueOf(num1 + num2)); 
                    break;
                case "-":
                    //注意换位
                    mainStack.push(String.valueOf(num2 - num1));
                    break;
                case "*":
                    mainStack.push(String.valueOf(num1 * num2));
                    break;
                case "/":
                    mainStack.push(String.valueOf(num2 / num1));
                    break;
                default:
                    break;
                }
            }
        }
        return Double.parseDouble(mainStack.pop());
    }
    
    public static void main(String[] args) {
        double re = getResultOfPostfix("23*21-/341-*+");
        System.out.print(re);
    }
}
