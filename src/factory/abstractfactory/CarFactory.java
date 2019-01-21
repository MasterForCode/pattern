package factory.abstractfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public interface CarFactory {
    Engine createEngine();

    Seat createSeat();

    Tyre createTyre();
}