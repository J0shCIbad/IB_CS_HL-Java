//  call this class MysterySolver

public interface MysterySolverInterface4AB
{
/*   one StringTokenizer strTok = new StringTokenizer(input)
     is allowed per method.  This is also the only use of input allowed.
     In addition, StringTokenizer is only allowed to partition the String and enter
     into the stack or queue or ....  No other use of StringTokenizer is allowed.
*/
  
//  Following each method is a list of allowabe Objects.  You are NOT required 
//  to use each Object provided.  But you may not use another Objects


  String mystery10(String input);
  /*  Allowable Objects
  	StringTokenizer strTok = new StringTokenizer(input);

  	Stack<someClassThatYouChoose> s = new Stack<someClassThatYouChoose>();
  	Queue<someClassThatYouChoose> q = new LinkedList<someClassThatYouChoose>();
   	String str = new String();   
   	plus one other Object of your choice, for example one Integer or String or ....
 */ 
  
/*
 *    Precondition:  The tester will never have more than 3 consecutive numbers
 *                   That is, the same number will never appear more than 3 times in a row
 */
// Yes, I know all of the following are the same!!!!  
  String mysteryC(String input);
// Yes, I know all of the following are the same!!!!  
  /*  Allowable Objects
  	StringTokenizer strTok = new StringTokenizer(input);

  	Stack<someClassThatYouChoose> s = new Stack<someClassThatYouChoose>();
  	Queue<someClassThatYouChoose> q = new LinkedList<someClassThatYouChoose>();
   	String str = new String();   
   	plus one other Object of your choice, for example one Integer or String or ....
 */ 
  
  String mysteryP(String input);
  /*  Allowable Objects
  	StringTokenizer strTok = new StringTokenizer(input);

  	Stack<someClassThatYouChoose> s = new Stack<someClassThatYouChoose>();
  	Queue<someClassThatYouChoose> q = new LinkedList<someClassThatYouChoose>();
   	String str = new String();   
   	plus one other Object of your choice, for example one Integer or String or ....
 */ 
  
  String mysteryS(String input);
  /*  Allowable Objects
  	StringTokenizer strTok = new StringTokenizer(input);

  	Stack<someClassThatYouChoose> s = new Stack<someClassThatYouChoose>();
  	Queue<someClassThatYouChoose> q = new LinkedList<someClassThatYouChoose>();
   	String str = new String();   
   	plus one other Object of your choice, for example one Integer or String or ....
 */ 

  String mysteryPostFix(String input);
  /*  Allowable Objects
  	StringTokenizer strTok = new StringTokenizer(input);

  	Stack<someClassThatYouChoose> s = new Stack<someClassThatYouChoose>();
  	Queue<someClassThatYouChoose> q = new LinkedList<someClassThatYouChoose>();
   	String str = new String();   
   	plus one other Object of your choice, for example one Integer or String or ....
 */ 

  String mysteryPreFix(String input);
  /*  Allowable Objects
  	StringTokenizer strTok = new StringTokenizer(input);

  	Stack<someClassThatYouChoose> s = new Stack<someClassThatYouChoose>();
  	Queue<someClassThatYouChoose> q = new LinkedList<someClassThatYouChoose>();
   	String str = new String();   
   	plus one other Object of your choice, for example one Integer or String or ....
 */ 
}