package factory.abstractfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class LuxuryEngine implements Engine {
    @Override
    public void run() {
          System.out.println("转的快");
    }

    @Override
    public void start() {
System.out.println("启动快");
    }
}