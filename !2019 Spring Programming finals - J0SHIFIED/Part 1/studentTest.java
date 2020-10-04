import java.util.*;

/**
 * The test class studentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class studentTest extends junit.framework.TestCase
{
   public void testCircle01()
   {
      Point a = new Point(2, 4);
      Point b = new Point(6, 8);
      Point c = new Point(12, 4);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(7., 3.);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(cc.getY() - ans.getCenter().getY()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(26.) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.PI * Math.sqrt(26.) * Math.sqrt(26.) - ans.getCircleArea()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(2 * Math.PI * Math.sqrt(26.) - ans.getCirclePerimeter()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(32.) + Math.sqrt(36+16.) + Math.sqrt(100) - ans.getTrianglePerimeter()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(0.5* 10 * 4. - ans.getTriangleArea()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(26) - ans.getPolarEquation().getA()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(49+9) - ans.getPolarEquation().getRo()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(0.4048917 - ans.getPolarEquation().getPhi()) < 0.0002;
      assertEquals(true, flag);
   }

   public void testCircle02()
   {
      Point a = new Point(2, 3);
      Point b = new Point(2, 9);
      Point c = new Point(14, 15);
      
      Circle ans = new Circle(a, b, c);
      Point cc = new Point(11., 6.);

      boolean flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(cc.getY() - ans.getCenter().getY()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(90.) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);


      flag = Math.abs(Math.PI * Math.sqrt(90.) * Math.sqrt(90) - ans.getCircleArea()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(2 * Math.PI * Math.sqrt(90.) - ans.getCirclePerimeter()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(36.) + Math.sqrt(144+36.) + Math.sqrt(288) - ans.getTrianglePerimeter()) < 0.0002;
      assertEquals(true, flag);

//      System.out.println(ans.getTriangleArea());
      flag = Math.abs(0.5 * 6 * 12. - ans.getTriangleArea()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(90) - ans.getPolarEquation().getA()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(Math.sqrt(121+36) - ans.getPolarEquation().getRo()) < 0.0002;
      assertEquals(true, flag);

      flag = Math.abs(0.4993467 - ans.getPolarEquation().getPhi()) < 0.0002;
      assertEquals(true, flag);
      a = new Point(3, 7);
      b = new Point(13, 21);
      c = new Point(13, -3);
      
      ans = new Circle(a, b, c);
      cc = new Point(15., 9.);

      flag = Math.abs(cc.getX() - ans.getCenter().getX()) < 0.0002;
      assertEquals(true, flag);
      assertEquals(cc.getY(), ans.getCenter().getY(), 0.002);
      flag = Math.abs( Math.sqrt(148.) - ans.getRadius()) < 0.0002;
      assertEquals(true, flag);
    }
}