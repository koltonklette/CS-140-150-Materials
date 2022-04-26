// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 1 - Objects, Inputs, Formatted Output
// 09-12-2018
import java.util.Scanner;
import java.util.Date;
public class Project1 {
    public static void main ( String[] args ) {
        System.out.println( "Welcome to the Ankh-Morpork Post Office!" );
        
        //1. declare a scanner object to read from the keyboard - make sure to import the class needed
        Scanner keyboard = new Scanner(System.in);
        
        //2. ask the user what (s)he's shipping today - see output on handout for formatting
        System.out.print("Are you shipping a letter or a package?     ");
       
        String typeOfMail;       
        //3. read the input in the typeOfMail variable 
        typeOfMail = keyboard.next();
        
        //4. trim the typeOfMail of leading and trailing spaces - see output on handout for information
        typeOfMail = typeOfMail.trim();
        
        //5. make typeOfMail all lower case letters - see output on handout for information
        typeOfMail = typeOfMail.toLowerCase();
        
        
        //this is logic that says "if you're not shipping a letter 
        //or a package, terminate the program with a message
        //and an error code of -1" 
        if ( !typeOfMail.equals( "package" ) && !typeOfMail.equals( "letter" ) ){ 
            System.out.println( "We don't ship " + typeOfMail + ". Goodbye." );
            System.exit( -1 );
        }
        
        //6. create a Mail object with the standard constructor
        Mail mail1 = new Mail();
        
        //7. set type of mail instance variable in the mail object
        mail1.setType(typeOfMail);
        
        //this code prompts the user for destination input
        //reads the input and checks it for validity, then gives it back to you
        //when the line executes, the destination variable will hold the 
        //string value of what you input for destination
        String destination = chooseDestination( keyboard );
            
        //8. set the destination instance variable in the mail object
        mail1.setDestination(destination);
            
        //this code calculates postage for you given the type of mail and destination
        //when the lione executes, the postage variable will hold the price of mail
        //the price doesn't uinclude tax
        double postage = calculatePostage( typeOfMail, destination );
            
        //9. set the postage instance variable in the mail object
        mail1.setPostage(postage);
               
        //10. print formatted receipt - see output on handout for formatting
        Date now = new Date();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Date: " + now);
        System.out.println();
        System.out.println("PRODUCT                           DESTINATION     PRICE WITH TAX     ");
        System.out.printf("%-34s%-16s$%.2f%n", typeOfMail, destination, postage * 1.06);
        System.out.println();
        System.out.println("Thank you for using the Ankh-Morpork Post Office!");
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }
    
    /* do not change this method!
     * 
     * chooseDestination - this method checks for a valid destination
     * 
     * @param Scanner kbrd - stream to read from keyboard
     * @return String - the destination of the cargo with the correct format
     */
    private static String chooseDestination( Scanner kbrd ) {
        System.out.print( "Enter the destination: " );
        String dest = kbrd.next();
        
        switch ( dest.trim().toLowerCase() ) {
            case "ankh-morpork":
                return "Ankh-Morpork";
            case "pseudopolis":
                return "Pseudopolis";
            case "ueberwald":
                return "Ueberwald";    
            default:
                System.out.println( "We don't ship to " +  dest + ". Goodbye." );
                System.exit( -2 );     
        }
        
        return "";
    }
    
    /* do not change this method!
     * 
     * calculatePostage - this method calculates postage given the type and 
     *                    detination of the cargo
     * 
     * @param String type - the type of cargo
     * @param String dest - the destination
     * @return double - the price of cargo (without tax)
     */
    private static double calculatePostage( String type, String dest ) {        
        if ( dest.trim().equalsIgnoreCase( "Ankh-Morpork" ) && type.trim().equalsIgnoreCase( "letter" ) )
            return 1.50;
        else if ( dest.trim().equalsIgnoreCase( "Ankh-Morpork" ) && type.trim().equalsIgnoreCase( "package" ) )
            return 12.85;
        else if ( dest.trim().equalsIgnoreCase( "Pseudopolis" ) && type.trim().equalsIgnoreCase( "letter" ) )            
            return 13.12;
        else if ( dest.trim().equalsIgnoreCase( "Pseudopolis" ) && type.trim().equalsIgnoreCase( "package" ) )        
            return 40.20;
        else if ( dest.trim().equalsIgnoreCase( "Ueberwald" ) && type.trim().equalsIgnoreCase( "letter" ) )
            return 50.00;
        else if ( dest.trim().equalsIgnoreCase( "Ueberwald" ) && type.trim().equalsIgnoreCase( "package" ) )
            return 151.23;
        else{
            System.out.println( "Something went wrong. Panic!" );
            System.exit( -3 );     
        }
        
        return -1;
    }
}

