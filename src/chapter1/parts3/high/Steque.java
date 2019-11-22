package chapter1.parts3.high;

/**
 * 1.3.32
 * @author mulw
 *
 */
public interface Steque<Item> {
    
    public void push(Item item);
    public Item pop();
    //插队到第一个位置
    public void enqueue(Item item);
    
    public boolean isEmpty();
    public int size();
}
