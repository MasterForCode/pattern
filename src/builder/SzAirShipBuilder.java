package builder;

/**
 * @author wb
 * @date 2019/1/22
 */
public class SzAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine buildEngine() {
        System.out.println("构建神州牌发动机");
        return new Engine("神州");
    }

    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("构建神州牌轨道仓");
        return new OrbitalModule("神州");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("构建神州牌逃逸塔");
        return new EscapeTower("神州");
    }
}