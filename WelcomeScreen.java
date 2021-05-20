//Creating a welcome screen class. Not really necessary, I just thought that it tidied up the MyConnectFour screen
public class WelcomeScreen { 

  //create an introduction message to display to the player upon playing.
  public static void introMessage(){ 
    System.out.println("Welcome to Connect 4!");
    System.out.println("There are 2 players: you and the computer.");
    System.out.println("You are red, and the computer is yellow.");
    System.out.println("To play the game, type in the number of the column you want to drop your counter in.");
    System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally.");

    //print out an empty line to separate the above message with the player board. Makes the user interface nicer.
    System.out.println(); 
  }


}