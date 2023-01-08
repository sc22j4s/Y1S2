#include <stdio.h> 
#include <stdlib.h>

#include <player.h>
#include <game.h>

// receive main.c arguments

int initGame(Game game){
    
    //instantiate players
    Player* p1; 
    Player* p2;
    char name1[30];
    
    // read in names
    scanf("Enter name of player 1: %s\n", name1);
    p1->name = name1;


    int isAI = 0; 

    // if two-player game selected
    char name2[30];

    if(p2->isAI == 0){
        scanf("Enter name of player 2: %s\n", name2);
    }
    else{
        name2 = "Computer";
    }

    p2->name = name2;

    if(playComp == 0){

    }
}
