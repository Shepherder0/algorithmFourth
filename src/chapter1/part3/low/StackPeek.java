package chapter1.part3.low;

import java.util.Iterator;

/**
 * 1.3.7
 * 链表实现，压栈-->向链表的头部新增一个节点
 * （或者尾部新增一个姐点，保持push()和pop()一致即可）
 * @author mulw
 *
 */
public class StackPeek<Item> implements Iterable<Item> 
{
    private class Node
    {
        Item item;
        Node next;
    }
    private Node first;//栈顶元素，及最后一个压进栈里面的
    private int N;
    
    public boolean isEmpty() 
    {
        return N==0;
    }
    public int Size() 
    {
        return N;
    }
    //压栈
    public void push(Item item) 
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    //抛出元素
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    //返回最近添加的元素，而不抛出
    public Item peek() {
        Item item = first.item;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**
     * 使栈能够使用迭代而添加
     * @author mulw
     *
     */
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
    
    public static void main(String[] args) {
        StackPeek<String> sPeek = new StackPeek<String>();
        sPeek.push("world");
        sPeek.push("hello");
        System.out.println(sPeek.peek());
        for (String string : sPeek) {
            System.out.print(string+",");
        }
    }
}
