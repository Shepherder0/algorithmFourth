package chapter1.parts3.high;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 1.3.35
 * @author mulw
 *
 */
@SuppressWarnings("unchecked")
public class RandomQueue<Item> implements Iterable<Item>
{
    private int N = 0;
    private Item[] items = (Item[]) new Object[1];
    
    public RandomQueue() {}
    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    public boolean isEmpty()
    {
        return N == 0;
    }
    public int size()
    {
        return N;
    }
    public void enqueue(Item item)
    {
        if (items.length == N) resize(2*items.length);
        items[N++] = item;
    }
    public Item dequeue()
    {
        int i = (int)(Math.random()*(N-1));
        Item temp = items[i];
        items[i] = items[N-1];
        items[N-1] = temp;
        
        Item item = items[N-1];
        --N;
        items[N] = null;
        if (N > 0 && N == items.length/4) resize(items.length/2);
        return item;
    }
    public Item sample()
    {
        Random random = new Random();
        int i = random.nextInt(N);
        return items[i];
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>
    {
        private int count = N;
        public ListIterator() {
            List<Integer> numbers = RandomBag.randomNumber(N);
            //重新排列items
            Item[] temp = (Item[])new Object[items.length];
            for (int i = 0; i < N; i++) {
                temp[i] = items[numbers.get(i)];
            }
            items = temp;
        }
        @Override
        public boolean hasNext()
        {
            return count > 0;
        }
        @Override
        public Item next()
        {
            return items[--count];
        }
        //public void remove() {}
    }
    public static void main(String[] args) {
        RandomQueue<String> test = new RandomQueue<String>();
        test.enqueue("I");
        test.enqueue("am");
        test.enqueue("Shepherd");
        test.enqueue("hello");
        test.dequeue();
        while (!test.isEmpty())
        {
            System.out.print(test.dequeue() + " ");
        }
    }
    
}
