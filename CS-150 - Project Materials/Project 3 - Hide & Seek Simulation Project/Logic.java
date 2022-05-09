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

import java.util.Random;

public class Logic 
{
    /*
        This class focuses on taking an implemented Field object and handling overall game progression and logic handling, including 
        movement and valid space checks.
    */
    
    private String[][] board;
    private Coordinates[] coords;
    private final String OBSTACLE = "O";
    private final String HIDER = "H";
    private final String SEEKER = "S";
    private final String EMPTY = ".";
    private final String BORDER = "+";
    private final String XTEMP = "X";
    private final String ZOMBIE = "Z";
    private final String FIRE = "F";
    private final String ITEMP = "I";
    private final String BTEMP = "B";
    private final int ROWS = 15;
    private final int COLUMNS = 30;
    private final int MAX_OBJECT_SIZE = 50;
    
    public Logic()
    {
        
    }
    
    public Logic(Field board)
    {
        this.board = board.getField();
        this.coords = null; //Keeps track of up to total Seeker/Zombie locations in an implemented Field.
    }
    
    //Movement-Related Methods
    public String [][] spaceCheck()
    {
        int numElem = 0;
        coords = new Coordinates[totalSeekerTypes()];
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if(board[i][j].equals(SEEKER) || (board[i][j].equals(ZOMBIE)))
                {
                    int a = i;
                    int b = j;
                    coords[numElem] = new Coordinates(a, b);
                    numElem++;
                }
            }
        }
        moveSeekerTypes(coords);
        return board;
    }
    
    public String[][] moveSeekerTypes(Coordinates [] coords)
    {
        //Variable Declaration
        int randA = 0;
        int randB = 0;
        int numElem = 0;
        
        while(numElem < coords.length)
        {
            //if(checkValidSpace(coords[numElem].getRow(), coords[numElem].getColumn()))
            //{
                //For as long as generateMoveSpace doesn't generate values that would find an OBSTACLE or a BORDER, then the values of the original space
                //and the newly determined space can be changed accordingly.
                do
                {
                    randA = generateMoveSpace(coords[numElem].getRow());
                    randB = generateMoveSpace(coords[numElem].getColumn());
                }while((board[randA][randB].equals(OBSTACLE)) || (board[randA][randB].equals(BORDER)) || (board[randA][randB].equals(SEEKER))
                || (board[randA][randB].equals(ZOMBIE)));

                switch (board[randA][randB]) 
                {
                    case EMPTY:
                        if(board[coords[numElem].getRow()][coords[numElem].getColumn()].equals(ZOMBIE))
                        {
                            board[coords[numElem].getRow()][coords[numElem].getColumn()] = EMPTY;
                            board[randA][randB] = ZOMBIE;
                        }
                        else
                        {
                            board[coords[numElem].getRow()][coords[numElem].getColumn()] = EMPTY;
                            board[randA][randB] = SEEKER;
                        }
                        break;
                        
                    case HIDER:
                        if(board[coords[numElem].getRow()][coords[numElem].getColumn()].equals(ZOMBIE))
                        {
                            board[coords[numElem].getRow()][coords[numElem].getColumn()] = EMPTY;
                            board[randA][randB] = ITEMP;
                        }
                        else
                        {
                            board[coords[numElem].getRow()][coords[numElem].getColumn()] = EMPTY;
                            board[randA][randB] = XTEMP;
                        }   
                        break;
                        
                    case FIRE:
                        board[coords[numElem].getRow()][coords[numElem].getColumn()] = BTEMP;
                        break;
                    
                    default:
                        break;
                }
                numElem++;
            }
        //}
        
        return board;
    }
    
    public int generateMoveSpace(int a)
    {
        //Generates a random integer value to be added to the value of a and b, which will result in either result in -1, +1, or neither.
        Random random = new Random();
        return (a) + ((random.nextInt(2)) - random.nextInt(2));
    }
    
    public boolean checkValidSpace(int a, int b)
    {
        /*The following purpose of this if statement is to scan the SEEKER space's surrounding objects, and checking to see if there is a
        possible space for it to move to. Whether or not one of those spaces is an OBSTACLE (since this strictly checks for availability of the space)
        is handled later.*/ 
        return ((board[a+1][b].equals(EMPTY)) || (board[a+1][b].equals(HIDER))) || 
                ((board[a-1][b].equals(EMPTY)) || (board[a-1][b].equals(HIDER))) ||
                ((board[a][b+1].equals(EMPTY)) || (board[a][b+1].equals(HIDER))) ||
                ((board[a][b-1].equals(EMPTY)) || (board[a][b-1].equals(HIDER))) ||
                ((board[a-1][b+1].equals(EMPTY)) || (board[a-1][b+1].equals(HIDER))) ||
                ((board[a+1][b+1].equals(EMPTY)) || (board[a+1][b+1].equals(HIDER))) ||
                ((board[a-1][b-1].equals(EMPTY)) || (board[a-1][b-1].equals(HIDER))) ||
                ((board[a+1][b-1].equals(EMPTY)) || (board[a+1][b-1].equals(HIDER)));
    }
    
    //TempVal-Check Methods
    public void tempValCheck()
    {
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if(board[i][j].equals(XTEMP))
                {
                    System.out.printf("Caught at %d, %d%n", i, j);
                }
                if(board[i][j].equals(ITEMP))
                {
                    System.out.printf("Infected at %d, %d%n", i, j);
                }
                if(board[i][j].equals(BTEMP))
                {
                    System.out.printf("Walked into fire at %d, %d%n", i, j);
                }
            }
        }
    }
    
    public String[][] tempValCleanse()
    {
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if(board[i][j].equals(XTEMP))
                {
                    board[i][j] = SEEKER;
                }
                if(board[i][j].equals(ITEMP))
                {
                    board[i][j] = ZOMBIE;
                    addOneZombie();
                }
                if(board[i][j].equals(BTEMP))
                {
                    board[i][j] = FIRE;
                }
            }
        }
        
        return board;
    }
    
    public int countTempVal()
    {
        int tempCount = 0;
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if(board[i][j].equals(XTEMP) || board[i][j].equals(ITEMP))
                {
                    tempCount++;
                }
            }
        }
        return tempCount;
    }
    
    public String[][] addOneZombie()
    {
        //Variable Declaration
        int randA = 0;
        int randB = 0;
        int rangeRows = 13;
        int rangeColumns = 28;
        
        //Adding Zombie
        do
        {
            randA = (int)((Math.random() * rangeRows) - 1) + 1;
            randB = (int)((Math.random() * rangeColumns) - 1) + 1;
        }while((board[randA][randB].equals(OBSTACLE)) || (board[randA][randB].equals(BORDER)) || (board[randA][randB].equals(SEEKER))
                || (board[randA][randB].equals(ZOMBIE)) || (board[randA][randB].equals(FIRE)));
        
        board[randA][randB] = ZOMBIE;
        
        return board;
    }
    
    public int totalSeekerTypes()
    {
        int totalSeekers = 0;
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                if(board[i][j].equals(SEEKER) || board[i][j].equals(ZOMBIE))
                {
                    totalSeekers++;
                }
            }
        }
        return totalSeekers;
    }
    
    //Print Method
    public void printField()
    {
        for (int i = 0; i < ROWS; i++) 
        {
            for (int j = 0; j < COLUMNS; j++) 
            {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
