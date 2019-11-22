package chapter1.parts3.high;

import java.util.Iterator;

/**
 * 1.3.33
 * @author mulw
 *
 */
public class ResizingArrayDeque<Item> implements DequeIble<Item>,Iterable<Item> {
    
    @SuppressWarnings("unchecked")
    private Item[] items = (Item[]) new Object[1];
    private int N = 0;
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>
    {
        private int count;
        public ListIterator() {
            count = 0;
        }
        @Override
        public boolean hasNext() {
            return next() != null;
        }
        @Override
        public Item next() {
            Item item = items[count++];
            return item;
        }
        
    }
    
    private void resize(int max)
    {
        @SuppressWarnings("unchecked")
        Item[] tempItems = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tempItems[i] = items[i];
        }
        items = tempItems;
    }
    @Override
    public boolean isEmpty() {
        return N == 0;
    }
    @Override
    public int size() {
        return N;
    }
    @SuppressWarnings("unchecked")
    @Override
    public void pushLeft(Item item) {
        if (items.length == N) resize(N*2);
        //数据全部左移一位
        Item[] temp = (Item[])new Object[items.length];
        for (int i = 1; i < items.length; i++) {
            temp[i] = items[i-1];
        }
        temp[0] = item;
        N++;
        items = temp;
    }
    @Override
    public void pushRight(Item item) {
        if (items.length == N) resize(N*2);
        items[N++] = item;
    }
    @SuppressWarnings("unchecked")
    @Override
    public Item popLeft() {
        Item item = items[0];
        N--;
        if (N > 0 && items.length == N/4) resize(N/2);
        Item[] temp = (Item[])new Object[items.length];
        for (int i = 1; i < items.length; i++) {
            temp[i-1] = items[i];
        }
        items = temp;
        return item;
    }
    @Override
    public Item popRight() {
        Item item = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length/4) resize(N/2);
        return item;
    }
    
    public static void main(String[] args) {
        ResizingArrayDeque<String> test = new ResizingArrayDeque<String>();
        test.pushLeft("I");
        test.pushRight("am");
        test.pushLeft("hello");
        test.pushRight("Shepherd");
        test.popLeft();
        test.popRight();
    }
}
