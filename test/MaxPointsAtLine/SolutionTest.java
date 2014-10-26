package MaxPointsAtLine;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jason Weng
 */
public class SolutionTest {

    @Test
    public void test(){
         //[(0,0),(1,1),(0,0)]
        List<Point> points = new ArrayList<Point>();
        Point[]  pointsArray = new Point[3];
        points.add(new Point(0,0));
        points.add(new Point(1,1));
        points.add(new Point(0, 0));

        Solution solution = new Solution();
        int ans = solution.maxPoints(points.toArray(pointsArray));
        Assert.assertEquals(3, ans);
    }

    //(3,1),(12,3),(3,1),(-6,-1)]

    @Test
    public void test2(){

        List<Point> points = new ArrayList<Point>();
        Point[]  pointsArray = new Point[4];
        points.add(new Point(3,1));
        points.add(new Point(12,3));
        points.add(new Point(3, 1));
        points.add(new Point(-6, -1));


        Solution solution = new Solution();
        int ans = solution.maxPoints(points.toArray(pointsArray));
        Assert.assertEquals(4, ans);
    }

    //(-4,1),(-7,7),(-1,5),(9,-25)
    @Test
    public void test3(){

        List<Point> points = new ArrayList<Point>();
        Point[]  pointsArray = new Point[4];
        points.add(new Point(-4,1));
        points.add(new Point(-7,7));
        points.add(new Point(-1, 5));
        points.add(new Point(9, -25));


        Solution solution = new Solution();
        int ans = solution.maxPoints(points.toArray(pointsArray));
        Assert.assertEquals(3, ans);
    }

}
