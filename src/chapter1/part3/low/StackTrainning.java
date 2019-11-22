package chapter1.part3.low;
import java.util.*;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * 1.3.2
 * @author mulw
 *
 */
public class StackTrainning {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while(!StdIn.isEmpty()) {
            String itemString = StdIn.readString();
            if(!itemString.equals("-"))
                stack.push(itemString);
            else if(!stack.isEmpty())
                StdOut.print(stack.pop()+",");
        }
        StdOut.println("("+stack.size()+"left on stack");
    }
}
