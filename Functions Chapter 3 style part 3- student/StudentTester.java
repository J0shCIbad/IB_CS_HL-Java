import java.util.*;

/**
 * The  StudentTester class
 *
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
    public void testMatrixHaveSameZeros()
    {
        int[][] a = { {1, 1, 3}, {0, 1, 1}, {5, -2, 1} };
        int[][] b = { {1, 2, 4}, {0, 1, 1}, {5, -2, 1}  };
        int[][] c = { {1, 2, 3}, {0, 1, 1}, {5, -2, -1}  };

        assertEquals(true, MatrixPart2.haveSameNonZeros(a, b));
    }

    public void testStudent()
    {
        int[][] r = { {1, 1, 0}, {0, 0, 1}, {0, 1, 0} };
        int[][] s = { {0, 1, 1, 0}, {1, 1, 0, 1}, {1, 0, 0, 1}, {1, 0, 1, 0} };
        int[][] t = { {0, 1, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 1} };

        int[][] rAns = { {1, 1, 0}, {0, 1, 1}, {0, 1, 1} };
        int[][] sAns = { {0, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 0} };
        int[][] tAns = { {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 0, 1} };

        r=FunctionsChapter3StylePart3.makeReflexive(r);
        assertEquals(true, MatrixPart2.haveSameNonZeros(r, rAns));

        s=FunctionsChapter3StylePart3.makeSymmetric(s);
        assertEquals(true, MatrixPart2.haveSameNonZeros(s, sAns));

        t=FunctionsChapter3StylePart3.makeTransitive(t);
        assertEquals(true, MatrixPart2.haveSameNonZeros(t, tAns));
    }

    public static void printMatrix(int[][] x){
        
    }
}