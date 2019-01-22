package builder;

/**
 * @author wb
 * @date 2019/1/22
 */
public class SzAirShipDirector implements AirShipDirector {
    private AirShipBuilder airShipBuilder;

    public SzAirShipDirector(AirShipBuilder airShipBuilder) {
        this.airShipBuilder = airShipBuilder;
    }

    @Override
    public AirShip directorAirShip() {
        Engine engine = this.airShipBuilder.buildEngine();
        EscapeTower escapeTower = this.airShipBuilder.buildEscapeTower();
        OrbitalModule orbitalModule = this.airShipBuilder.buildOrbitalModule();

        AirShip airShip = new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);
        return airShip;
    }
}