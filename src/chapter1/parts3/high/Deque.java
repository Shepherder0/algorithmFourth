package chapter1.parts3.high;

import java.util.Iterator;

/**
 * 1.3.33
 * @author mulw
 *
 */
public class Deque<Item> implements DequeIble<Item> , Iterable<Item>
{
    private int N;
    private DoubleNode first;
    private DoubleNode last;
    
    private class DoubleNode
    {
        Item item;
        DoubleNode previous;
        DoubleNode next;
    }
    
    public Deque() {}
    @Override
    public boolean isEmpty()
    {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void pushLeft(Item item)
    {
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        first.next = oldFirst;
        first.previous = null;
        if (isEmpty())
            last = first;
        N++;
    }

    @Override
    public void pushRight(Item item)
    {
        DoubleNode oldLast = last;
        last = new DoubleNode();
        last.item = item;
        last.next = null;
        if (isEmpty())
        {
            first = last;
        }else
        {
            last.previous = oldLast;
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Item popLeft()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Item popRight()
    {
        Item item = last.item;
        last = last.previous;
        last.next = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>
    {
        private DoubleNode current = first;
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
    }
    
    public static void main(String[] args)
    {
        Deque<String> testDeque = new Deque<String>();
        testDeque.pushLeft("hello");
        testDeque.pushRight("world");
        testDeque.pushLeft("I");
        testDeque.pushRight("Shepherd");
        testDeque.popLeft();
        testDeque.popRight();
    }
    
}
