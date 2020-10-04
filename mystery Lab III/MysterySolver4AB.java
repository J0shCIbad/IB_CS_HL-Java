import java.util.*;

	 public class MysterySolver4AB implements MysterySolverInterface4AB
{
  public String mysteryPreFix(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
      Stack<String> s = new Stack<String>();
      String str = "";
      Integer temp;
      while(strTok.hasMoreElements())
      {
          input = (String) strTok.nextElement();
          str = " " + input + str;
      }
      str = str.substring(1);
      strTok = new StringTokenizer(str);
      while(strTok.hasMoreElements())
      {
          s.push((String) strTok.nextElement());
          if(!Character.isDigit(s.peek().charAt(0)) && s.peek().length() == 1)
          {
              str = s.pop();
              temp = Integer.parseInt(s.pop());
              if(str.equals("+"))
              {
                  s.push("" + (temp + ((int) Integer.parseInt(s.pop()))));
              }
              if(str.equals("-"))
              {
                  s.push("" + (temp - ((int) Integer.parseInt(s.pop()))));
              }
              if(str.equals("*"))
              {
                  s.push("" + (temp * ((int) Integer.parseInt(s.pop()))));
              }
              if(str.equals("/"))
              {
                  s.push("" + (temp / ((int) Integer.parseInt(s.pop()))));
              }
              if(str.equals("%"))
              {
                  s.push("" + (temp % ((int) Integer.parseInt(s.pop()))));
              }
              if(str.equals("^"))
              {
                  s.push("" + ((int) Math.pow(temp, Integer.parseInt(s.pop()))));
              }
          }
      }
      return s.pop();
  }

  public String mysteryPostFix(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
      Stack<String> s = new Stack<String>();
      String str = "";
      Integer temp;
      while(strTok.hasMoreElements())
      {
          s.push((String) strTok.nextElement());
          if(!Character.isDigit(s.peek().charAt(0)) && s.peek().length() == 1)
          {
              str = s.pop();
              temp = Integer.parseInt(s.pop());
              if(str.equals("+"))
              {
                  s.push("" + ((int) Integer.parseInt(s.pop()) + temp));
              }
              if(str.equals("-"))
              {
                  s.push("" + ((int) Integer.parseInt(s.pop()) - temp));
              }
              if(str.equals("*"))
              {
                  s.push("" + ((int) Integer.parseInt(s.pop()) * temp));
              }
              if(str.equals("/"))
              {
                  s.push("" + ((int) Integer.parseInt(s.pop()) / temp));
              }
              if(str.equals("%"))
              {
                  s.push("" + (Integer.parseInt(s.pop()) % temp));
              }
              if(str.equals("^"))
              {
                  s.push("" + ((int) Math.pow(Integer.parseInt(s.pop()), temp)));
              }
          }
      }
      return s.pop();
}
    
  public String mysteryP(String input)
  {
    String str = "";
    int a = 2;
    for(int b = 0; b < Integer.parseInt(input); b++)
    {
        int temp = 2;
        while(temp < a)
        {
            if(a % temp == 0)
            {
                b--;
                a++;
                temp = a + 1;
            }
            else
            {
                temp++;
            }
        }
        if(temp == a)
        {
            str += a + " ";
            a++;
        }
    }
    return str.substring(0, str.length() - 1);
  }
  
   public String mysteryS(String input)
   {
    String str = "";
    StringTokenizer strTok = new StringTokenizer(input);
    ArrayList<Integer> temp = new ArrayList<Integer>();
    while(strTok.hasMoreElements())
    {
        temp.add(Integer.parseInt((String)strTok.nextElement()));
    }
    for(int a = 1; a < temp.size(); a++)
    {
        while(a > 0 && temp.get(a) < temp.get(a-1))
        {
            Integer temp2 = temp.get(a);
            temp.set(a, temp.get(a - 1));
            temp.set(a - 1, temp2);
            a--;
        }
    }
    for(int a = 0; a < temp.size(); a++)
    {
        str += temp.get(a) + " ";
    }
    return str.substring(0, str.length() - 1);
  }  

  public String mystery10(String input)
  {
    StringTokenizer strTok = new StringTokenizer(input);
    String str = new String();
    Integer temp = Integer.parseInt((String) strTok.nextElement());
    Integer temp2 = Integer.parseInt((String) strTok.nextElement());
    Integer temp3 = Integer.parseInt((String) strTok.nextElement());
    double temp4 = (temp * 1.0) / (temp2);
    for(int a = 0; a < temp3.intValue(); a++)
    {
        temp4 = temp4 * 10.0;
        if(temp4 < 1)
        {
            str += "0";
        }
    }
    long ans = (long) temp4;
    str += ans;
    return str;
  }
  
  public String mysteryC(String input)
  {
      StringTokenizer strTok = new StringTokenizer(input);
      Queue<String> q = new LinkedList<String>();
      Stack<String> s = new Stack<String>();
      String str = (String) strTok.nextElement();
      Integer temp = Integer.parseInt((String) strTok.nextElement());
      input = str;
      while(temp > 0)
      {
          q.add("");
          temp--;
      }
      temp = 1;
      while(!q.isEmpty())
      {
          while(str.length() > 0)
          {
              s.push(str.substring(0, 1));
              str = str.substring(1);
          }
          while(!s.isEmpty())
          {
              str = (String) s.pop() + str;
              while(!s.isEmpty() && str.substring(0, 1).equals(s.peek()))
              {
                  temp++;
                  s.pop();
              }
              str = temp + str;
              temp = 1;
          }
          q.remove();
          input = input + "\n" + str;
      }
      return "OUTPUT:\n" + input;    
  }
}