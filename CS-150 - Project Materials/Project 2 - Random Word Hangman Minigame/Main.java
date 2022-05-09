/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author Kolton Klette
 */

//Kolton Klette
//Steven Klein
//CS-150-001
//March 1st, 2019
//Project 2 - Hangman

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
        
public class Main 
{   
    public static void main(String[] args) 
    {
        //Variable Declaration
        Scanner keyboard = new Scanner(System.in);
        String fileName = "dictionary.txt";
        ArrayList dictionary = new ArrayList(); //ArrayList import used to more easily add items from the file to the array
        String guessTrack = ""; //Used to keep track of the guesses made by user as the game progresses
            
        //Setting Up Dictionary Contents
        Scanner input = setInput(fileName); //sets up the input to read "dictionary.txt"
        dictionary = readDictionaryInfo(dictionary, input); // reads info from "dictionary.txt"
        
        //Start of Game
        System.out.printf("See if you can guess the word!%n");
        
        //Variable Declaration 2
        String secretWord = pickRandomWord(dictionary);
        String hiddenWord = WordHide.resetWordHide(secretWord);
        String guess = "";
        int missAmount = 5;
        
        //Game Progression Loop
        do 
        {
            do
            {
                System.out.printf("Word: %s   Guesses Left: %d Letters Guessed: %s%n", 
                                  hiddenWord, missAmount, guessTrack);
                System.out.printf("Enter your guess: ");
                guess = keyboard.next();
                guess = guess.toLowerCase();
                
                if (checkValidGuess(guessTrack, guess))
                {
                    guessTrack = addToGuesses(guessTrack, guess);
                    hiddenWord = WordHide.revealLetter(secretWord, hiddenWord, guess);
                    if(!hiddenWord.contains(guess))
                    {
                        System.out.printf("Miss!%n");
                        missAmount--;
                    }
                }
                else
                {
                    guessTrack = addToGuesses(guessTrack, guess);
                    System.out.printf("Miss!%n");
                    missAmount--;
                }
                
            } while((!hiddenWord.equals(secretWord)) && (missAmount > 0));
            
            //End Result Control
            if(missAmount == 0)
            {
                System.out.printf("Oh no! The word was: %s%n", secretWord);
            }
            else if (hiddenWord.equals(secretWord))
            {
                System.out.printf("Word: %s   Guesses Left: %d%n", hiddenWord, missAmount);
                System.out.printf("Yay! You got it!%n");
            }
            
            System.out.printf("Game over! Let's play again!%n");
            
            //Re-Declaration to Deliberately Loop Program
            secretWord = pickRandomWord(dictionary);
            hiddenWord = WordHide.resetWordHide(secretWord);
            guess = "";
            guessTrack = "";
            missAmount = 5;
         
            System.out.printf("See if you can guess the word!%n");
            
        } while (missAmount == 5);
    }
    
    public static Scanner setInput (String fileName)
    {
        Scanner input = null;
        try
        {
            File fin = new File(fileName);
            input = new Scanner (fin);
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("File not found: " + fileName);
            System.exit(1);
        }
        
        return input;
    }
    
    public static ArrayList readDictionaryInfo (ArrayList dictionary, Scanner input)
    {
        while(input.hasNext())
        {
            dictionary.add(input.nextLine());
        }
        
        /*Loop will continue to add however many words are contained within "dictionary.txt", then 
        size can be referenced later via ".size()" command.*/
        
        /* 'input.nextLine()' is used to get the entire String read into one element of the ArrayList object. */
        
        return dictionary;
    }
    
    public static String pickRandomWord (ArrayList dictionary)
    {
        //Defining the Range of the Random Number
        int max = dictionary.size();
        int min = 0;
        int range = max - min + 1;
        int randInt = (int)(Math.random() * range) - min;
        
        //Using Generated Random Number To Pick A Word From The Array        
        return dictionary.get(randInt).toString();
    }
    
    public static String addToGuesses(String guessTrack, String guess)
    {
        guessTrack += guess;
        
        return guessTrack;
    }
    
    public static boolean checkValidGuess(String guessTrack, String guess)
    {
        if ((guess.length() > 1) || (guessTrack.contains(guess)))        
        {
            return false;
        }
        return true;
    }
}