import java.util.*;
/**
 * Josh Ibad
 * September 15, 2018
 */
public class DigitalEgyptianFraction extends Fraction
{
    public DigitalEgyptianFraction(int b)
    {
        super(1, b);
    }

    public static Fraction addAllDigitalEgyptianFractionsInList(List<DigitalEgyptianFraction> efs)
    {
        Fraction ans = new Fraction(0, 1);
        for(int i=0; i<efs.size(); i++)
        {
            ans.add(efs.get(i));
        }
        return ans;
    }

    public static List<DigitalEgyptianFraction> getListOfDigitalEgyptianFractions(Fraction f)
    {
        List<DigitalEgyptianFraction> ans = new ArrayList<DigitalEgyptianFraction>();
        int digNum = 1;
        while(f.getDecimal()>0)
        {
            DigitalEgyptianFraction temp = new DigitalEgyptianFraction((int)(Math.pow(2,digNum)));
            
            digNum++;
        }
        return ans;
    }

}