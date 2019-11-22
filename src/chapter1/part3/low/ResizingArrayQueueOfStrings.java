package chapter1.part3.low;

import java.util.Iterator;

/**
 * 1.3.14
 * @author mulw
 *
 */
public class ResizingArrayQueueOfStrings implements Iterable<String>
{
    private String[] strs = new String[1];
    private int N = 0;
    
    public boolean isEmpty()
    {
        return N==0;
    }
    public int size()
    {
        return N;
    }
    public void resize(int max)
    {
        String[] tempStrings = new String[max];
        for (int i = 0; i < N; i++) {
            tempStrings[i] = strs[i];
        }
        strs = tempStrings;
    }
    public void enQueue(String s)
    {
        if (N == strs.length) resize(strs.length*2);
        strs[N] = s;
        N++;
    }
    public String deQueue()
    {
        String string = strs[0];
        strs[0] = null;//避免对象游离
        //进行移位操作
        String[] newStrs = new String[strs.length];
        for (int i = 1; i < strs.length; i++) {
            newStrs[i-1] = strs[i];
        }
        strs = newStrs;
        N--;
        if (N > 0 && N == strs.length/4) resize(strs.length/2);
        return string;
    }
    
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings resizing = new ResizingArrayQueueOfStrings();
        resizing.enQueue("hello");
        resizing.enQueue("world");
        resizing.enQueue("I");
        resizing.enQueue("am");
        resizing.enQueue("shepherd");
        for (String string : resizing) {
            System.out.print(string+",");
        }
    }
    @Override
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<String>
    {
        private int count = N;
        @Override
        public boolean hasNext() {
            return count > 0;
        }
        @Override
        public String next() {
            return strs[--count];
        }
        
        public void remove()
        {
            
        }
    }
    
}
