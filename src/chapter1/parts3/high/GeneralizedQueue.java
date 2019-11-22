package chapter1.parts3.high;

/**
 * 1.3.38
 * @author mulw
 *
 */
@SuppressWarnings("unchecked")
public class GeneralizedQueue<Item>
{
    private int N = 0;
    private Item[] items = (Item[]) new Object[1];
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    
    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    
    public void insert(Item item)
    {
        if (items.length == N) resize(2*items.length);
        items[N++] = item;
    }
    
    public Item delete(int k)
    {
        Item item = items[k];
        items[k] = null;
        Item[] temp = (Item[]) new Object[N];
        for (int i = 0; i < items.length; i++) {
            if (i < k && items[i] != null) temp[i] = items[i];
            if (i > k && items[i] != null) temp[i-1] = items[i];
        }
        items = temp;
        N--;
        return item;
    }
    
    public static void main(String[] args) {
        GeneralizedQueue<String> test = new GeneralizedQueue<String>();
        test.insert("I");
        test.insert("am");
        test.insert("Shepherd");
        test.delete(1);
    }
}
