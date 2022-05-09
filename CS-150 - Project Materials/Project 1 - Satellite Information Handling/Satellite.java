/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**
 *
 * @author Kolton Klette
 */

//Kolton Klette
//Steven Klein
//CS-150-001
//February 1st, 2019
//Project 1 - Satellites

public class Satellite 
{
    private int xLoc;
    private int yLoc;
    
    public Satellite()
    {
        xLoc = 0;
        yLoc = 0;
    }
    
    public Satellite(int xLoc, int yLoc)
    {
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    public int getXLoc() 
    {
        return xLoc;
    }

    public int getYLoc() 
    {
        return yLoc;
    }
    
}
