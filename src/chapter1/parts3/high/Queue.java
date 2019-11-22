package chapter1.parts3.high;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.3.41
 * @author mulw
 *
 */
public class Queue<Item> implements Iterable<Item>
{
    private int N = 0;
    private Node first;
    private Node last;
    private class Node
    {
        Item item;
        Node next;
    }
    public Queue() {}
    public Queue(Queue<Item> q)
    {
        List<Item> itemList = new ArrayList<Item>();
        for (Item item : q)
            itemList.add(item);
        for (int i = 0; i < itemList.size(); i++)
        {
            //使用this指代当前对象
            this.enqueue(itemList.get(i));
        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>
    {
        Node current = first;
        @Override
        public boolean hasNext()
        {
            return current !=null;
        }
        @Override
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
        
    }
    public boolean isEmpty() { return N ==0;}
    public int size() { return N;}
    
    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        Queue<String> rQueue = new Queue<String>(q);
        rQueue.dequeue();
        for (String string : rQueue) {
            System.out.print(string + " ");
        }
        System.out.println();
        for (String string : q) {
           System.out.print(string + " "); 
        }
    }
}
