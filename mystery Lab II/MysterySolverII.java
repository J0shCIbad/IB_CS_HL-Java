import java.util.*;

/*    for all methods - you get 
StringTokenizer strTok = new StringTokenizer(input);
Stack<?????> s = new Stack<??????>();
Queue<?????> q = new LinkedList<?????>();
plus one other Object

plus a String only to return the result
 */     

public class MysterySolverII implements MysterySolverInterfaceII
{
    public String mystery6(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        int total = 0;
        str = "";
        while(strTok.hasMoreElements())
        {
            total += Integer.parseInt(strTok.nextToken());
            str += total + " ";
        }
        return str.substring(0, str.length()-1);
    }

    public String mystery7(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        Queue<Integer> hold = new LinkedList<Integer>();
        String str = "";
        int total = 0;
        str = "";
        while(strTok.hasMoreElements())
        {
            total += Integer.parseInt(strTok.nextToken());
            hold.add(total);
            while(total>0)
            {
                str += hold.peek() + " ";
                total--;
            }
            str = str.substring(0, str.length()-1) + "\n";
            total = hold.poll();
        }
        return str.substring(0, str.length()-1);
    }

    public String mystery8(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String str = "";
        int total = 0;
        while(strTok.hasMoreElements())
        {
            total += Integer.parseInt(strTok.nextToken());
        }
        strTok = new StringTokenizer(input);
        str += total;
        while(strTok.hasMoreElements())
        {
            total -= Integer.parseInt(strTok.nextToken());
            if(strTok.hasMoreElements())
            str = total + " " + str;
        }
        return str;
    }

    public String mystery9(String input)
    {
        StringTokenizer strTok = new StringTokenizer(input);
        String evens = "";
        String odds = "";
        while(strTok.hasMoreElements())
        {
            String temp = strTok.nextToken();
            if(Integer.parseInt(temp)%2 == 0)
            {
                evens = temp + " " + evens;
            }
            else
            {
                odds += temp + " ";
            }
        }
        odds += evens;
        return odds.substring(0, odds.length()-1);
    }

    public String mysteryF(String input)
    {
        //Integer.parseInt(input)
        Stack<Integer> fib = new Stack<Integer>();
        Queue<Integer> hold = new LinkedList<Integer>();
        String str = "";
        fib.push(1);
        if(Integer.parseInt(input) != 1){
            fib.push(1);
            if(Integer.parseInt(input) != 2)
            {
                input = "" + (Integer.parseInt(input)-2);
                hold.add(1);
                while(Integer.parseInt(input) > 0)
                {
                    hold.add(fib.peek());
                    fib.push(hold.poll()+hold.peek());
                    input = "" + (Integer.parseInt(input)-1);
                }
            }
        }
        while(!fib.empty())
        {
            str = fib.pop() + " " + str;
        }
        return str.substring(0, str.length()-1);
    }
}