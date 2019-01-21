package factory.methodfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}