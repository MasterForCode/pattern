package factory.abstractfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class LuxurySeat implements Seat {
    @Override
    public void massage() {
        System.out.println("能按摩");
    }
}