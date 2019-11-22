package chapter1.part3.linkedList;

/**
 * 1.3.19,20,21,24,25,26,27
 * 
 * @author mulw
 *
 */
public class LinkedList<Item> {
    private static class Node<Item>
    {
        Item item;
        Node<Item> next;
    }
    
    /**
     * 删除链表的最后一个节点
     * @param first
     */
    public void deleteLastNode(Node<Item> first)
    {
        Node<Item> tempNode = first;
        //只有一个元素
        if (tempNode.next == null)
        {
            first = null;
        }else
        {
            //含有两个及更多元素时
            while (!(tempNode.next.next == null))
            {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
        }
    }
    
    /**
     * 整条链表数据的遍历
     * @param first 链表的起始节点
     */
    public void showLinkedList(Node<Item> first)
    {
        Node<Item> tempNode = first;
        
        if (tempNode != null)
        {
            while (tempNode.next != null)
            {
                System.out.print(tempNode.item + " ");
                tempNode = tempNode.next;
            }
            System.out.print(tempNode.item + " ");
        }
        
    }
    
    /**
     * 删除链表中第k个节点（如果存在的话）
     * @param k
     */
    public Node<Item> delete(int k,Node<Item> first)
    {
        int count = 1;
        Node<Item> tempNode = first;
        if (k == 1 && tempNode.next != null)
        {
            tempNode = tempNode.next;
            first = null;
        }else if (tempNode != null)
        {
            //tempNode表示第k-1个节点
            //找到第k-1个节点，并判断第k个节点是否存在
            while (count < k-1 && tempNode.next!= null)
            {
                count++;
                tempNode = tempNode.next;
            }
            //若存在，就删除
            if (count == k-1)
            {
                tempNode.next = tempNode.next.next;
            }
        }
        return tempNode;
    }
    
    /**
     * 1.3.21
     * @param first
     * @param key
     * @return
     */
    public boolean find(Node<Item> first , String key)
    {
        Node<Item> current = first;
        while (current != null)
        {
            if (current.item.equals(key))
                return true;
            current = current.next;
        }
        return false;
    }
    
    /**
     * 1.3.24
     * @param reNode
     */
    public void removeAfter(Node<Item> reNode)
    {
        if (reNode != null)
            reNode.next = null;
    }
    
    /**
     * 1.3.25
     * @param first
     * @param insert
     */
    public void insertAfter(Node<Item> first , Node<Item> insert)
    {
        if (first != null && insert != null)
        {
            Node<Item> curent = first;
            insert.next = curent.next;
            first.next = insert;
            curent = null;
        }
    }
    
    /**
     * 1.3.26
     * @param first
     * @param key
     * @return
     */
    public void remove(Node<Item> first , String key)
    {
        Node<Item> newFirst = new Node<Item>();
        newFirst.next = first;
        
        Node<Item> current = newFirst;
        while (current.next != null)
        {
            //出现需要删除的节点
            if (current.next.item.equals(key))
            {
                //删除节点current.next
                current.next = current.next.next;
            }else current = current.next;
        }
    }
    
    /**
     * 1.3.27
     * @param first
     * @return
     */
    public int max(Node<Integer> first)
    {
        Node<Integer> current = first;
        int reMax = 0;
        if (current != null)
        {
            reMax = current.item;
            while (current.next != null)
            {
                if (current.item < current.next.item)
                {
                    reMax = current.next.item;
                }
                current = current.next;
            }
        }
        return reMax;
    }
    
    /**
     * 1.3.28递归实现（感觉好麻烦，应该有问题）
     * @param first
     * @return
     */
    public int maxIteration(Node<Integer> first)
    {
        Node<Integer> current = first;
        if (first == null)
            return 0;
        else
        {
            int reMax;
            if (current.next != null)
            {
                reMax = current.item > current.next.item ? current.item : current.next.item;
                //此处做递归比较
                int interaMax = current.next.next == null ? reMax : maxIteration(current.next);
                return reMax > interaMax ? reMax : interaMax;
            }else
            {
                reMax = current.item;
                return reMax;
            }
        }
    }
    public static void main(String[] args)
    {
        Node<String> first = new Node<String>();
        Node<String> secend = new Node<String>();
        Node<String> third = new Node<String>();
        
        first.item = "I";
        secend.item = "am";
        third.item = "Shepherd";
        first.next = secend;
        secend.next = third;
        third.next = null;
        
        LinkedList<String> testList = new LinkedList<String>();
        testList.showLinkedList(first);
        System.out.println();
        System.out.println("*******************");
        //1.3.19
//        testList.deleteLastNode(first);
//        testList.showLinkedList(first);
        //1.3.20
//        Node<String> testNode = testList.delete(2, first);
//        testList.showLinkedList(testNode);
        //1.3.21
//        boolean test = testList.find(first, "am");
//        System.out.print(test);
        //1.3.24
//        testList.removeAfter(third);
//        testList.showLinkedList(first);
        //1.3.25
//        Node<String> fourth = new Node<String>();
//        fourth.item = "mulw";
//        fourth.next = null;
//        testList.insertAfter(third, fourth);
//        testList.showLinkedList(first);
        //1.3.26
//        testList.remove(first, "am");
//        testList.showLinkedList(first);
        //1.3.27
        Node<Integer> number1 = new Node<Integer>();
        Node<Integer> number2 = new Node<Integer>();
        Node<Integer> number3 = new Node<Integer>();
        Node<Integer> number4 = new Node<Integer>();
        number1.item = 222;
        number2.item = 22;
        number3.item = 888;
        number4.item = 999;
        number1.next = null;
        number2.next = number3;
        number3.next = number4;
        number4.next = null;
        LinkedList<Integer> test2 = new LinkedList<Integer>();
        int i = test2.maxIteration(number1);
        System.out.println(i);
        
        
    }
}
