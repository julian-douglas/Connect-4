import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class MyConnectFour {

    //declare the board
    private final Board board; 

    public MyConnectFour() {

        //initiliase the board as having 6 rows and 7 columns.
        board = new Board(6, 7); 

        //play the game!
        playGame(); 
    }

    //declare and initialise a new human player object, which inherits from the Player class
    Player humanPlayer = new HumanPlayer('r'); 

    //declare and initialise a new computer player object, which inherits from the Player class
    Player computerPlayer = new ComputerPlayer('y'); 

    
    //method to play the game
    private void playGame() {

        //call the welcome screen
        WelcomeScreen.introMessage(); 

        //print the board to begin with.
        board.printBoard(); 

        //set the state to have no current winners.
        boolean win = false; 

        //until there is a winner:
        while (!win) { 

            //there may be exceptions raised, such as when the player enters a non-integer or something that is not between 1 and 7 exclusive.
            try { 

            //while(!board.placeCounter(humanPlayer, Player.getMove())){ //I tried to include functionality for the user to not be allowed to place the counter in a full column, however the user was then unable to win.

            //place the human player's counter in the column that they select. We can use the getMove() method here because it overrides it from the Player class.
            board.placeCounter(humanPlayer, humanPlayer.getMove()); 

            //check if the player has won yet
            IsTheWinner.WinCheck(board, humanPlayer); 
            //}

            //if not, then let the computer player make their move. We can use the getMove() method here because the ComputerPlayer class overrides this method.
            board.placeCounter(computerPlayer, computerPlayer.getMove()); 

            //check if the computer player has won.
            IsTheWinner.WinCheck(board, computerPlayer); 

            //if no one has won, let the cycle continue.
            } 

            //two possible exceptions: either the array index is out of bounds (the user has input a number that is not between 1 and 7) or there is an error with the format of the input (the number is not an integer). 
            catch (NumberFormatException | ArrayIndexOutOfBoundsException e){

            //in which case, I catch this exception, telling the user to input a valid number. 
            System.out.println("Please input a number between 1 and 7. The column may be full."); 
            }
        }
    }
}

