import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
   public void testToString()
   {
      int[][] a = { {1, 2, 3}, {0, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);

      assertEquals("[[1, 2, 3], [0, 1, 1]]", f1.toString());
   }

   public void testMatrixProduct()
   {
      int[][] a = { {1, 2, 3}, {0, 1, 1} };
      int[][] b = { {0, 1}, {2, 2}, {1, 2} };
      int[][] ans = { {7, 11}, {3, 4} };

      int[][] mat = Matrix.product(a, b);

      for (int m = 0; m < ans.length; m++)
         for (int n = 0; n < ans[0].length; n++)
            assertEquals(ans[m][n], mat[m][n]);
   }

   public void testGetSize()
   {
      int[][] a = { {1, 1, 1}, {0, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(5, f1.getSize());

      int[][] b = { {0, 1}, {1, 0}, {0, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(3, f2.getSize());
   }

   public void testIsFunction()
   {
      int[][] a = { {1, 1, 1}, {0, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isFunction());

      int[][] b = { {0, 1}, {1, 0}, {0, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isFunction());
   }

   public void testIsOneToOne()
   {
      int[][] a = { {1, 1, 1}, {0, 1, 1}, {0, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isOneToOne());

      int[][] b = { {0, 1, 0}, {1, 0, 0}, {0, 0, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isOneToOne());
   }

   public void testIsOnTo()
   {
      int[][] a = { {0, 1, 0}, {1, 0, 0}, {0, 1, 0} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isOnTo());

      int[][] b = { {1, 0, 0}, {1, 0, 0}, {0, 1, 0}, {0, 0, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isOnTo());
   }

   public void testIsBijective()
   {
      int[][] a = { {0, 1, 0}, {1, 0, 0}, {0, 1, 0} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isBijective());

      int[][] b = { {1, 0, 0}, {0, 0, 1}, {0, 1, 0}};
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isBijective());
   }

   public void testGetInverse()
   {
      int[][] a = { {1, 2, 3}, {0, 1, 1}, {3, 4, 2} };
      int[][] bInverse = { {1, 0, 3}, {2, 1, 4}, {3, 1, 2}};
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);

      int[][] inv = f1.getInverse();

      for (int m = 0; m < bInverse.length; m++)
         for (int n = 0; n < bInverse[0].length; n++)
            assertEquals(bInverse[m][n], inv[m][n]);
   }

   public void testIsReflexive()
   {
      int[][] a = { {0, 1, 0}, {1, 0, 0}, {0, 1, 0} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isReflexive());

      int[][] b = { {1, 0, 0}, {0, 1, 1}, {0, 1, 1}};
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isReflexive());
   }

   public void testIsSymmetric()
   {
      int[][] a = { {0, 1, 1}, {1, 0, 0}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isSymmetric());

      int[][] b = { {1, 1, 1}, {1, 0, 1}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isSymmetric());
   }

   public void testIsAntiSymmetric()
   {
      int[][] a = { {0, 1, 1}, {1, 0, 0}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isAntiSymmetric());

      int[][] b = { {1, 0, 0}, {1, 0, 0}, {1, 1, 0} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isAntiSymmetric());
   }

   public void testIsTransitive()
   {
      int[][] a = { {0, 1, 1}, {1, 0, 0}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isTransitive());

      int[][] b = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isTransitive());
   }

   public void testIsEquivalenceRelation()
   {
      int[][] a = { {0, 1, 1}, {1, 0, 0}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isEquivalenceRelation());

      int[][] b = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isEquivalenceRelation());
   }

   public void testIsPartiallyOrder()
   {
      int[][] a = { {0, 1, 1}, {1, 0, 0}, {1, 1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);
      assertEquals(false, f1.isPartiallyOrder());

      int[][] b = { {1, 0, 0}, {0, 1, 0}, {0, 0, 1} };
      FunctionsChapter3StylePart2 f2 = new FunctionsChapter3StylePart2(b);
      assertEquals(true, f2.isReflexive());
      assertEquals(true, f2.isAntiSymmetric());
      assertEquals(true, f2.isTransitive());
      assertEquals(true, f2.isPartiallyOrder());
   }

   public void testComposition()
   {
      int[][] a = { {1, 0}, {0, 1}, {1, 1} };
      FunctionsChapter3StylePart2 f1 = new FunctionsChapter3StylePart2(a);

      int[][] b = { {1, 1, 0}, {0, 1, 1} };
      FunctionsChapter3StylePart2 f2 = f1.composition(b);

      int[][] ans = { {1, 1, 0}, {0, 1, 1}, {1, 1, 1} };
      int[][] mat = f2.getRelation();

      for (int m = 0; m < ans.length; m++)
         for (int n = 0; n < ans[0].length; n++)
            assertEquals(ans[m][n], mat[m][n]);
   }
}