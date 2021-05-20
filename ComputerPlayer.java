//import the random package for random functionality for the computer player
import java.util.Random; 

//ComputerPlayer class is a subclass of Player
public class ComputerPlayer extends Player { 

  //declare r as being a random object
  private Random r; 

  public ComputerPlayer(char token){

    //this class inherits all attributes from the objects of the player class. 
    super(token);

    //initialise r as a random number
    r = new Random(); 
  }

  //Method to get the computer's move. Overrides the getMove() method from the Player class.
  public int getMove(){ 

    //return a number between 1 and 7 inclusive.  
    return (r.nextInt(7)+1); 
    
  }
}