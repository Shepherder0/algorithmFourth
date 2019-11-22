package chapter1.part2.low;

import java.util.List;

/**
 * 1.2.3(未完成)
 * @author mulw
 *
 */
public class Interval2D {
    private Point2D pointA;
    private Point2D pointB;
    
    public Interval2D(Point2D pointA,Point2D pointB){
        this.pointA = pointA;
        this.pointB = pointB;
        if (pointA.getAxisX() > pointB.getAxisX()) {
            
        }
    }
    
    public static void getIntersect2D(List<Interval2D> list){
        
        for (int i = 0; i < list.size(); i+=2) {
            double xLow1 = list.get(i).pointA.getAxisX();
            double ylow1 = list.get(i).pointA.getAxisY();
            double xLow2 = list.get(i).pointB.getAxisX();
            double yLow2 = list.get(i).pointB.getAxisY();
            
            double xLow3 = list.get(i+1).pointA.getAxisX();
            double ylow3 = list.get(i+1).pointA.getAxisY();
            double xLow4 = list.get(i+1).pointB.getAxisX();
            double yLow4 = list.get(i+1).pointB.getAxisY();
            
        }
    }
}
