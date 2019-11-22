package chapter1.part3.linkedList;


/**
 * 1.3.29
 * @author mulw
 *
 */
public class CircleQueue<Item> {
    private class Node
    {
        Item item;
        Node next;
    }
    private int N;
    private Node last;
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int Size()
    {
        return N;
    }
    
    public void enQueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
        {
            last.next = last;
        }
        else
        {
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;
    }
    
    public Item deQueue()
    {
        Node firstNode = last.next;
        Item item = firstNode.item;
        if (isEmpty())
        {
            last = null;
        }else
        {
            firstNode = firstNode.next;
            last.next = firstNode;
        }
        N--;
        return item;
    }
    
    public static void main(String[] args) {
        //在debug中查看数据
        CircleQueue<String> sCircleQueue = new CircleQueue<String>();
        sCircleQueue.enQueue("I");
        sCircleQueue.enQueue("am");
        sCircleQueue.enQueue("shepherd");
        sCircleQueue.deQueue();
        sCircleQueue.deQueue();
    }
}
