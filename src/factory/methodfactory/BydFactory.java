package factory.methodfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}