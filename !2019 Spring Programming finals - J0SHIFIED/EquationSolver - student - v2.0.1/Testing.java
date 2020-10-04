import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Write a description of class Testing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Testing
{
    public static void main(){
        for(int i=0; i<10; i++)
        {
            AOptimizationRateSimulation();
        }
    }
    
    public static void switchCaseSuperTester(){for(int i=0; i<3; i++)switchCaseTest(i);}
    public static void switchCaseTest(int i)
    {
        String str = "";
        switch(i){
            default:
                str+="fill in";
                break;
            case 1:
                str+="optimize";
            case 0:
                str+="normal algorithm";
                break;
        }
        System.out.println(str);
    }
    public static void AOptimizationRateSimulation()
    {
        double x = 0;
        int min = 100;
        int max = 0;
        for(int i=0; i<100000; i++)
        {
            int temp = (int)testDataCollection();
            x += temp;
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        x/=100000;
        //System.out.println(qw);
        System.out.println("Average A optimization rate: " + x);
        System.out.println("Lowest A optimization rate: " + min);
        System.out.println("Greatest A optimization rate:" + max);
        System.out.println("-");
    }
    public static void ActualSimulation()
    {
        double x = 0;
        double min = 100;
        double max = 0;
        for(int i=0; i<100000; i++)
        {
            double temp = testDataCollection();
            x += temp;
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        x/=100000;
        //System.out.println(qw);
        System.out.println("Optimization rate: " + x);
        System.out.println("Lowest Optimization rate: " + min);
        System.out.println("Greatest Optimization rate:" + max);
        System.out.println("-");
    }
    
    public static double testDataCollection()
    {
        boolean RESULTS = false;
        boolean ARATE = false;
        
        int freq = 0;
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
            //es.THRESHOLD = qw;
            String aDummy = "";
            String bDummy = "";
            String cDummy = "";
            String aNum = "   ";
            String bNum = "   ";
            String cNum = "     ";
            String temp = aNum;
            int nextInt;
            int zeroCount=0;

            
            int optiA = es.optiA;
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
                if(RESULTS)System.out.println(temp + "->" + aNum);

            }
            if(ARATE)System.out.println(aNum + " v.s. " + aDummy);
                if(Math.abs(optiA-Integer.parseInt(aNum)) < Math.abs(optiA-Integer.parseInt(aDummy)))
                    freq++;
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
                if(RESULTS)System.out.println(temp + "->" + bNum);
                
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
                if(RESULTS)System.out.println(temp + "->" + cNum);
            }
            //if(RESULTS){
                int dummyTarget = Integer.parseInt(aDummy) * Integer.parseInt(bDummy) + Integer.parseInt(cDummy);
                int dummyInt = Math.abs(dummyTarget - t);
                int stuTarget = Integer.parseInt(aNum) * Integer.parseInt(bNum) + Integer.parseInt(cNum);
                int stuAnswer = Math.abs(stuTarget - t);
                sum += stuAnswer;
                if (stuAnswer < dummyInt) wins++;
    
                if (stuAnswer < min) min = stuAnswer;
           //}
        }
        double ave = sum / 100.0;
        String message = "wins = " + wins + "%    min delta = " + min + "   ave delta = " + ave;
        
        if(ARATE){System.out.println(freq);
        return freq;}
        return wins;
    }

    public static void testing3()
    {
        for(int i=0; i<=10; i++)
        {
            testing1(i);
        }
    }
    
    public static void testing2()
    {
        char c = '1';
        char d = (char)((int)c - 1);
        System.out.println("'" + c + "'" + " - 1 = " + "'" + d + "'");
        System.out.println((int)c + "");
    }
    
    /**
     * An example of a method - replace this comment with your own
     */
    public static void testing1(int q)
    {
        double grandTotal = 0;
        int grandMin = 1000000;
        int grandMax = 0;
        
        int min = 1000000;
        int max = 0;
        for(int m = q*100; m<=q*100+99; m++){
            //
        Random rnd = new Random(20*m + m);
        int t = rnd.nextInt(1000000);
        double total = 0;
        int next = 0;
        //int min = 1000000;
        //int max = 0;
        for(int i=0; i<1000; i++)
        {
            int t1 = 0;
            for(int j=0; j<1000; j++)
            {
                next = rnd.nextInt(1000000);
                t1 += next;
                min = Math.min(min, next);
                max = Math.max(max, next);
            }
            double t2 = t1/1000.0;
            //System.out.println(t2);
            total += t2;
        }
        total/=1000.0;
        //System.out.println("Million Sample Average: " + total);
            //
            
        grandTotal += total;
        }
        grandTotal/=100.0;
        System.out.println("Ten Million Sample Average with multiple seeds: " + grandTotal);
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }
}
