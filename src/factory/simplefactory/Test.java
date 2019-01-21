package factory.simplefactory;

/**
 * @author wb
 * @date 2019/1/21
 * 无工厂操作
 */
public class Test {
    public static void main(String[] args){
     Car c1 = new Audi();
     Car c2 = new Byd();
     c1.run();
     c2.run();
    }
}