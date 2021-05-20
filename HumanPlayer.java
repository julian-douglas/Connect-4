//import packages that allow the user to input into the command line.
import java.io.BufferedReader;
import java.io.InputStreamReader;

//HumanPlayer is a subclass of Player.
public class HumanPlayer extends Player{ 

  //declare the user's input in this class
  private BufferedReader input; 

  
  public HumanPlayer(char token){

    //inherits all objects from Player class
    super(token); 

    //initialise the input 
    input = new BufferedReader(new InputStreamReader(System.in)); 

  }

  //accessor to get the user's input
  public String getUserInput() { 

        //default is nothing
        String toReturn = null; 
        try {
            //take the user's input from the command line
            toReturn = input.readLine(); 
        } catch (Exception e) {
        }
        //return toReturn if it's okay.
        return toReturn; 
    }

  //accessor to retrieve the user's position in which they placed their counter. Allows for code reuse.
  public int getMove(){ 

      //the user inputs a string
      String userInput = getUserInput(); 

      //and Java turns it into an integer!
      int move = Integer.parseInt(userInput); 
      return move; 
    }

}