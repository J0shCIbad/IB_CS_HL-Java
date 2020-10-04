import java.util.*;
/**
 * Write a description of class GorgoneaQuarta here.
 * 
 * @author Josh Ibad 
 * @version 09/10/18
 */
public class GQ_Decimal_Converter
{
    public static void main(String[] args)
    {
        System.out.println(GQ_Decimal_Converter.toGQ(0));
    }
    public static int toDecimal(String str)
    {
        int ans = 0;
        for(int i=0; i<str.length(); i++)
        {
            switch(str.charAt(i))
            {
                case '1':
                ans += Math.pow(3,str.length()-i-1);
                break;
                case '-':
                ans -= Math.pow(3,str.length()-i-1);
                break;
            }
        }
        return ans;
    }

    public static String toGQ(int num)
    {
        if(num == 0)
            return "0";
        List<String> base3 = new ArrayList<String>();
        boolean isNeg = false;
        if(num<0)
        {
            isNeg = true;
            num = Math.abs(num);
        }
        while(num>0)
        {
            Integer in = new Integer(num%3);
            base3.add(in.toString());
            num /= 3;
        }
        
        for(int i=0; i<base3.size(); i++)
        {
            if(base3.get(i).equals("2"))
            {
                base3.set(i, "-");
                if(i==base3.size()-1)
                    base3.add("1");
                else
                {
                    Integer in = new Integer(Integer.parseInt(base3.get(i+1))+1);
                    base3.set(i+1, (in.toString()));
                }
            }
            if(base3.get(i).equals("3"))
            {
                base3.set(i, "0");
                if(i==base3.size()-1)
                    base3.add("1");
                else
                {
                    Integer in = new Integer(Integer.parseInt(base3.get(i+1))+1);
                    base3.set(i+1, (in.toString()));
                }
            }
        }
        if(isNeg)
        {
            for(int i=0; i<base3.size(); i++)
            {
                if(base3.get(i).equals("1"))
                    base3.set(i, "-");
                else
                if(base3.get(i).equals("-"))
                    base3.set(i, "1");
            }
        }
        String ans = "";
        for(int i=base3.size()-1; i>=0; i--)
        {
            ans += base3.get(i);
        }
        return ans;
    }
}