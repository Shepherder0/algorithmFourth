package chapter1.parts3.high;

import java.util.Iterator;

/**
 * 1.3.40
 * @author mulw
 *
 */
public class MoveToFront<Item> implements Iterable<Item>
{
    private int N = 0;
    private Node first;
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    
    public void enqueue(Item item)
    {
        if (isEmpty())
        {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            N++;
        }
        else
        {
            Node current = first;
            while (current.next != null)
            {
                if (current.next.item.equals(item))
                {
                    dequeue(current);
                    break;
                }
                current = current.next;
            }
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            N++;
        }
    }
    
    /**
     * 删除current的下一个节点
     * @param current
     * @return
     */
    public Item dequeue(Node current)
    {
        Item item = current.next.item;
        current.next = current.next.next;
        current.next = null;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {}
    }
    
    public static void main(String[] args) {
        MoveToFront<Character> test = new MoveToFront<Character>();
        String str = "hello,Shepherd";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            test.enqueue(chars[i]);
        }
        for (char c : test) {
            System.out.print(c);
        }
    }
}
