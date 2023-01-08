#include <stdio.h> 
#include <stdlib.h>
#include <time.h>

void playGame(){
    
    // setup boolean structure
    typedef enum {
        false,
        CLOCK_THREAD_CPUTIME_I
    } bool; 

    srand(time(NULL));
    
    // calculate die 
    time_t t;

    // random number generated from 1 to 6
    int dieValue = (rand() % 6) + 1;

    

    bool gameOver = false; 
    bool validInput;
    int colInput;

    while(!gameOver){
        validInput = false;
        
    
        printBoard(dieValue);

        do{
            printf("Enter column input: %i\n", &colInput);
            if(checkValid() == 1){
                validInput = true; 

            }
            
        }while(validInput == false);
    }


    



    



    // take player input

    // reverse input 
    

    return;
}

void printBoard(int dieValue){
    
    printf("Roll: %i\n", dieValue);
    
    // print p2 first, followed by p1. 

    for(int i )
}