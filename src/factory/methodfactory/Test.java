package factory.methodfactory;

/**
 * @author wb
 * @date 2019/1/21
 */
public class Test {
    public static void main(String[] args){
     Car c1 = new AudiFactory().createCar();
     Car c2 = new BydFactory().createCar();
     c1.run();
     c2.run();
    }
}