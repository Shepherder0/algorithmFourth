package chapter1.part3.low;

/**
 * 1.3.1
 * @author mulw
 *
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;
    
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }
    
    public boolean isEmpty() {
        return N==0;
    }
    
    public int size() {
        return N;
    }
    
    public void push(String item) {
        a[N++] = item;
    }
    
    public String pop() {
        return a[--N];
    }
    
    //添加的isFull方法，用于判断数组是否已满
    public boolean isFull() {
        return N==a.length;
    }
    
    public static void main(String[] args) {
        FixedCapacityStackOfStrings testStackOfStrings = new FixedCapacityStackOfStrings(10);
        testStackOfStrings.push("world");
        testStackOfStrings.push("hello");
        
        System.out.println(testStackOfStrings.pop());
        System.out.println(testStackOfStrings.pop());
    }
}
