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

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
       //Variable Declaration
       Satellite[] sat = null; 
       String groupName = "";
       int numSats = 0;
       String fileName = "satellite.txt";
       PrintWriter fout = null;
       
       //Main Method
       Scanner input = setInput(fileName);
               // groupName = input.next();
               // numSats = input.nextInt();
               // sat = readFile(numSats, input);
               // printArray(groupName, numSats, sat, fout);
       while(input.hasNext())
       {
           groupName = input.next();
           numSats = input.nextInt();
           sat = readFile(numSats, input);
           printArray(groupName, numSats, sat, fout);
       }
       input.close();
    }
    
    public static Satellite[] readFile(int numSats, Scanner input)
    {
       //Reading Information From Input File 
       Satellite[] sat = new Satellite[numSats];
       for (int i = 0; i < sat.length; i++) 
       {
           int xLoc = input.nextInt();
           int yLoc = input.nextInt();
           sat[i] = new Satellite(xLoc, yLoc);
       }
       //input.close();
       
       return sat;
    }
    
    public static void printArray(String groupName, int numSats, Satellite[] sat, PrintWriter fout)
    {
        //Variable Declaration
        double [][] distance = null;
        double [][] angle = null;
        fout = null;

        //PrintWriter Check
        try
        {
           //fout = new PrintWriter(groupName + ".txt");
           fout = new PrintWriter(new File(groupName + ".txt"));
        }
        catch (FileNotFoundException ex)
        {
           System.err.print("Error: ");
           System.exit(1);
        }
        
        //Printing To File
        fout.printf("Group Name: %s%n", groupName);
        fout.printf("Number of Satellites : %d%n", numSats);
        getSatelliteGrid(sat, fout);
        fout.printf("Results for distances:%n%20d", 0);
        distance = calcPrintDist(sat, fout, distance, numSats);
        fout.printf("Results for angles:%n%20d", 0);
        angle = calcPrintAngle(sat, fout, angle, numSats);
        closeDist(distance, fout);
        farDist(distance, fout);
        fout.close();
        
    }
    
    public static Scanner setInput(String fileName)
    {
       Scanner input = null;
       try
       {
           File fin = new File(fileName);
           input = new Scanner(fin);
       }
       catch (FileNotFoundException ex)
       {
           System.err.println("File not found: " + fileName);
           System.exit(1);
       }
       
       return input;
    }
    
    public static void getSatelliteGrid(Satellite[] sat, PrintWriter fout)
    {
        if(sat.length > 10)
        {
            fout.printf(" #      x      y%n");
            for (int i = 0; i < sat.length; i++) 
            {
                fout.printf("%2d%7d%7d%n", i, sat[i].getXLoc(), sat[i].getYLoc());
            }
        }
        else
        {
            fout.printf("#      x      y%n");
            for (int i = 0; i < sat.length; i++) 
            {
                fout.printf("%d%7d%7d%n", i, sat[i].getXLoc(), sat[i].getYLoc());
            }
        }
        
    }
    
    public static double[][] calcPrintDist(Satellite[] sat, PrintWriter fout, double [][] distance, int numSats)
    {
        distance = new double [numSats][numSats];
        
        for (int k = 1; k < numSats; k++)
        {
            fout.printf("%10d", k);
        }
        fout.printf("%n");
        
        //Calculation Loop
        for (int i = 0; i < distance.length; i++) 
        {
            for (int j = 0; j < distance.length; j++) 
            {
                //Calculation
                int xTwo = sat[j].getXLoc();
                int xOne = sat[i].getXLoc();
                int yTwo = sat[j].getYLoc();
                int yOne = sat[i].getYLoc();
                distance[i][j] = Math.sqrt((Math.pow((xTwo - xOne), 2) + (Math.pow((yTwo - yOne),2))));
            }
        }
        
        //Printing Loop
        for(int k = 0; k < distance.length; k++)
        {
            fout.printf("%10d", k);
            for (int l = 0; l < distance.length; l++)
            {
                fout.printf("%10.3f", distance[k][l]);
            }
            fout.printf("%n");
        }
                
        return distance;
    }
    
    public static double[][] calcPrintAngle(Satellite[] sat, PrintWriter fout, double [][] angle, int numSats)
    {
        angle = new double [numSats][numSats];
        
        for (int k = 1; k < numSats; k++)
        {
            fout.printf("%10d", k);
        }
        fout.printf("%n");
        
        //Calculation Loop
        for (int i = 0; i < angle.length; i++) 
        {
            for (int j = 0; j < angle.length; j++) 
            {
                //Set-Up
                int xTwo = sat[j].getXLoc();
                int xOne = sat[i].getXLoc();
                int yTwo = sat[j].getYLoc();
                int yOne = sat[i].getYLoc();
                
                int deltaX = xTwo - xOne;
                int deltaY = yTwo - yOne;
                
                //Calculation
                angle[i][j] = Math.toDegrees(Math.atan2(deltaY, deltaX));
                if(angle[i][j] < 0)
                {
                    angle[i][j] += 360;
                }
            }
        }
        
        //Printing Loop
        for(int k = 0; k < angle.length; k++)
        {
            fout.printf("%10d", k);
            for (int l = 0; l < angle.length; l++)
            {
                fout.printf("%10.3f", angle[k][l]);
            }
            fout.printf("%n");
        }
                
        return angle;
    }
    public static void closeDist(double[][] distance, PrintWriter fout)
    {
        double closest = 99999999999999999.9;
        int numI = 0;
        int numJ = 0;
        for (int i = 0; i < distance.length; i++)
        {
            for (int j = 0; j < distance.length; j++)
            {
                if ((distance[i][j] < closest) && (distance[i][j] != 0))
                {
                    closest = distance[i][j];
                    numI = i;
                    numJ = j;
                }
            }
        }
        
        fout.printf("Closest pair: %d and %d with a distance of %.3f%n", numI, numJ, closest);
    }
    public static void farDist(double[][] distance, PrintWriter fout)
    {
        double farthest = 0;
        int numI = 0;
        int numJ = 0;
        for (int i = 0; i < distance.length; i++)
        {
            for (int j = 0; j < distance.length; j++)
            {
                if ((distance[i][j] > farthest) && (distance[i][j] != 0))
                {
                    farthest = distance[i][j];
                    numI = i;
                    numJ = j;
                }
            }
        }
        
        fout.printf("Farthest pair: %d and %d with a distance of %.3f%n", numI, numJ, farthest);
    }
}
