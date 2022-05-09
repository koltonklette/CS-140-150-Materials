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
public class Field 
{
    private final String OBSTACLE = "O";
    private final String HIDER = "H";
    private final String SEEKER = "S";
    private final String EMPTY = ".";
    private final String BORDER = "+";
    private final String ZOMBIE = "Z";
    private final String FIRE = "F";
    private final int ROWS = 15;
    private final int COLUMNS = 30;
    
    private String [][] Field;
   
    public Field()
    {
        /*Creates and implements a String array Field, with desired parameters 
          and blank contents within the border.*/
        Field = new String [ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if((i == 0) || (i == ROWS - 1))
                {
                    Field [i][j] = BORDER;
                }
                else
                {
                    if ((j == 0) || j == COLUMNS - 1)
                    {
                        Field [i][j] = BORDER;
                    }
                    else
                    {
                        Field [i][j] = EMPTY;
                    }
                }
            }
        }
    }

    public String[][] getField() 
    {
        return Field;
    }
   
    //Variable Implementation Methods
    public String[][] implementObstacles()
    {
        //Variable Declaration
        int countObstacle = 0; //keeps track of the amount of Obstacles added into array
        int randRow = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int randColumn = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int rangeRows = rangeOfRows();
        int rangeColumns = rangeOfColumns();
        
        //Loop is implemented so that specific elements, generated randomly, will be replaced with value of OBSTACLE
        while(countObstacle < 5)
        {
            //Defining Random Element of 2-D Array to Be Changed
            randRow = (int)((Math.random() * rangeRows) - 1) + 1;
            randColumn = (int)((Math.random() * rangeColumns) - 1) + 1;
            
            //Determining If Random Element Generated Can Be Changed
            if((Field[randRow][randColumn].equals(EMPTY)))
            {
                Field[randRow][randColumn] = OBSTACLE;
                countObstacle++; 
            }
        }
        return Field;
    }
    
    public String[][] implementHiders()
    {
       //Variable Declaration
        int countHider = 0; //keeps track of the amount of Obstacles added into array
        int randRow = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int randColumn = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int rangeRows = rangeOfRows();
        int rangeColumns = rangeOfColumns();
        
        //Loop is implemented so that specific elements, generated randomly, will be replaced with value of HIDER
        while(countHider < 10)
        {
            //Defining Random Element of 2-D Array to Be Changed
            randRow = (int)((Math.random() * rangeRows) - 1) + 1;
            randColumn = (int)((Math.random() * rangeColumns) - 1) + 1;
            
            //Determining If Random Element Generated Can Be Changed
            if((Field[randRow][randColumn].equals(EMPTY)))
            {
                Field[randRow][randColumn] = HIDER;
                countHider++; 
            }
        }
        return Field; 
    }
    
    public String[][] implementSeekers()
    {
        //Variable Declaration
        int countSeeker = 0; //keeps track of the amount of Obstacles added into array
        int randRow = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int randColumn = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int rangeRows = rangeOfRows();
        int rangeColumns = rangeOfColumns();
        
        //Loop is implemented so that specific elements, generated randomly, will be replaced with value of SEEKER
        while(countSeeker < 5)
        {
            //Defining Random Element of 2-D Array to Be Changed
            randRow = (int)((Math.random() * rangeRows) - 1) + 1;
            randColumn = (int)((Math.random() * rangeColumns) - 1) + 1;
            
            //Determining If Random Element Generated Can Be Changed
            if((Field[randRow][randColumn].equals(EMPTY)))
            {
                Field[randRow][randColumn] = SEEKER;
                countSeeker++; 
            }
        }
        return Field;
    }
    
    //Creative Element #1: Zombies
    /*
        Zombies are a unique type of Seeker that act similar to Seekers in that they will find Hiders, but apply a special character
        to any found Hider ("I"). Whenever a Zombie finds a Hider, the Hider is removed as normal, but also adds an additional Seeker to the game.
    */
    public String[][] implementZombies()
    {
        //Variable Declaration
        int countZombie = 0; //keeps track of the amount of Obstacles added into array
        int randRow = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int randColumn = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int rangeRows = rangeOfRows();
        int rangeColumns = rangeOfColumns();
        
        //Loop is implemented so that specific elements, generated randomly, will be replaced with value of SEEKER
        while(countZombie < 5)
        {
            //Defining Random Element of 2-D Array to Be Changed
            randRow = (int)((Math.random() * rangeRows) - 1) + 1;
            randColumn = (int)((Math.random() * rangeColumns) - 1) + 1;
            
            //Determining If Random Element Generated Can Be Changed
            if((Field[randRow][randColumn].equals(EMPTY)))
            {
                Field[randRow][randColumn] = ZOMBIE;
                countZombie++; 
            }
        }
        return Field;
    }
    
    //Creative Element #2: Fire
    /*
        Fire is a type of Obstacle that will remove any Seeker or Zombie that moves onto it. In addition, any Seeker or Zombie that attempts to
        move onto the fire will itself become a Fire space, being marked with the String "B" beforehand.
    */
    public String[][] implementFire()
    {
        //Variable Declaration
        int countFire = 0; //keeps track of the amount of Obstacles added into array
        int randRow = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int randColumn = 0; //Random number must be declared within the loop below since more than one element needs to change.
        int rangeRows = rangeOfRows();
        int rangeColumns = rangeOfColumns();
        
        //Loop is implemented so that specific elements, generated randomly, will be replaced with value of OBSTACLE
        while(countFire < 5)
        {
            //Defining Random Element of 2-D Array to Be Changed
            randRow = (int)((Math.random() * rangeRows) - 1) + 1;
            randColumn = (int)((Math.random() * rangeColumns) - 1) + 1;
            
            //Determining If Random Element Generated Can Be Changed
            if((Field[randRow][randColumn].equals(EMPTY)))
            {
                Field[randRow][randColumn] = FIRE;
                countFire++; 
            }
        }
        return Field;
    }
    
    //Range Calculation Methods
    public int rangeOfRows()
    {
        //Defining the Range of the Random Number (ROWS)
        int maxRows = 13;  
        int minRows = 1;
        int rangeRows = maxRows - minRows + 1;
        
        return rangeRows;
    }
    
    public int rangeOfColumns()
    {
        //Defining the Range of the Random Number (COLUMNS)
        int maxColumns = 28;
        int minColumns = 1;
        int rangeColumns = maxColumns - minColumns + 1;
        
        return rangeColumns;
    }
}