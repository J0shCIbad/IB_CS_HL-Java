/**
 * Completed for students
 * 
 * All good
 */
public class Player
{
    private String choice;
    private String name;

    /**
     * Constructor for objects of class Player
     */
    public Player(String n, String ch)
    {
        name = n;
        choice = ch;
    }

    public String getName()
    {
        return name;
    }

    public String getChoice()
    {
        return choice;
    }
}