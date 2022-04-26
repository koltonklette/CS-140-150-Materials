// Kolton Klette
// Mrs. Tetzner
// CS 140 - 001
// Project 2 - Objects, Selection, Looping
// 09-27-2018
public class Test {
    public static void main( String[] args ) {
        Food nom = new Food();
        assert nom.getType().equals( "" ) : "standard constructor fail (type)";
        assert nom.getUnits() == 0 : "standard constructor fail (units)";
        assert nom.getPrice() - 0.0 < 0.0001 : "standard constructor fail (price)";
        assert Food.getRemainingFood() == 0 : "standard constructor fail (allFood)";
        
        Food nom2 = new Food( "chicken", 12, 3.5 );
        assert nom2.getType().equals( "chicken" ) : "second constructor fail (type)";
        assert nom2.getUnits() == 12 : "second constructor fail (units)";
        assert nom2.getPrice() - 3.5 < 0.0001 : "second constructor fail (price)";
        assert Food.getRemainingFood() == 12 : "second constructor fail (allFood)";
        
        nom2.subtractSoldUnits( 3 );
        assert nom2.getUnits() == 9 : "getUnits fail";
        assert Food.getRemainingFood() == 9 : "subtractSoldUnits fail";
        System.out.println( "All tests passed" );
    }
}
