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
public class Main 
{
    
    public static void main(String[] args) 
    {
        //Information Set-Up
        ArrayHandling numbers = new ArrayHandling();
        
        //Information Print-Out
        preSortedHandling(numbers);
        sortedHandling(numbers);
        mergedAndSortedHandling(numbers);
        frequencyHandling(numbers);
    }
    
    public static void preSortedHandling(ArrayHandling numbers)
    {
        System.out.println("Pre-Sorted Lists:");
        numbers.printAllInput();
        System.out.println("");
    }
    
    public static void sortedHandling(ArrayHandling numbers)
    {
        System.out.println("Sorted Lists:");
        numbers.sortAllInput();
        numbers.printAllInput();
        System.out.println("");
    }
    
    public static void mergedAndSortedHandling(ArrayHandling numbers)
    {
        System.out.println("Merged And Sorted List:");
        numbers.mergeFromAllInput();
        numbers.printMergedInput();
        System.out.println("");
    }
    
    public static void frequencyHandling(ArrayHandling numbers)
    {
        System.out.println("Frequency Counts:");
        numbers.printFrequencies();
    }
    
}
