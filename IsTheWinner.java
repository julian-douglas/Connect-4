
public class IsTheWinner {

    
    public IsTheWinner() {

    }

    //method to print out the winner,so that an ugly message is not displayed when announcing the winner.
    public static void printWinner(Player player){ 
      if(player.getToken() == 'r') { 

        //if the Human Player is playing, then print out that they won.
        System.out.println("You are the winner!"); 
        } else {

          //otherwise, print out that the computer won.
          System.out.println("Sorry, the computer is the winner..."); 
        }
      }
    

        //Create winCheck, a method that uses the board and the player as an argument to see if the current player has won. This improves on encapsulation and modularisation: very little if any changes will need to be made to this code if more players are added. 
        public static void WinCheck(Board board, Player player){ 

            //declare and initialise both of these booleans as false, so that no one has won yet.
            boolean win = false;
            boolean hasWon = false; 

            //check vertical

            //set the number of counters in a row to 0.
            int count = 0; 

            //for the whole board,
            for (int j = 0; j < board.getWidth(); j++) { 
                count = 0;
                for (int i = 0; i < board.getHeight(); i++) { 

                    //if a counter has been placed, and they build up consecutively, add to the count.
                    if (board.getBoard()[i][j] == player.getToken()) { 
                        count += 1;

                        //if count is 4 or above, then:
                        if (count >= 4) { 

                            //a player has won
                            hasWon = true;  
                        }
                    } else { 

                        // reset the counting; the eventual sequence has been interrupted
                        count = 0;
                    }
                }
            }

             // check horizontal

            //analogous for horizontal
            for (int i = 0; i < board.getHeight(); i++) { 
                count = 0;
                for (int j = 0; j < board.getWidth(); j++) {
                    if (board.getBoard()[i][j] == player.getToken()) {
                        count += 1;
                        if (count >= 4) {
                            hasWon = true;
                        }
                    } else { // reset the counting, the eventual sequence has been interrupted
                        count = 0;
                    }
                }
            }


            //check diagonally: descending

            //as the number of rows increases (goes upwards), 
            for (int h = board.getHeight() - 1; h >= 0; h--) { 

                //and the number of columns increases (goes to the right),
                for (int w = 0; w < board.getWidth(); w++) { 
                    int i = h;
                    int j = w;
                    while (i >= 0 && j < board.getWidth()) { 
                        if (board.getBoard()[i][j] == player.getToken()) {
                            count = count + 1;
                            if (count >= 4) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                        //move onto row above
                        i--; 

                        //move onto next column
                        j++; 
                    }
                    count = 0;
                }
            }
            // check diagonal up left
            count = 0;

            //analogous for opposite diagonal
            for (int h = board.getHeight() - 1; h >= 0; h--) { 
                for (int w = 0; w < board.getWidth(); w++) {
                    int i = h;
                    int j = w;
                    while (i >= 0 && j >= 0) {
                        if (board.getBoard()[i][j] == player.getToken()) {
                            count = count + 1;
                            if (count >= 4) {
                                hasWon = true;
                            }
                        } else {
                            count = 0;
                        }
                        i--;
                        j--;
                    }
                    count = 0;
                }
            }


     //print board with new counter added in
    board.printBoard();
    if (hasWon) {

        //if the player has won, then win is true.
        win = true; 

        //print the winner
        printWinner(player);

        //exit the system; game must be started again
        System.exit(0); 
    }
  }
}
