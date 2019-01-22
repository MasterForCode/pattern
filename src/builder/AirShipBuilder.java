package builder;

/**
 * @author wb
 * @date 2019/1/22
 */
public interface AirShipBuilder {
    Engine buildEngine();
    OrbitalModule buildOrbitalModule();
    EscapeTower buildEscapeTower();
}