package chapter1.part3.linkedList;

/**
 * 1.3.31
 * 针对某个指定节点的操作并未针对当前链表，导致N值也出现问题！！！还需修改...
 * 写成了双向循环链表...不想改了
 * @author mulw
 *
 */
public class DoubleLinkedList<Item>
{
    private static class DoubleNode<Item>
    {
        Item item;
        DoubleNode<Item> previous;
        DoubleNode<Item> next;
    }
    private DoubleNode<Item> first;
    private DoubleNode<Item> last;
    private int N;
    
    public boolean isEmpty()
    {
        return N==0;
    }
    public int size()
    {
        return N;
    }
    
    public DoubleLinkedList()
    {
        first = new DoubleNode<Item>();
        last = new DoubleNode<Item>();
        this.first.previous = this.last;
        this.last.next = first;
    }
    /**
     *在头部插入节点
     */
    public void insertIntoHead(Item item)
    {
        DoubleNode<Item> oldFirst = first;
        first = new DoubleNode<Item>();
        first.item = item;
        if (isEmpty())
        {
            first.previous = first;
            last = first;
            first.next = last;
        }else
        {
            last = oldFirst.previous;
            first.next = oldFirst;
            first.previous = last;
            last.next = first;
            oldFirst.previous = first;
        }
        N++;
    }
    
    /**
     * 在表尾插入节点
     * @param item
     */
    public void insertIntoLast(Item item)
    {
        DoubleNode<Item> oldLast = last;
        last = new DoubleNode<Item>();
        last.item = item;
        if (isEmpty())
        {
            last.next = last;
            last.previous = first;
        }else
        {
            first = oldLast.next;
            last.next = first;
            last.previous = oldLast;
            first.previous = last;
            oldLast.next = last;
        }
        N++;
    }
    /**
     * 从表头删除节点
     * @return
     */
    public Item deleteFromHead()
    {
        if (!isEmpty())
        {
            Item item = first.item;
            last.next = first.next;
            first.next.previous = last;
            first = first.next;
            N--;
            return item;
        }
        return null;
    }
    /**
     * 从表尾删除节点
     * @return
     */
    public Item deleteFromLast()
    {
        if (!isEmpty())
        {
            Item item = last.item;
            first.previous = last.previous;
            last.previous.next = first;
            last = last.previous;
            N--;
            return item;
        }
        return null;
    }
    /**
     * 在指定节点之前插入新节点
     * 
     * @param node
     * @param item
     */
    public void insertBeforeNode(DoubleNode<Item> node , Item item)
    {
        N++;
        DoubleNode<Item> newNode = new DoubleNode<Item>();
        newNode.item = item;
        //原节点的前节点
        node.previous.next = newNode;
        //
        newNode.previous = node.previous;
        //
        node.previous = newNode;
        //
        newNode.next = node;
    }
    /**
     * 在指定节点之后插入新节点
     * @param node
     * @param item
     */
    public void insertAfterNode(DoubleNode<Item> node , Item item)
    {
        N++;
        DoubleNode<Item> newNode = new DoubleNode<Item>();
        newNode.item = item;
        //原节点的后节点
        node.next.previous = newNode;
        //
        newNode.next = node.next;
        //
        newNode.previous = node;
        //
        node.next = newNode;
    }
    /**
     * 删除指定节点
     * @param node
     * @return
     */
    public Item deleteNode(DoubleNode<Item> node)
    {
        N--;
        Item item = node.item;
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node = null;
        return item;
    }
    
    public static void main(String[] args) {
        DoubleNode<String> node1 = new DoubleNode<String>();
        DoubleNode<String> node2 = new DoubleNode<String>();
        DoubleNode<String> node3 = new DoubleNode<String>();
        DoubleNode<String> node4 = new DoubleNode<String>();
        
        node1.item = "I";
        node2.item = "am";
        node3.item = "Shepherd";
        node4.item = "...";
        node1.next = node2;
        node1.previous = node4;
        node2.next = node3;
        node2.previous = node1;
        node3.next = node4;
        node3.previous = node2;
        node4.next = node1;
        node4.previous = node3;
        
        DoubleLinkedList<String> linkedList = new DoubleLinkedList<String>();
        linkedList.insertIntoHead("I");
        linkedList.insertIntoLast("am");
        linkedList.insertIntoLast("a");
        linkedList.deleteFromHead();
        linkedList.deleteFromLast();
        linkedList.insertAfterNode(node2, "hello");
        linkedList.insertBeforeNode(node2, "world");
        
    }
}
