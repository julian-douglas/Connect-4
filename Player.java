//Set Player to be an abstract class - this exists purely to be overridden! This is a superclass of HumanPlayer and ComputerPlayer. 
public abstract class  Player { 

    //declare the token 
    private char token; 

    public Player(char token) {

        //allow the player's token to be reachable, so that data encapsulation can be used. 
        this.token = token; 
    }

    //as this class is abstract, the accessor getMove() needs to be declared so that it can be overridden.
    abstract int getMove(); 

    //accessor to retrieve the player's token. player.getToken() can be used instead of using 'r' and 'y', which cuts down on repetition.
    public char getToken() { 

        //return the player's token.
        return token; 
    }
}





