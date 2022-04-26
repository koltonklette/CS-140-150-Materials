// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 1 - Objects, Inputs, Formatted Output
// 09-12-2018
public class Mail
{
    private String type;
    private String destination;
    private double postage;
    
    public Mail()
    {
        destination = "";
        postage = 0.0;
        type = "";
    }
    
    public void setDestination(String dest)
    {
        destination = dest;
    }
    
    public void setPostage(double stamps)
    {
        postage = stamps;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public double getPostage()
    {
        return postage;
    }
    
    public String getType()
    {
        return type;
    }
    
}