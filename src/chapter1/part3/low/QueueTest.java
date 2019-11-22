package chapter1.part3.low;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 1.3.15
 * 未实现16和17
 * @author mulw
 *
 */
public class QueueTest
{
    public static String getValue(Queue<String> sQueue,int k)
    {
        String[] strings = new String[sQueue.size()];
        Stack<String> stack = new Stack<String>();
        for (String str : sQueue)
        {
            stack.push(str);
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = stack.pop();
        }
        return strings[k-1];
    }
    
    public static void main(String[] args)
    {
        Queue<String> strings = new LinkedBlockingDeque<String>();
        strings.offer("1");
        strings.offer("2");
        strings.offer("3");
        String i = QueueTest.getValue(strings, 1);
        System.out.println(i);
    }
}
