package factory.simplefactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class Byd implements Car {
    @Override
    public void run() {
        System.out.println("比亚迪在跑");
    }
}