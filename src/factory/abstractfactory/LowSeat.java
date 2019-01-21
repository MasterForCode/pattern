package factory.abstractfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class LowSeat implements Seat {
    @Override
    public void massage() {
        System.out.println("不能按摩");
    }
}