package chapter1.part2.low;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import edu.princeton.cs.algs4.StdDraw;

/**
 * 1.2.1
 * @author mulw
 *
 */
public class Point2D {
    
    private double axisX;
    private double axisY;
    
    
    public double getAxisX() {
        return axisX;
    }

    public void setAxisX(double axisX) {
        this.axisX = axisX;
    }

    public double getAxisY() {
        return axisY;
    }

    public void setAxisY(double axisY) {
        this.axisY = axisY;
    }

    public Point2D(double x,double y) {
        this.axisX = x;
        this.axisY = y;
    }
    
    /**
     *画正方形，画随机点
     * @param N
     */
    public static List<Double> drowSquare(int N) {
        //画正方形
        StdDraw.square(0.5, 0.5, 0.5);
        
        Random randomX = new Random();
        Random randomY = new Random();
        Point2D[] points = new Point2D[N];
        //画随机点
        for (int i = 0; i < N; i++) {
            double x = randomX.nextDouble();
            double y = randomY.nextDouble();
            //将随机点保存起来
            points[i] = new Point2D(x, y);
            StdDraw.point(x, y);
        }
        //计算两点之间的最短距离
        double distance = getDistance(points[0], points[1]);
        //点与点之间距离的集合
        List<Double> disList = new ArrayList<Double>();
        for (int i = 0; i < points.length; i++) {
            double distanceTemp = distance;
            for (int j = i+1; j < points.length; j++) {
                if (distanceTemp > getDistance(points[i],points[j])) {
                    distanceTemp = getDistance(points[i],points[j]);
                }
                distance = distanceTemp;
                //disList.add(distance);
            }
            
        }
        disList.add(distance);
        return disList;
    }
    //返回两点之间的距离
    public static double getDistance(Point2D pointA,Point2D pointB) {
        return Math.sqrt(Math.pow((pointA.axisX-pointB.axisX), 2) + 
                Math.pow(pointA.axisY-pointB.axisY, 2));
    }
    
    public static void main(String[] args) {
        List<Double> distance = Point2D.drowSquare(4);
        for (int i = 0; i < distance.size(); i++) {
            System.out.println(distance.get(i));
        }
    }
}
