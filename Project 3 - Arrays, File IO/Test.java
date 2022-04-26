public class Test {
    public static void main( String[] args ) {
        Train t_1 = new Train( "Pseudopolis", "Ankh-Morpork", 22, 30 );
        Train t_2 = new Train( "Ankh-Morpork", "Zlobenia", 9, 31 );
        assert t_1.getOrigin().equals( "Pseudopolis" ) : "standard constructor fail (origin)";
        assert t_2.getOrigin().equals( "Ankh-Morpork" ) : "standard constructor fail (origin)";
        assert t_1.getDestination().equals( "Ankh-Morpork" ) : "standard constructor fail (destination)";
        assert t_2.getDestination().equals( "Zlobenia" ) : "standard constructor fail (destination)";
        
        assert t_1.getDepartureHour() == 22 : "departure hour set fail";
        assert t_2.getDepartureHour() == 9 : "departure hour set fail";
        assert t_1.getDepartureMinute() == 30 : "departure minute set fail";
        assert t_2.getDepartureMinute() == 31 : "departure minute set fail";
        
        assert t_1.getArrivalHour() == 1 : "arrival hour set fail";
        assert t_2.getArrivalHour() == 16 : "arrival hour set fail";
        assert t_1.getArrivalMinute() == 25 : "arrival minute set fail";
        assert t_2.getArrivalMinute() == 57 : "arrival minute set fail";

        assert t_1.getTimeAtAMTrainStation().equals( "01:25" ) : "time at AM train station set fail";
        assert t_2.getTimeAtAMTrainStation().equals( "09:31" ) : "time at AM train station set fail";
       
        System.out.println( "All tests passed" );
    }
}
