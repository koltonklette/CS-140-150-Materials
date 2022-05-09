/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3.pkg1;

//Kolton Klette
//Steven Klein
//CS 150-001
//April 5th, 2019
//Project 3 - Simulation
public class Main 
{
    public static void main(String[] args) 
    {
        //Setting Up The Field
        Field board = new Field();
        board = fieldSetUp(board);
        Logic game = new Logic(board);
        
        runSimulation(board, game);
        
    }
    
    public static Field fieldSetUp(Field board)
    {
        board.implementObstacles();
        board.implementHiders();
        board.implementSeekers();
        board.implementZombies();
        board.implementFire();
        
        return board;
    }
    
    public static void runSimulation(Field board, Logic game)
    {
        //Variable Declaration
        int turnCount = 0;
        int hiderCount = 10; //Amount of Hiders remains constant per run of the simulation
        int decreaseHider = 0;
        
        //Simulation Progression
        while((turnCount <= 250) && (hiderCount > 0))
        {
            //Turn Header + Field Print
            System.out.printf("Turn: %d%n", turnCount);
            System.out.printf("Remaining hiders: %d%n", hiderCount);
            game.tempValCheck();
            game.printField();
            
            //Next Turn Setup
            decreaseHider = game.countTempVal();
            hiderCount = (hiderCount - decreaseHider);
            game.tempValCleanse();
            game.spaceCheck();
            turnCount++;
        }
        
        //End Result Print-Out
        if (hiderCount < 1)
        {
            System.out.printf("Game over!%n");
            System.out.printf("All caught!%n");
        }
        else
        {
            System.out.printf("Game over!%n");
            System.out.printf("%d got away!%n", hiderCount);
        }
    }  
}