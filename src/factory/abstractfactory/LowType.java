package factory.abstractfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class LowType implements Tyre {
    @Override
    public void revolve() {
        System.out.println("磨损快");
    }
}