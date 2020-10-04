 import java.util.*;
import java.lang.Math;
/**
 * RunRunRunAroundNumbers.
 *
 * @author  Josh Ibad
 * @version September 15, 2018
 */
public class RunRunRunAroundNumbers
{
    /*
    public static void main(String[] args)
    {
        System.out.println(isRunRoundNumber(13));
    }*/
    /*
     * Returns true if num is a RunRoundNumber
     *  false otherwise
     */
    public static boolean isRunRoundNumber(int num)
    {
        /*Puts digits in list nums*/
        List<Integer> nums = new ArrayList<Integer>();
        while(num>0)
        {
            if(nums.contains(num%10))
                return false;
            else
            {
                nums.add(0, num%10);
                num /= 10;
            }
        }
        boolean[] boos = new boolean[nums.size()];//boolean array all false for when code has went over number
        int index=0;
        for(int i=0; i<nums.size(); i++)
        {
            
            System.out.println("Run " + i + ": ");
            System.out.println("\tIndex: " + index);
            System.out.println("\tBoolean: " + boos[index]);
            if(i==1 && index==0)
                return false;
            if(boos[index])//checks if already passed number at least once save last iteration being the first
                if(index!=0 || i!= nums.size()-1)
                {
                    return false;
                }
            boos[index] = true;
            index = (index+nums.get(index))%nums.size();
        }
        System.out.println(index);
        return index==0;
    }

    public static int getNextRunAroundNumber(int seqNum)
    {
        /*boolean boo = true;
        while(boo)
        {
            if(isRunRoundNumber(seqNum))
            {
                boo = false;
                return seqNum;
            }
            else
                seqNum++;
        }
        return -1;*/
        if(isRunRoundNumber(seqNum))
        {
            return seqNum;
        }
        else
        {
            seqNum++;
            return getNextRunAroundNumber(seqNum);
        }
    }
}