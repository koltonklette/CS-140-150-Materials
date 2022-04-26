// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 2 - Objects, Selection, Looping
// 10-10-2018
public class Food
{
    private String type;
    private int units;
    private double price;
    private static int allFood;
    public Food()
    {
        type = "";
        units = 0;
        price = 0.0;
    }
    public Food(String dish, int amount, double price)
    {
        type = dish;
        units = amount;
        this.price = price;
        allFood = units;
    }
    public String getType()
    {
        return type;
    }
    public int getUnits()
    {
        return units;
    }
    public double getPrice()
    {
        return price;
    }
    public void subtractSoldUnits(int sold)
    {
        units = units - sold;
        allFood = allFood - sold;
    }
    public static int getRemainingFood()
    {
        return allFood;
    }
}