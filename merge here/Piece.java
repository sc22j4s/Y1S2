class Piece {

    // abstract class, all pieces have this 

    // different pieces have the way they move 

    
    private int[] pos;
    private String colour;
    private boolean alive;

    public Piece(int[] startPos, String col){
        pos = startPos;
        colour = col;
        alive = true;
        
    }

    public int[] getPos(){
        return pos;
    }

    public String getColour(){
        return colour;
    }

    public boolean isAlive(){
        return alive;
    }
    
    public void move(int[] newPos){

        // validated first by subclass if it can do it.
        // further checks if game over or if piece is overtaken
        // overwrite char board
        pos = newPos;
        board.getBoard()[newPos[0],newPos[1]] = icon;

    }
}