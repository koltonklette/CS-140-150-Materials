/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4.pkg1;

//Kolton Klette
//Steven Klein
//CS 150-001
//May 3rd, 2019
//Project 4 - File Merging

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayHandling 
{
    private Scanner input;
    private String fileName;
    private int[][] allInput; //Contains the values of all of the inputs after they have all been read.
    private int[] tempInput; //Temporarily contains an element of allInput, and is reinstantiated per file input that is read.
    private int[] mergedInput; //Contains the same information as allInput, but with sequentially sorted information.
    private int MAX_SIZE = 10; //Maximum amount of input files used is equal to 10 ([0,9], inclusive).
    private int MAX_VALUE = 100; //Maximum value of integer that can be read from the file, used for merging purposes.
    
    
    public ArrayHandling()
    {
        tempInput = null;
        allInput = new int[MAX_SIZE][];
        /*
            The following loop handles each set of input values by incrementing inputCount to equal the current file being read in.
            For example, for the first iteration of the loop, the file being read equals "input0.txt", and every iteration of the
            while loop increments the number in that file name while inputCount less than ten.
        */
        int inputCount = 0;
        while (inputCount < MAX_SIZE) 
        {
            fileName = "input" + inputCount + ".txt";
            input = setInput(fileName);
            tempInput = fillTempInput(input, tempInput);
            allInput[inputCount] = tempInput;
            inputCount++;
        }
    }
    
    public Scanner setInput (String fileName)
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
    
    public int[] fillTempInput(Scanner input, int[] tempInput)
    {
        int tempSize = input.nextInt(); //Determines size of array being put into allInput by reading the first number in the input file.
        tempInput = new int[tempSize];
        for (int i = 0; i < tempSize; i++) 
        {
            tempInput[i] = input.nextInt();
        }
        
        return tempInput;
    }
    
    //Printing Based Methods
    public void printAllInput()
    {
        for (int i = 0; i < MAX_SIZE; i++)
        {
            printAllInputElements(allInput[i]);
        }
        
    }
    
    public void printAllInputElements(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.printf("%3d", array[i]);
        }
        System.out.printf("%n");
    }
    
    public void printMergedInput()
    {
        int lineCheck = 0;
        for (int i = 0; i < mergedInput.length; i++) 
        {
            System.out.printf("%3d", mergedInput[i]);
            lineCheck++;
            if(lineCheck == 20) //Used in order to format single array properly; every twenty terms will be followed by a new line.
            {
                System.out.printf("%n");
                lineCheck = 0;
            }
        }
        System.out.printf("%n");
    }
    
    public void printFrequencies()
    {
        //Variable Declaration
        int column = 0;
        
        //Frequency Print-Out Table
        System.out.printf("      %-3d%-3d%-3d%-3d%-3d%-3d%-3d%-3d%-3d%-3d%n", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.printf("------------------------------------%n");
        while(column < 100)
        {
            System.out.printf("%-3d|%3d%3d%3d%3d%3d%3d%3d%3d%3d%3d%n", column, 
                                                                       frequencyCount(mergedInput, 0, column), 
                                                                       frequencyCount(mergedInput, 1, column), 
                                                                       frequencyCount(mergedInput, 2, column), 
                                                                       frequencyCount(mergedInput, 3, column), 
                                                                       frequencyCount(mergedInput, 4, column), 
                                                                       frequencyCount(mergedInput, 5, column), 
                                                                       frequencyCount(mergedInput, 6, column), 
                                                                       frequencyCount(mergedInput, 7, column), 
                                                                       frequencyCount(mergedInput, 8, column), 
                                                                       frequencyCount(mergedInput, 9, column));
            column += 10;
        }       
        System.out.printf("------------------------------------%n");
    }
    
    //Sorting Based Methods
    public void sortAllInput()
    {
        for (int i = 0; i < MAX_SIZE; i++) 
        {
            sortByBubbleSort(allInput[i]);
        }
    }
    
    /*
        The following bubble sort was inspired after the bubble sort provided at the following website; https://www.geeksforgeeks.org/bubble-sort/
        As the name of the method indicates, the information in the array allInput is sorted by the use of a Bubble Sort algorithim.
    */
    public int[] sortByBubbleSort(int[] array)
    {
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array.length - i - 1; j++) 
            {
                if(array[j] > array[j+1])  
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        
        return array;
    }
    
    //Merge-Handling Methods
    public void mergeFromAllInput()
    {
        //Variable Declaration
        int mergeSize = 0;
        SmallestInfo smallest = new SmallestInfo(); //Keeps track of the smallest value found within allInput to be placed in the array, mergedInput
        
        //Adds the sizes of each element to be used for the size of array mergedInput, then re-declares mergedInput.
        for (int i = 0; i < MAX_SIZE; i++) 
        {
            mergeSize += allInput[i].length;
        }
        mergedInput = new int[mergeSize];
        
        //Merge Information Handling
        for (int i = 0; i < mergeSize; i++) 
        {
            //mergeInput Insertion Handling
            smallest = findSmallestValue(allInput, smallest);
            mergedInput[i] = smallest.getValue();
            allInput[smallest.getRowLocation()][smallest.getColumnLocation()] = MAX_VALUE; //"Removed" values are re-assigned arbitrary values
            
            //Resetting SmallestInfo Object
            smallest.setValue(MAX_VALUE);
            smallest.setRowLocation(0);
            smallest.setColumnLocation(0);
        }
    }
    
    public SmallestInfo findSmallestValue(int [][] array, SmallestInfo smallest)
    {
        //Variable Declaration
        int comparison = MAX_VALUE;
        
        //Smallest Value Search
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array[i].length; j++) 
            {
                if(comparison > array[i][j])
                {
                    comparison = array[i][j];
                    smallest.setValue(array[i][j]); //Saves the actual value of the smallest number that is found.
                    smallest.setRowLocation(i); //Saves the row of allInput where this value was found.
                    smallest.setColumnLocation(j); //Saves the column of allInput where this value was found.
                }
            }
        }

        return smallest;
    }
    
    //Frequency-Handling Methods
    public int frequencyCount(int [] mergedInput, int ones, int tens)
    {
        //Variable Declaration
        int frequency = 0;
        
        //Frequency Handling
        for (int i = 0; i < mergedInput.length; i++) 
        {
            if(mergedInput[i] == (ones + tens))
            {
                frequency++;
            }
        }
        return frequency;
    }
}
