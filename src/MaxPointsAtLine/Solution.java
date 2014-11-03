package MaxPointsAtLine;

import java.util.*;

import static java.lang.Math.abs;

/**
 * User: Jason Weng
 */


  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }


class Line{
    private final double a;
    private final double b;
    private final boolean isVertical;
    private static final double PRECISION = Double.valueOf("1.0E-10");

    Line(double a, double b, boolean isVertical) {
        this.a = a;
        this.b = b;
        this.isVertical = isVertical;
    }

    public boolean pointOnThisLine(final PointForHashMap p){
        if(isVertical) return p.x == a;
        else {
            double r = a * p.x + b  - p.y;
            return  (abs(r)  < PRECISION);
        }
    }
}

class PointForHashMap {
    final int x;
    final int y;
    PointForHashMap(int a, int b) { x = a; y = b; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointForHashMap that = (PointForHashMap) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class Solution {
    public int maxPoints(Point[] points) {
        int numberOfPoints = points.length;
        if(numberOfPoints == 0) return 0;
        if(numberOfPoints == 1) return 1;

        Map<PointForHashMap, Integer> pointMap = new HashMap<PointForHashMap, Integer>();
        for(Point p: points){
            PointForHashMap pointForHashMap = new PointForHashMap(p.x, p.y);
            if(pointMap.containsKey(pointForHashMap)){
                int count = pointMap.get(pointForHashMap) + 1;
                pointMap.put(pointForHashMap, count);
            }else{
                pointMap.put(pointForHashMap, 1);
            }
        }


        List<PointForHashMap> uniquePoints = new ArrayList(pointMap.keySet());
        int uniquePointsNumber = uniquePoints.size();
        if(uniquePointsNumber == 1) return   pointMap.get(uniquePoints.get(0));

        Map<Line, Integer> lineMap = new HashMap<Line,Integer>();
        PointForHashMap p1 =  uniquePoints.get(0);
        PointForHashMap p2 =  uniquePoints.get(1);
        Line line1 = resolveLineRepresentation(p1, p2);
        if(line1 != null) lineMap.put(line1, pointMap.get(p1)+pointMap.get(p2));



        for(int i=2; i < uniquePointsNumber ;i++){
            PointForHashMap p = uniquePoints.get(i);
            boolean pointOnExistingLine = false;
            for(Line line: lineMap.keySet()){
                if(line.pointOnThisLine(p))   {
                    int count = lineMap.get(line);
                    count += pointMap.get(p);
                    lineMap.put(line, count);
                    pointOnExistingLine = true;

                }
            }
            //if not on previous line. then each point pair should form a new line.
            if(!pointOnExistingLine){
                for(int j=0; j<i; j++){
                    PointForHashMap pToCheck = uniquePoints.get(j);
                    Line line = resolveLineRepresentation(pToCheck, p);
                    if(line != null) lineMap.put(line, pointMap.get(pToCheck)+pointMap.get(p));
                }

            }
        }


        return Collections.max(lineMap.values());
    }



    private Line resolveLineRepresentation(PointForHashMap p1, PointForHashMap p2){

        if(p1.equals(p2)) return null;

        double xDistance = p2.x - p1.x;
        double yDistance = p2.y - p1.y;
        if(xDistance == 0)   {
            return new Line(p1.x,0, true);
        }

        double a = yDistance / xDistance;
        double b = p2.y - p2.x* a;
        return new Line(a,b, false);

    }
}
