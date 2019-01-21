package factory.simplefactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class CarFactory {
    public static Car createCar(Class clz) {
        if (clz.equals(Audi.class)) {
            return new Audi();
        }
        if (clz.equals(Byd.class)) {
            return new Byd();
        }
        return null;
    }
}