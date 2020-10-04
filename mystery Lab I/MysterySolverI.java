import java.util.*;

/*    for all methods - you get 
StringTokenizer strTok = new StringTokenizer(input);
Stack<?????> s = new Stack<??????>();
Queue<?????> q = new LinkedList<?????>();
plus one other Object  // no collections or List or ....

plus a String only to return the result
 */     

public class MysterySolverI implements MysterySolverInterfaceI
{

    public String mystery1(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        str = strTok.nextToken();
        while(strTok.hasMoreElements())
        {
            str = strTok.nextToken() + " " + str;
        }
        return str;
    }

    public String mystery2(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        while(strTok.hasMoreElements())
        {
            String temp = strTok.nextToken();
            if(Integer.parseInt(temp)%2 == 0)
            {
                str += temp + " ";
            }
            else
            {
                str = temp + " " + str;
            }
        }
        return str.substring(0, str.length()-1);
    }

    public String mystery3(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        str = "" + (int)Math.pow(Integer.parseInt(strTok.nextToken()), 2);
        while(strTok.hasMoreElements())
        {
            str = (int)Math.pow(Integer.parseInt(strTok.nextToken()), 2) + " " + str;
        }
        return str;
    }

    public String mystery4(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        int total = 1;
        str = "";
        while(strTok.hasMoreElements())
        {
            total *= Integer.parseInt(strTok.nextToken());
            str = total + " " + str;
        }
        return str.substring(0, str.length()-1);
    }

    public String mystery5(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        int total = 1;
        str = "";
        while(strTok.hasMoreElements())
        {
            total *= Integer.parseInt(strTok.nextToken());
            str += total + " ";
        }
        return str.substring(0, str.length()-1);
    }
}