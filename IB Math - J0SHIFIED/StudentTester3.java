import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester3 extends junit.framework.TestCase
{
   public void testStudentTester()
   {
      double[][] m2 = { {2., 5.}, { -6., 3.} };
      assertEquals(2*3-5*-6, Determinants.getDeterminant(m2), 0.02);
      //assertEquals(false, Determinants.isSingular(m2));

      double[][] m3 = { {2., 5., 3.}, { -6., 3., 4.}, { -6., 3., 4.} };
      assertEquals(2*3*4. + 5*4.*-6 + 3*-6*3. - (-6*3*3. + 3*4*2. + 4*-6*5.), Determinants.getDeterminant(m3), 0.02);
      assertEquals(true, Determinants.isSingular(m3));
    }
}