package factory.abstractfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class Test {
    public static void main(String[] args){
     CarFactory factory= new LowCarFactory();
     Engine engine = factory.createEngine();
     engine.run();
     engine.start();
    }
}