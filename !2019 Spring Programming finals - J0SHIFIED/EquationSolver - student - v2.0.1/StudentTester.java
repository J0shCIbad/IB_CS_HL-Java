import java.util.*;

/**
 * The test class StudentTester.
 *
 * @author  Mr. Allen
 * @version (a version number or a date)
 */
public class StudentTester extends junit.framework.TestCase
{
    public void testDataCollection()
    {
        Random rnd;
        int wins = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int m = 0; m < 100; m++)
        {
            rnd = new Random(20*m + m);
            int ta = rnd.nextInt(100);
            int tb = rnd.nextInt(1000);
            int tc = rnd.nextInt(100000);
            int t = rnd.nextInt(1000000);
            EquationSolver es = new EquationSolver(t);
            String aDummy = "";
            String bDummy = "";
            String cDummy = "";
            String aNum = "   ";
            String bNum = "   ";
            String cNum = "     ";
            String temp = aNum;
            int nextInt;
            int zeroCount=0;

            for (int k = 0; k < 3; k++)
            {
                nextInt = rnd.nextInt(10);
                if (nextInt != 0) zeroCount++;

                while (k == 2 && zeroCount == 0)
                {
                    nextInt = rnd.nextInt(10);
                    if (nextInt != 0) zeroCount++;
                }
                if (k == 0)
                {
                    aDummy += nextInt;
                }
                else
                {
                    if (Math.random() > 0.5)
                        aDummy += nextInt;
                    else
                        aDummy = nextInt + aDummy;
                }
                temp = aNum;
                aNum = es.build_a(aNum, nextInt );
                
                assertEquals(true, checkSamePlace(aNum, temp, ""+nextInt));
            }

            bDummy = "";
            bNum = "   ";
            temp = bNum;
            zeroCount = 0;
            for (int k = 0; k < 3; k++)
            {
                nextInt = rnd.nextInt(10);
                if (nextInt != 0) zeroCount++;

                while (k == 2 && zeroCount == 0)
                {
                    nextInt = rnd.nextInt(10);
                    if (nextInt != 0) zeroCount++;
                }
                if (k == 0)
                {
                    bDummy += nextInt;
                }
                else
                {
                    if (Math.random() > 0.5)
                        bDummy += nextInt;
                    else
                        bDummy = nextInt + bDummy;
                }
                temp = bNum;
                bNum = es.build_b(bNum, nextInt );
                
                assertEquals(true, checkSamePlace(bNum, temp, ""+nextInt));
            }

            cDummy = "";
            cNum = "     ";
            temp = cNum;
            zeroCount = 0;
            for (int k = 0; k < 5; k++)
            {
                nextInt = rnd.nextInt(10);
                if (nextInt != 0) zeroCount++;

                while (k == 4 && zeroCount == 0)
                {
                    nextInt = rnd.nextInt(10);
                    if (nextInt != 0) zeroCount++;
                }
                if (k == 0)
                {
                    cDummy += nextInt;
                }
                else
                {
                    if (Math.random() > 0.5)
                        cDummy += nextInt;
                    else
                        cDummy = nextInt + cDummy;
                }
                temp = cNum;
                cNum = es.build_c(cNum, nextInt );
                
                assertEquals(true, checkSamePlace(cNum, temp, "" + nextInt));
            }
            int dummyTarget = Integer.parseInt(aDummy) * Integer.parseInt(bDummy) + Integer.parseInt(cDummy);
            int dummyInt = Math.abs(dummyTarget - t);
            int stuTarget = Integer.parseInt(aNum) * Integer.parseInt(bNum) + Integer.parseInt(cNum);
            int stuAnswer = Math.abs(stuTarget - t);
            sum += stuAnswer;
            if (stuAnswer < dummyInt) wins++;

            if (stuAnswer < min) min = stuAnswer;
        }
        double ave = sum / 100.0;
        String message = "wins = " + wins + "%    min delta = " + min + "   ave delta = " + ave;
        assertEquals(true, message);
    }

    public void testEquationSolver01()
    {
        Random rnd = new Random(17);
        int ta = rnd.nextInt(100);
        int tb = rnd.nextInt(1000);
        int tc = rnd.nextInt(100000);
        int t = rnd.nextInt(1000000);
        EquationSolver es = new EquationSolver(t);
        String aDummy = "";
        String bDummy = "";
        String cDummy = "";
        String aNum = "   ";
        String bNum = "   ";
        String cNum = "     ";
        String temp = aNum;
        int nextInt;

        for (int k = 0; k < 3; k++)
        {
            nextInt = rnd.nextInt(10);
            if (k == 0)
            {
                aDummy += nextInt;
            }
            else
            {
                if (Math.random() > 0.5)
                    aDummy += nextInt;
                else
                    aDummy = nextInt + aDummy;
            }
            temp = aNum;
            aNum = es.build_a(aNum, nextInt );
            assertEquals(true, checkSamePlace(aNum, temp, ""+nextInt));
        }

        bDummy = "";
        bNum = "   ";
        temp = bNum;
        for (int k = 0; k < 3; k++)
        {
            nextInt = rnd.nextInt(10);
            if (k == 0)
            {
                bDummy += nextInt;
            }
            else
            {
                if (Math.random() > 0.5)
                    bDummy += nextInt;
                else
                    bDummy = nextInt + bDummy;
            }
            temp = bNum;
            bNum = es.build_b(bNum, nextInt );
            assertEquals(true, checkSamePlace(bNum, temp, ""+nextInt));
        }

        cDummy = "";
        cNum = "     ";
        temp = cNum;
        for (int k = 0; k < 5; k++)
        {
            nextInt = rnd.nextInt(10);
            if (k == 0)
            {
                cDummy += nextInt;
            }
            else
            {
                if (Math.random() > 0.5)
                    cDummy += nextInt;
                else
                    cDummy = nextInt + cDummy;
            }
            temp = cNum;
            cNum = es.build_c(cNum, nextInt );
            assertEquals(true, checkSamePlace(cNum, temp, ""+nextInt));
        }
        int dummyInt = Integer.parseInt(aDummy) * Integer.parseInt(bDummy) + Integer.parseInt(cDummy);
        dummyInt = Math.abs(dummyInt - t);
        int stuAnswer = Integer.parseInt(aNum) * Integer.parseInt(bNum) + Integer.parseInt(cNum);
        stuAnswer = Math.abs(stuAnswer - t);
        assertEquals(true, stuAnswer < dummyInt);
    }

    private boolean checkSamePlace(String str, String prev, String n)
    {
        for (int i = 0; i < prev.length(); i++)
        {
            if (prev.substring(i, i+1).equals(" ") && !str.substring(i, i +1).equals(" ") && !str.substring(i, i +1).equals(n))
                return false;
            if ( !prev.substring(i, i+1).equals(" ") && !prev.substring(i, i+1).equals(str.substring(i, i+1)) )
                return false;
        }
        return true;
    }
}