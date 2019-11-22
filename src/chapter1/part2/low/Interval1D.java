package chapter1.part2.low;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * 1.2.2
 * @author mulw
 *
 */
public class Interval1D {
    private double low;
    private double high;
    
    /**
     * 保证low<=high
     * @param low
     * @param high
     */
    public Interval1D(double low,double high) {
        if (low <= high) {
            this.low = low;
            this.high = high;
        }else {
            this.low = high;
            this.high = low;
        }
    }
    
    /**
     * 抽取出list中相交的间隔
     * @param list
     * @return
     */
    public static List<Interval1D> getIntersect(List<Interval1D> list) {
        List<Interval1D> reList = new ArrayList<Interval1D>();
        for (int i = 0; i < list.size()-1; i++) {
            
            double low1 = list.get(i).low;
            double high1 = list.get(i).high;
            
            double low2 = list.get(i+1).low;
            double high2 = list.get(i+1).high;
            //判断相交
            if (low1 <= high2 && high1 >= low2) {
                Interval1D interval1d1 = new Interval1D(low1, high1);
                Interval1D interval1d2 = new Interval1D(low2, high2);
                //后面读取时两个一起算一组间隔对
                reList.add(interval1d1);
                reList.add(interval1d2);
            }
        }
        return reList;
    }
    
    public static void main(String[] args) {
        System.out.println("请输入间隔的数量");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        input.close();
        //随机生成N个间隔
        List<Interval1D> list = new ArrayList<Interval1D>();
        for (int i = 0; i < N; i++) {
            Random random = new Random();
            double low = random.nextDouble();
            double high = random.nextDouble();
            Interval1D interval1d = new Interval1D(low, high);
            list.add(interval1d);
        }
        List<Interval1D> list2 = getIntersect(list);
        //两个算一对
        for (int i = 0; i < list2.size(); i += 2) {
            System.out.print("("+list2.get(i).low+","+list2.get(i).high+"),");
            System.out.print("("+list2.get(i+1).low+","+list2.get(i+1).high+")");
            System.out.println();
        }
    }
}
