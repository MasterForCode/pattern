package prototype;

/**
 * @author wb
 * @date 2019/1/22
 */
public class Laptop implements Cloneable{
    public Laptop() throws InterruptedException {
       // 模拟创建对象的时间
        Thread.sleep(1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}