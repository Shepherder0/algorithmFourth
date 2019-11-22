package chapter1.parts3.high;

/**
 * 1.3.32
 * @author mulw
 *
 */
public class StequeImp<Item> implements Steque<Item>{
    private int N;
    private Node last;
    private Node first;
    private class Node
    {
        Item item;
        Node next;
    }
    @Override
    public void push(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    @Override
    public void enqueue(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }
    
    public static void main(String[] args) {
        StequeImp<String> testQue = new StequeImp<String>();
        testQue.push("I");
        testQue.enqueue("hello");
        testQue.push("am");
        testQue.push("shepherd");
        testQue.pop();
        
    }
}
