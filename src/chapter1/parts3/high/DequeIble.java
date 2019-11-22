package chapter1.parts3.high;

/**
 * 1.3.33
 * @author mulw
 *
 */
public interface DequeIble<Item>
{
    public boolean isEmpty();
    public int size();
    public void pushLeft(Item item);
    public void pushRight(Item item);
    public Item popLeft();
    public Item popRight();
}
