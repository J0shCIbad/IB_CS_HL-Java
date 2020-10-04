import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
   public void testMiscMathTopics00()
   {
      MiscMathTopics t = new MiscMathTopics();
      assertEquals(530.45, t.calculateAnnualCompoundInterest(500., 2, 0.03), 0.0005);
      assertEquals(121.5506, t.calculateCompoundInterest(100., 2, 2, 0.10), 0.0005);
      assertEquals(86.4385, t.calculateHalfLifeTime(20., 600., 30.), 0.0005);
      assertEquals(518.73582, t.calculateHalfLifeAmount(8., 1600., 13.), 0.0005);
      assertEquals(3136.6243, t.calculateContinuousCompounding(2000., 6, 0.075), 0.0005);
      assertEquals(9.627044174, t.calculateContinuousCompounding(0.072), 0.0005);
   }

   public void testComplexNumbers00()
   {
      ComplexNumber s1 = new ComplexNumber(2, -2);
      ComplexNumber s2 = new ComplexNumber(2, -2);
      assertEquals(true, s1.equals(s2));

      double d[] = { 1, Math.PI/6 };
      ComplexNumber z = new ComplexNumber(d);
      assertEquals(Math.sqrt(3)/2., z.getRealPart(), 0.0002);
      assertEquals(1./2., z.getImaginaryPart(), 0.0002);

      ComplexNumber t = new ComplexNumber(3, 4);
      double[] x = t.convertToTrigForm();
      assertEquals(5., x[0], 0.0002);
      assertEquals(Math.atan(4./3), x[1], 0.002);

      double[] y = t.pow(3);
      assertEquals(5*5*5., y[0], 0.0002);
      assertEquals(3*Math.atan(4./3)%(2*Math.PI), y[1], 0.002);

      t = new ComplexNumber(-2, 2);
      ArrayList<ComplexNumber> nRoots = t.nthRoot(3);
      ArrayList<ComplexNumber> ans = new ArrayList<ComplexNumber>();
      ans.add(new ComplexNumber(1, 1));
      ans.add(new ComplexNumber(Math.sqrt(2) * Math.cos(165*Math.PI/180), Math.sqrt(2) * Math.sin(165*Math.PI/180)));
      ans.add(new ComplexNumber(Math.sqrt(2) * Math.cos(285*Math.PI/180), Math.sqrt(2) * Math.sin(285*Math.PI/180)));
      assertEquals(ans.size(), nRoots.size());
      for (int j = 0; j < nRoots.size(); j++)
         assertEquals(true, ans.contains(nRoots.get(j)));
   }
}