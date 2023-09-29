

public class King extends Piece {
    
    // when taken, gameOver = true
    // valid if newPos - oldPos <= 1, => -1
    
    private char icon;



    public King(int x_start, int y_start, String col){
        if (colour.equals("White")){
            icon = '♚';
        }
        else{
            icon = '♔';
        }

        
    }
}
