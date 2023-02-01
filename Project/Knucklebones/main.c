#include <stdio.h>
#include <stdlib.h>
//#include <initGame.h>
//#include <game.h>




void printExpectedArguments(){

    printf("Expected arguments:\n");
    printf("Number of columns: (3-5)\n");
    printf("Number of dice per column (3-5)\n");
    printf("Two-player game / AI opponent (0/1)\n"); 

}

int main(int argc, char *argv[]){
    

    // check argument quantity 
    if(argc != 4){
        printf("Incorrect number of arguments received.\n"); 
        printExpectedArguments();
        return -1;
    }
    for(int i = 0; i < 4; i++){

    }

    // read in command line arguments 
    int columns = atoi(argv[1]); 
    int numDice = atoi(argv[2]); 
    int playComp = atoi(argv[3]);

    // check if arguments are valid
    if(columns < 3 || numDice < 3 || playComp < 0 || playComp > 1){
        printf("Invalid command line arguments received.\n");
        printExpectedArguments();
        return -2;
    }

    
    // allocate memory  

    int maxDie = columns * numDice; 
    

    printf("nice\n");

    initGame(); 

    return 0;
}
