

public class King extends Piece {
    
    // when taken, gameOver = true
    // valid if newPos - oldPos <= 1, => -1
    private int[2] pos;
    private int x;
    private int y;
    private String colour;
    private char icon;



    public King(int x_start, int y_start, String col){
        x = x_start;
        y = y_start;
        pos = [x_start, y_start];
        colour = col;
        if (colour.equals("White")){
            icon = '♚';
        }
        else{
            icon = '♔';
        }

        
        
        
    }
}
