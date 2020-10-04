
import java.lang.String;

public class StudentSample_1 extends junit.framework.TestCase
{
	public void testMystery1()
	{
		MysterySolverI obj=new MysterySolverI();
		String problemMsg="Problem with: mystery1";
		String input="1 2 3 4 5";
		assertEquals(problemMsg, "5 4 3 2 1", obj.mystery1(input));
	}

	public void testMystery2()
	{
		MysterySolverI obj = new MysterySolverI();
		String problemMsg="Problem with: mystery2";
		String input="1 2 3 4 5";
		assertEquals(problemMsg, "5 3 1 2 4", obj.mystery2(input));
	}

	public void testMystery3()
	{
		MysterySolverI obj=new MysterySolverI();
		String problemMsg="Problem with: mystery3";
		String input="1 2 3 4 5";
		assertEquals(problemMsg, "25 16 9 4 1", obj.mystery3(input));
	}

	public void testMystery4()
	{
		MysterySolverI obj=new MysterySolverI();
		String problemMsg="Problem with: mystery4";
		String input="1 2 3 4 5";
		assertEquals(problemMsg, "120 24 6 2 1", obj.mystery4(input));
	}

	public void testMystery5()
	{
		MysterySolverI obj=new MysterySolverI();
		String problemMsg="Problem with: mystery5";
		String input="1 2 3                      4 5";
		assertEquals(problemMsg, "1 2 6 24 120", obj.mystery5(input));
	}
}