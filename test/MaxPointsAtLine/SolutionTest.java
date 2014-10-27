package MaxPointsAtLine;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
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


    //[(0,9),(138,429),(115,359),(115,359),
    // (-30,-102),(230,709),(-150,-686),(-135,-613)
    // (-60,-248),(-161,-481),(207,639),
    // (23,79),(-230,-691),(-115,-341),(92,289),
    // (60,336),(-105,-467),(135,701),
    // (-90,-394),(-184,-551),(150,774)]
    @Test
    public void test4(){

        String s = new StringBuilder().append("0,9),(138,429),(115,359),(115,359),")
                .append("(-30,-102),(230,709),(-150,-686),(-135,-613),")
                .append("(-60,-248),(-161,-481),(207,639),")
                .append("(23,79),(-230,-691),(-115,-341),(92,289),")
                .append("(60,336),(-105,-467),(135,701),")
                .append("(-90,-394),(-184,-551),(150,774")
                .toString();

        List<Point> points = parsePoints(s);
        Point[]  pointsArray = new Point[4];

        Solution solution = new Solution();
        int ans = solution.maxPoints(points.toArray(pointsArray));
        Assert.assertEquals(12, ans);
    }


    @Test
    public void test5(){

        String s = "-54,-297),(-36,-222),(3,-2),(30,53),(-5,1),(-36,-222),(0,2),(1,3),(6,-47),(0,4),(2,3),(5,0),(48,128),(24,28),(0,-5),(48,128),(-12,-122),(-54,-297),(-42,-247),(-5,0),(2,4),(0,0),(54,153),(-30,-197),(4,5),(4,3),(-42,-247),(6,-47),(-60,-322),(-4,-2),(-18,-147),(6,-47),(60,178),(30,53),(-5,3),(-42,-247),(2,-2),(12,-22),(24,28),(0,-72),(3,-4),(-60,-322),(48,128),(0,-72),(-5,3),(5,5),(-24,-172),(-48,-272),(36,78),(-3,3";

        List<Point> points = parsePoints(s);
        Point[]  pointsArray = new Point[4];

        Solution solution = new Solution();
        int ans = solution.maxPoints(points.toArray(pointsArray));
        Assert.assertEquals(30, ans);
    }

    public List<Point> parsePoints(String str){
       List<Point> points = Lists.newArrayList();
       for(String s: Splitter.on("),(").split(str)){
             String[] numbers = s.split(",");
             int x = Integer.valueOf(numbers[0]);
             int y = Integer.valueOf(numbers[1]);
             points.add(new Point(x, y));
       }
        return points;
    }
}
