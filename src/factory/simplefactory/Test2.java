package factory.simplefactory;

/**
 * @author wb
 * @date 2019/1/21
 * 有工厂操作
 */
public class Test2 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createCar(Audi.class);
        Car c2 = CarFactory.createCar(Byd.class);
        c1.run();
        c2.run();
    }
}