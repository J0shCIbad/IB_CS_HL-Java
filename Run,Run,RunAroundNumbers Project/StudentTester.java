import java.util.*;

/**
 * The  StudentTester class
 *
 * @author  2009 Dave Wittyr Memorial Programming Contest
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{

// ****************  RunRunRunAroundNumbers
   public void testRunRunRunAroundNumbers01()
   {
      RunRunRunAroundNumbers rrr = new RunRunRunAroundNumbers();

      assertEquals(true, rrr.isRunRoundNumber(13));
      assertEquals(true, rrr.isRunRoundNumber(81362));
      assertEquals(true, rrr.isRunRoundNumber(913425));
      assertEquals(false, rrr.isRunRoundNumber(123));
      assertEquals(false, rrr.isRunRoundNumber(81111));
      assertEquals(false, rrr.isRunRoundNumber(83333));

      //assertEquals(81362, rrr.getNextRunAroundNumber(81362));
      assertEquals(147, rrr.getNextRunAroundNumber(123));
      assertEquals(81236, rrr.getNextRunAroundNumber(81111));
      assertEquals(83491, rrr.getNextRunAroundNumber(83333));
   }

}