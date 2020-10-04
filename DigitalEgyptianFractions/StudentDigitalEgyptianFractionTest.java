import java.util.*;

/**
 * The test class DigitalEgyptianFraction.
 *
 * @author  
 * @version 
 */
public class StudentDigitalEgyptianFractionTest extends junit.framework.TestCase
{
	public void testFractionEquals()
	{
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
		assertEquals(false, f1.equals(f2) );
		assertEquals(true, f1.equals(f1) );
	}

	public void testFractionToString()
	{
        Fraction f1 = new Fraction(1, 2);
		assertEquals("1 / 2", f1.toString() );
	}

	public void testAddFractionUsingEquals()
	{
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction ans = new Fraction(5, 6);
        f1.add(f2);
		assertEquals(true, f1.equals(ans) );
	}

	public void testSubtracFractionUsingEquals()
	{
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 5);
        Fraction ans = new Fraction(3, 10);
        f1.subtract(f2);
		assertEquals(true, f1.equals(ans) );
	}

	public void testMultiplyFractionUsingEquals()
	{
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 4);
        Fraction ans = new Fraction(1, 8);
        f1.multiply(f2);
		assertEquals(true, f1.equals(ans) );
	}

	public void testFractionCompareTo()
	{
        Fraction f1 = new Fraction(5, 6);
        Fraction f2 = new Fraction(5, 7);
		assertEquals(true, f1.compareTo(f2) > 0);
		assertEquals(false, f2.compareTo(f1) > 0);
		assertEquals(true, f2.compareTo(f2) == 0);
	}

	public void testAddAllFractionsInList()
	{
        Fraction ans = new Fraction(5, 6);
	    DigitalEgyptianFraction ef1 = new DigitalEgyptianFraction(2);
	    Fraction ef2 = new Fraction(1, 3);
		ArrayList<Fraction> ansList = new ArrayList<Fraction>();
		ansList.add(ef1);
		ansList.add(ef2);
        Fraction temp = DigitalEgyptianFraction.addAllFractionsInList(ansList);

		System.out.println(temp);
		assertEquals(ans, temp);
	}

	public void testgetListOfDigitalEgyptianFraction01()
	{
	    DigitalEgyptianFraction ef1 = new DigitalEgyptianFraction(2);
	    DigitalEgyptianFraction ef2 = new DigitalEgyptianFraction(4);
		ArrayList<DigitalEgyptianFraction> ans = new ArrayList<DigitalEgyptianFraction>();
		ans.add(ef1);
		ans.add(ef2);

		List<DigitalEgyptianFraction> eFractions = DigitalEgyptianFraction.getListOfDigitalEgyptianFractions(new Fraction(3, 4));

		assertEquals(true, eFractions.contains(ef1));
		assertEquals(true, eFractions.contains(ef2));
		assertEquals(2, eFractions.size());
	}

	public void testgetListOfDigitalEgyptianFraction02()
	{
	    DigitalEgyptianFraction ef1 = new DigitalEgyptianFraction(4);
	    DigitalEgyptianFraction ef2 = new DigitalEgyptianFraction(16);
	    DigitalEgyptianFraction ef3 = new DigitalEgyptianFraction(32);
	    DigitalEgyptianFraction ef4 = new DigitalEgyptianFraction(128);
		ArrayList<DigitalEgyptianFraction> ans = new ArrayList<DigitalEgyptianFraction>();
		ans.add(ef1);
		ans.add(ef2);
		ans.add(ef3);
		ans.add(ef4);

		List<DigitalEgyptianFraction> eFractions = DigitalEgyptianFraction.getListOfDigitalEgyptianFractions(new Fraction(45, 128));

		assertEquals(true, eFractions.contains(ef1));
		assertEquals(true, eFractions.contains(ef2));
		assertEquals(4, eFractions.size());
	}
}