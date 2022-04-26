// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 2 - Objects, Selection, Looping
// 10-10-2018
import java.util.Scanner;
public class Project2 {
    //DO NOT ALTER THE MAIN METHOD
    public static void main( String[] args ) {
        if ( args.length == 0 ) {
            System.out.println( "Did you forget to paste the input values when you ran the main?" );
            System.exit( -1 );
        }
        else if ( args.length != 9 ) {
            System.out.println( "Did you paste all the input values when you ran the main?" );
            System.exit( -1 );
        }
        
        //create the 3 menu objects with command line arguments
        Food food_1 = new Food( args[ 0 ], Integer.parseInt( args[ 1 ] ), Double.parseDouble( args[ 2 ] ) );
        Food food_2 = new Food( args[ 3 ], Integer.parseInt( args[ 4 ] ), Double.parseDouble( args[ 5 ] ) );
        Food food_3 = new Food( args[ 6 ], Integer.parseInt( args[ 7 ] ), Double.parseDouble( args[ 8 ] ) );
        
        //call go and sell all food
        go( food_1, food_2, food_3 );
        
        //THESE ARE YOUR TEST CASES
        //{"rat on a stick", "13", "1.0", "mystery meat pie", "7", "1.8", "disturbingly live yoghurt", "5", "3.3"}
        //{"pie floater", "10", "3.8", "suspiciously fresh thousand-year eggs", "4", "2.5", "yak-butter tea", "15", "0.8"}
    }
    //DO NOT ALTER THE MAIN METHOD
    
    //Variable Declaration
    static int howMuch;
    static double revenue;
    static Scanner keyboard1 = new Scanner(System.in);
    
    /** go - method called from the main with the 3 Food objects currently on the menu
     *       this method keeps offering the menu until there is no more food to sell
     *       
     * @param food_1 - first Food object with values already set
     * @param food_2 - second Food object with values already set
     * @param food_3 - third Food object with values already set
     * 
     * @returns nothing
     */
    public static void go( Food food_1, Food food_2, Food food_3 ) 
    {
        while(food_1.getUnits() + food_2.getUnits() + food_3.getUnits() > 0)
        {
            System.out.printf("%n");
            printMenu(food_1, food_2, food_3);
        }
        
        System.out.printf("%n");
        howMuch = food_1.getUnits() + food_2.getUnits() + food_3.getUnits();
        System.out.printf("------------------%n");
        System.out.printf("Inventory%n");
        System.out.printf("--Remaining units of food - %d%n", howMuch);
        System.out.printf("--%d %s; %d %s; %d %s%n", food_1.getUnits(), food_1.getType(), food_2.getUnits(), food_2.getType(), food_3.getUnits(), food_3.getType());
        System.out.printf("--Revenue $%.2f%n", revenue);
        System.out.printf("------------------%n");
        System.out.printf("%nSorry, we are fresh out of everything. Goodbye.");
    }
    
    /** printMenu - prints the menu of 3 Food options. An item on the menu only gets an option number if there's still some of it left to sell, 
     *              otherwise, its line on the menu is replaced by a message that the establishment is out of it
     *       
     * @param f1 - first Food object with values already set
     * @param f2 - second Food object with values already set
     * @param f3 - third Food object with values already set
     * 
     * @returns nothing
     */
    public static void printMenu( Food f1, Food f2, Food f3 ) 
    {
        //Inventory Print
        howMuch = f1.getUnits() + f2.getUnits() + f3.getUnits();
        System.out.printf("------------------%n");
        System.out.printf("Inventory%n");
        System.out.printf("--Remaining units of food - %d%n", howMuch);
        System.out.printf("--%d %s; %d %s; %d %s%n", f1.getUnits(), f1.getType(), f2.getUnits(), f2.getType(), f3.getUnits(), f3.getType());
        System.out.printf("--Revenue $%.2f%n", revenue);
        System.out.printf("------------------%n");
        
        //Menu Print
        System.out.printf("%nOn the menu today we have: %n");
        if(f1.getUnits() > 0)
        {
            System.out.printf("\t(1) %s%n",f1.getType());
        }
        else
        {
            System.out.printf("\tWe're out of %s%n", f1.getType());
        }
        if(f2.getUnits() > 0)
        {
            System.out.printf("\t(2) %s%n",f2.getType());
        }
        else
        {
            System.out.printf("\tWe're out of %s%n", f2.getType());
        }
        if(f3.getUnits() > 0)
        {
            System.out.printf("\t(3) %s%n",f3.getType());
        }
        else
        {
            System.out.printf("\tWe're out of %s%n", f3.getType());
        }
        
        //Prompt User Print
        System.out.print("What would you like? ");
        switch(keyboard1.nextInt())
        {
            case 1:
            {
                if(f1.getUnits() <= 0)
                {
                    System.out.printf("Sorry, we ran out of %s. Try something else.%n",f1.getType());
                    break;
                }
                else
                {
                    System.out.print("How many do you want? ");
                    int quan = keyboard1.nextInt();
                    sell(f1, quan);
                    break;
                }
            }
            case 2:
            {
                if(f2.getUnits() <= 0)
                {
                    System.out.printf("Sorry, we ran out of %s. Try something else.%n",f2.getType());
                    break;
                }
                else
                {
                    System.out.print("How many do you want? ");
                    int quan = keyboard1.nextInt();
                    sell(f2, quan);
                    break;
                }
            }
            case 3:
            {
                if(f3.getUnits() <= 0)
                {
                    System.out.printf("Sorry, we ran out of %s. Try something else.%n",f3.getType());
                    break;
                }
                else
                {
                    System.out.print("How many do you want? ");
                    int quan = keyboard1.nextInt();
                    sell(f3, quan);
                    break;
                }
            }
            default:
            {
                System.out.printf("Please enter a valid choice.%n");
                break;
            }
        }
    }
    
    /** sell - sell a food item in certain quantity. Sell at most as many units of the food as you have available
     *       
     * @param f - Food to be sold
     * @param howMany - int for how many units of the food the buyer is requesting
     * 
     * @returns double - the money you made selling the food units
     */
    public static double sell( Food f, int howMany ) 
    {
        double money = 0.0;
        if(f.getUnits() > 0)
        {
            if(howMany <= f.getUnits())
            {
                money = f.getPrice() * howMany;
                f.subtractSoldUnits(howMany);
                System.out.printf("That would be $%.2f for %d %s. Enjoy!%n", money, howMany, f.getType());
            }
            else if(howMany > f.getUnits())
            {
                money = f.getPrice() * (f.getUnits());
                System.out.printf("I only have %d %s. That would be $%.2f. %n", f.getUnits(), f.getType(), money);
                f.subtractSoldUnits(f.getUnits());
            }
        }
        else
        {
            System.out.printf("Sorry, we are out of %s. Try something else.%n", f.getType());
        }
        revenue = revenue + money;
        return money;
    }
}
