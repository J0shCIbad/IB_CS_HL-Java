import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
   public void testSSA00()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setSSA(20., 16., Math.PI/6.));
      assertEquals(1, t.getNumTriangles());
      assertEquals(Math.PI-0.4115168-Math.PI/6., t.getAngleC(), 0.002);
      assertEquals(0.4115168, t.getAngleB(), 0.002);
      assertEquals(32.18670924, t.getSideC(), 0.002);
   }

   public void testSSS00()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setSSS(3., 4., 5.));
      assertEquals(1, t.getNumTriangles());
      //assertEquals(Math.asin(0.6), t.getAngleA(), 0.002);
      assertEquals(Math.asin(0.8), t.getAngleB(), 0.002);
      assertEquals(Math.PI/2, t.getAngleC(), 0.002);
   }

   public void testSAS00()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setSAS(11.5, Math.PI/14., 15.));
      assertEquals(1, t.getNumTriangles());
      assertEquals(4.5716, t.getSideC(), 0.02);
      assertEquals(0.594088, t.getAngleA(), 0.02);
      assertEquals(Math.PI - t.getAngleC() - t.getAngleA(), t.getAngleB(), 0.002);
   }

   public void testASA00()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setASA(Math.PI/3.7, 21.5, Math.PI/11.4));
      assertEquals(1, t.getNumTriangles());
      assertEquals(Math.PI - t.getAngleA() - t.getAngleB(), t.getAngleC(), 0.002);
      assertEquals(17.890588, t.getSideA(), 0.02);
      assertEquals(6.484975, t.getSideB(), 0.02);
   }

   public void testAAS00()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setAAS(Math.PI/7.7, Math.PI/9.8, 33.1));
      assertEquals(1, t.getNumTriangles());
      assertEquals(Math.PI - t.getAngleA() - t.getAngleB(), t.getAngleC(), 0.002);
      assertEquals(55.54324815, t.getSideC(), 0.02);
      assertEquals(26.2872502, t.getSideB(), 0.02);
   }

   public void testSSS_getPerimeter()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setSSS(27.7, 19.8, 33.1));
      assertEquals(27.7+19.8+33.1, t.getPerimeter(), 0.002);
   }

   public void testSSS_getArea()
   {
      Triangle t = new Triangle();
      
      assertEquals(true, t.setSSS(48., 55., 73.));
      assertEquals(0.5*48.*55., t.getArea(), 0.002);
   }
}