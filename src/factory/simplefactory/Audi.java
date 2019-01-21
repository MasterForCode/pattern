package factory.simplefactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("奥迪在跑");
    }
}