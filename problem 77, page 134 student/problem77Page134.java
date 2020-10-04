import java.util.*;
import java.lang.Math;
/**
 * problem77 Page134  Weird String Function
 *
 * @Josh C Ibad
 * @18.01.19
 */
public class problem77Page134
{
    private List<String> x;
    /*
     *  domain is an array with three elements
     */
    public problem77Page134(String[] domain)
    {
        x = new ArrayList<String>();
        for(int i=0; i<3; i++){
            x.add(domain[i]);
        }
    }

    /*
     *  y is an array of length 3
     *  returns a String according to the description of problem 77-81 on page 134
     */
    public String weirdStringFunction(String[] y)
    {
        String str = "";
        for(int i=0; i<3; i++){
            if(x.contains(y[i]))
                str+="1";
            else
                str+="0";
        }
        return str;
    }
} 