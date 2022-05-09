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
public class Coordinates 
{
    /*
        This class saves the values of the location of Seekers in an implemented Field object. This is used in the Logic class methods
        in order to prevent hiccups in Seeker movement.
    */
    
    private int row;
    private int column;
    
    public Coordinates()
    {
        
    }
    
    public Coordinates(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow() 
    {
        return row;
    }

    public int getColumn() 
    {
        return column;
    }
}
