package chapter1.part2.low;
/**
 * 
 * @author mulw
 *
 */
public class Counter {
    private final String name;
    private int count;
    
    public Counter(String id) {
        name = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }
    
    public void increment() {
        count++;
    }

    @Override
    public String toString() {
        return "Counter [name=" + name + ", count=" + count + "]";
    }
    
    
}
