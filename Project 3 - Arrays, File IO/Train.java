// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 3 - Arrays, File I/O
// 11-7-2018
public class Train
{
    private String origin;
    private String destination;
    private int departureHour;
    private int departureMinute;
    private int arrivalHour;
    private int arrivalMinute;
    private String timeAtAMTrainStation;
    
    public Train()
    {
        
    }
    
    public Train(String origin, String destination, int hour, int minute)
    {
        this.origin = origin;
        this.destination = destination;
        departureHour = hour;
        departureMinute = minute;
        calculateTimes(origin, destination, hour, minute);
        String timeAtAMTrainStation = "XX:XX";
    }
    
    public String getOrigin()
    {
        return origin;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public int getDepartureHour()
    {
        return departureHour;
    }
    
    public int getDepartureMinute()
    {
        return departureMinute;
    }
    
    public int getArrivalHour()
    {
        return arrivalHour;
    }
    
    public int getArrivalMinute()
    {
        return arrivalMinute;
    }
    
    public String getTimeAtAMTrainStation()
    {
        if(origin.equals("Ankh-Morpork"))
        {
            return String.format("%02d:%02d", departureHour, departureMinute);
        }
        else
        {
            return String.format("%02d:%02d", arrivalHour, arrivalMinute);
        }
    }
    
    public void calculateTimes(String origin, String destination, int hour, int minute)
    {
        int durationHour = 0;
        int durationMinute = 0;
        arrivalHour = 0;
        arrivalMinute = 0;
        String tempCity;
        
        if(origin.equals("Ankh-Morpork"))
        {
            tempCity = destination;
        }
        else
        {
            tempCity = origin;
        }
         
        // USE A SWITCH STATEMENT
        switch(tempCity)
        {
            case "Borogravia":
                {
                    durationHour = 6;
                    durationMinute = 14; 
                    break;
                }
            case "Genua":
                {
                    durationHour = 9;
                    durationMinute = 12;
                    break;
                }
            case "Klatch":
                {
                    durationHour = 7;
                    durationMinute = 2;
                    break;
                }
            case "Lancre":
                {
                    durationHour = 4;
                    durationMinute = 35;
                    break;
                }
            case "Pseudopolis":
                {
                    durationHour = 2;
                    durationMinute = 55;
                    break;
                }
            case "Quirm":
                {
                    durationHour = 1;
                    durationMinute = 50;
                    break;
                }
            case "StoLat":
                {
                    durationHour = 1;
                    durationMinute = 45;
                    break;
                }
            case "StoPlains":
                {
                    durationHour = 2;
                    durationMinute = 3;
                    break;
                }
            case "Ueberwald":
                {
                    durationHour = 5;
                    durationMinute = 52;
                    break;
                }
            case "Zlobenia":
                {
                    durationHour = 7;
                    durationMinute = 26;
                    break;
                }
        }
        
        arrivalHour = hour + durationHour;
        arrivalMinute = minute + durationMinute;
        
        //Convert hours to minutes, then increment hours accordingly?
        //Modulus useage?
        if(arrivalHour >= 24)
        {
            arrivalHour = arrivalHour % 24;
        }
        
        if(arrivalMinute >= 60)
        {
            arrivalMinute = arrivalMinute - 60;
            ++arrivalHour;
        }
    }
}