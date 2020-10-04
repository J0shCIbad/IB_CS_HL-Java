

/**
 * The test class TearCalculatorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WordCounterTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class TearCalculatorTest
     */
    public WordCounterTest()
    {
    }
	public void test00()
	{
		String problemMsg="Problem with: test00";
    String row1 = "HHHHHH";
    String row2 = "HAAAAH";
    String row3 = "HANNAH";
    String row4 = "HANNAH";
    String row5 = "HAAAAH";
    String row6 = "HHHHHH";
    String[] letterGrid = {row1, row2, row3, row4, row5, row6};
		WordCounter letters = new WordCounter(letterGrid);
    for(int i = 0; i < letterGrid.length; i++)
       System.out.println(letterGrid[i]);
		assertEquals(problemMsg, 4*3*17*17, letters.countEmAll("HANNAH"));
	}
}