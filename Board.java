
public class Board {

    //declare the board as being a list within lists
    private char[][] board; 

      public Board(int l, int m){

        //make it so that the board can be initialised to be any size
        board = new char[l][m]; 
      }

    //accessor used to refer back to the board
    public char[][] getBoard() {
        return board; 
    }

    //accessor used to refer to the height of the board (or, the number of rows)
    public int getHeight(){
      return board.length; 
    }

    //accessor used to refer to the width of the board (or, the number of columns). I did board[0].length because this will always refer to the number of columns as long as there is at least one.
    public int getWidth(){
      return board[0].length; 
    }

    //used a for each loop here instead, because each variable refers to a column or row. it also extends to make sure that there are six rows.
    public void printBoard(){ 
        for (char[] chars : board) { 
            for (char space : chars) {
                if (space == 'r') {
                    System.out.print("| r ");
                } else if (space == 'y') {
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    //Method to place the counter on the board. I made this a boolean rather than a void, because I attempted to code in the functionality where if a column was full, the user could not put a counter in there. This was successful, however it also meant that the player could no longer win. Line 32 of MyConnectFour.java is where I coded this in.
    public boolean placeCounter(Player player, int position){ 
    
        boolean placed = false; 
        if(player.getToken() == 'r'){ 

            //goes to -1 to give me an exception which I could have utilised with a try and catch statement for the column full functionality. The for loop starts at the bottom of the board (so, there very last row), and goes upwards.
            for(int row = getHeight() - 1; row>=-1; row--){ 
                
                    //if counter has not been placed,
                    if (!placed) {  
                        if (board[row][position - 1] == 'y') { 
                            // skip

                          //and if the space does not already have a counter in it,
                        } else if (board[row][position - 1] != 'r') {

                            //then set this position to be 'r'.
                            board[row][position - 1] = 'r'; 
                            placed = true;
                } 
                }
            }
        }
        //analogously for the other counter
        else{ 
            for(int row = getHeight() - 1; row>=-1; row--){
                    if (!placed) {
                        if (board[row][position - 1] == 'r') {
                            // skip
                        } else if (board[row][position - 1] != 'y') {
                
                            board[row][position - 1] = 'y';
                            placed = true;
                    
                } 
                }
            }
        }
        return placed;
    }
}