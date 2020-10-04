
import java.lang.String;

public class StudentSample_2 extends junit.framework.TestCase
{
	public void testMystery6()
	{
		MysterySolverII obj=new MysterySolverII();
		String problemMsg="Problem with: mystery6";
		String input="1 2 3 4 5";
		assertEquals(problemMsg, "1 3 6 10 15", obj.mystery6(input));
	}

	public void testMystery7()
	{
		MysterySolverII obj=new MysterySolverII();
		String problemMsg="Problem with: mystery7";
		String input="2 5 6 8 1";
		assertEquals(problemMsg,   "2 2\n"
		                         + "7 7 7 7 7 7 7\n"
		                         + "13 13 13 13 13 13 13 13 13 13 13 13 13\n"
		                         + "21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21 21\n"
		                         + "22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22 22"
		                         , obj.mystery7(input));
	}

	public void testMystery8()
	{
		MysterySolverII obj=new MysterySolverII();
		String problemMsg="Problem with: mystery8";
		String input="1 2 3 4 5";
		assertEquals(problemMsg, "5 9 12 14 15", obj.mystery8(input));
	}

	public void testMystery9()
	{
		MysterySolverII obj=new MysterySolverII();
		String problemMsg="Problem with: mystery9";
		String input="5 4 3 2 1";
		assertEquals(problemMsg, "5 3 1 2 4", obj.mystery9(input));
	}

	public void testMysteryF()
	{
		MysterySolverII obj=new MysterySolverII();
		String problemMsg="Problem with: mysteryF";
		String input="3";
		assertEquals(problemMsg, "1 1 2", obj.mysteryF(input));
	}
}