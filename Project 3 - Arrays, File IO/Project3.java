// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 3 - Arrays, File I/O
// 11-7-2018
import java.util.Scanner;
import java.io.File;
import java. io.FileNotFoundException;
public class Project3
{
    private static final int MAX_SIZE = 50;
    public static void main (String [] args)
    {
        String fileName = "trains.txt";
        Train [] chooChoo = new Train [MAX_SIZE];
        int chooObj = 0;
        try
        {
            Scanner input = new Scanner(new File(fileName));
            
        }
        catch (FileNotFoundException ex)
        {
            System.err.print("File not found: " + fileName);
            System.exit(1);
        }
        while (input.hasNext())
            {
                for(int i = 0; i < chooChoo.length; i++)
                {
                   chooChoo[i] = new Train(input.next(), input.next(), input.nextInt(), input.nextInt());
                   ++chooObj;
                }
            }
    }
    
    //public static void sort?
}
