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

public class WordHide 
{
    private static final String HIDE_CHAR = "*";
    //String partiallyFoundWord = "";
    private String secretWord = "";
    private String hiddenWord = "";

    /*public String getPartiallyFoundWord() 
    {
        return partiallyFoundWord;
    }*/

    public String getSecretWord() 
    {
        return secretWord;
    }
    
    public String getHiddenWord()
    {
        return hiddenWord;
    }
    
    public void setSecretWord(String newWord)
    {
        secretWord = newWord;
    }
    
    public static boolean secretWordFound(String hiddenWord, String secretWord)
    {
        return hiddenWord.equals(secretWord);
    }
    
    public static String resetWordHide(String secretWord)
    {
        String hiddenWord = "";
        for (int i = 0; i < secretWord.length(); i++) 
        {
            hiddenWord += HIDE_CHAR;
        }
        return hiddenWord;
    }
    
    public static String revealLetter(String secretWord, String hiddenWord, String guess)
    {
        if (secretWord.contains(guess)) 
        {
            for (int i = 0; i < secretWord.length(); i++) 
            {
                if (guess.charAt(0) == secretWord.charAt(i)) 
                {
                    if(i == 0)
                    {
                        hiddenWord = secretWord.charAt(i) + hiddenWord.substring(i+1);
                    }
                    else
                    {
                        hiddenWord = hiddenWord.substring(0, i) + secretWord.charAt(i) + hiddenWord.substring(i+1);
                    }
                }
            }
        }
        else
        {
            return hiddenWord;
        }
                
        return hiddenWord;
    }

}