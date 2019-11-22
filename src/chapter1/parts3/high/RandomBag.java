package chapter1.parts3.high;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.3.34
 * @author mulw
 *
 */
public class RandomBag<Item> implements RandomBagIble<Item> , Iterable<Item>
{
    private int N = 0;
    @SuppressWarnings("unchecked")
    private Item[] items = (Item[]) new Object[1];
    @Override
    public Iterator<Item> iterator()
    {
        return new ListIteratour();
    }
    private class ListIteratour implements Iterator<Item>
    {
        private int count = N;
        @SuppressWarnings("unchecked")
        public ListIteratour() {
            List<Integer> numbers = randomNumber(N);
            //重新排列items
            Item[] temp = (Item[])new Object[items.length];
            for (int i = 0; i < N; i++) {
                temp[i] = items[numbers.get(i)];
            }
            items = temp;
        }
        @Override
        public boolean hasNext() {
            return count > 0;
        }
        @Override
        public Item next() {
            Item item = items[count];
            count--;
            return item;
        }
        
        public void remove()
        {
            
        }
    }
    @Override
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    @Override
    public int size()
    {
        return N;
    }
    
    @SuppressWarnings("unchecked")
    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
    @Override
    public void add(Item item)
    {
        if (items.length == N) resize(items.length*2);
        items[N++] = item;
    }
    
    
    public static void main(String[] args) {
        RandomBag<String> test = new RandomBag<String>();
        test.add("I");
        test.add("am");
        test.add("a");
        test.add("people");
//        迭代有问题,count的增加有点莫名其妙
//        for (String string : test) {
//            System.out.print(string+" ");
//        }
        
    }
    
    /**
     * 产生0--(N-1) 之间N个不同的随机数
     * @param N
     * @return
     */
    public static List<Integer> randomNumber(int N)
    {
        List<Integer> numbers = new ArrayList<Integer>();
        int tempNum = (int) (Math.random()*N);
        numbers.add(tempNum);
        while(numbers.size() < N)
        {
            //返回0--(N-1)的随机数
            int tempNum2 = (int) (Math.random()*N);
            boolean symbol = true;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == tempNum2) symbol = false;
            }
            if (symbol) numbers.add(tempNum2);
        }
        return numbers;
    }
}
