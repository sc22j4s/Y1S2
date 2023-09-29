
public class Board {
    
    public final int BOARD_SIZE = 8;
    private char[][] grid;

    public Board(){
        grid = new char[BOARD_SIZE][BOARD_SIZE];
    }


    void setupBoard(){
        // char board to be displayed to player
        // piece objects manipulate board through coord attributes

        // instantiate board pieces

        Rook whiteRook1 = ([0,0], "White");
        f
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int k = 0; k < BOARD_SIZE; k++){
                grid[i][k] = '.';
            }
        }
    }

    void printBoard(){
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int k = 0; k < BOARD_SIZE; k++){
                System.out.println(grid[i][k] + ' ');
            }
            System.out.println(); 
        }
    }

    char[][] getGrid(){
        return grid;
    }

    void update(int[] coords, char icon){
        grid[coords[0]][coords[1]] = icon;
    }
    

}
