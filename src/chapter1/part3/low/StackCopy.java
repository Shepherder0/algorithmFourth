package chapter1.part3.low;

import java.util.Iterator;
import java.util.Stack;

/**
 * 1.3.12
 * @author mulw
 *
 */
public class StackCopy<Item> implements Iterable<Item>{
    
    private class Node
    {
        Item item;
        Node next;
    }
    private Node first;
    private int N;
    public boolean isEmpty()
    {
        return N==0;
    }
    public int size()
    {
        return N;
    }
    public void push(Item item)
    {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Item peek() {
        Item item = first.item;
        return item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    public class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    /**
     * 复制一个stackCopy
     * @param strStack
     * @return
     */
    public static Stack<String> copy(Stack<String> strStack)
    {
        Stack<String> reCopy = new Stack<String>();
//        String[] strs = new String[strStack.size()];
//        for (int i = 0; i < strs.length; i++) {
//            strs[i] = strStack.pop();
//        }
//        for (int i = strs.length-1; i >= 0; i--) {
//            reCopy.push(strs[i]);
//            strStack.push(strs[i]);
//        }
        //果然迭代器比较快
        for (String s : strStack) {
            reCopy.push(s);
        }
        return reCopy;
    }
    
    public static void main(String[] args) {
        Stack<String> strStack = new Stack<String>();
        strStack.push("hello");
        strStack.push("world");
        Stack<String> strCopy = StackCopy.copy(strStack);
        System.out.println(strStack);
        System.out.println(strCopy);
        while (!strCopy.isEmpty())
        {
            System.out.print(strCopy.pop()+",");
        }
    }
}
