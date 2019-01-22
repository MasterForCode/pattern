package builder;

/**
 * @author wb
 * @date 2019/1/22
 */
public class Test {
    public static void main(String[] args) {
        AirShipDirector airShipDirector = new SzAirShipDirector(new SzAirShipBuilder());
        AirShip airShip = airShipDirector.directorAirShip();
        System.out.println(airShip.getEngine());
    }
}