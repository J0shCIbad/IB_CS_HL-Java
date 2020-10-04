import java.lang.*;

/**
 * See page bottom of 120/ top of page 121 in the Descrete Math book 
 * for instructions on valid ISBN numbers
 * 
 * @author 
 * @version (a version number or a date)
 */
public class ISBN_Verification
{
    /*
     *    isbn will have the form
     *          "###-#-#####-###-#"
     *     or   "####-##-##-####-#"
     *     or   "####-###-###-##-#"
     *     or   "####-##-####-##-#"
     *     or  ......
     */
    public boolean isValid(String isbn)
    {
        char[] a = isbn.toCharArray();
        if(a[0] == 'x')
           return false;
        int sum = Character.getNumericValue(a[0]);
        int j=1;
        for(int i=1; i<a.length-2; i++)
        {
            if(a[i] != '-')
            {
                sum+=Character.getNumericValue(a[i])*Math.pow(3, j%2);
                j++;
            }
        }
        return Character.getNumericValue(a[a.length-1]) == (10-sum%10)%10;
        /*
        if(sum%10 == 0)
            return Character.getNumericValue(a[a.length-1]) == 0;
        else
            return Character.getNumericValue(a[a.length-1]) == 10-sum%10;
            */
    }
}