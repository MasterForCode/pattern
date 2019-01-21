package signleton;

import java.lang.reflect.InvocationTargetException;

/**
 * @author wb
 * @date 2019/1/20.
 * 测试单例
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Demo1 d1 = Demo1.getInstance();
        Demo1 d2 = Demo1.getInstance();

        Demo2 d3 = Demo2.getInstance();
        Demo2 d4 = Demo2.getInstance();

        Demo3 d5 = Demo3.getInstance();
        Demo3 d6 = Demo3.getInstance();

        Demo4 d7 = Demo4.getInstance();
        Demo4 d8 = Demo4.getInstance();

        Demo5 d9 = Demo5.INSTANCE;
        Demo5 d10 = Demo5.INSTANCE;

        System.out.println(d1 == d2);
        System.out.println(d3 == d4);
        System.out.println(d5 == d6);
        System.out.println(d7 == d8);
        System.out.println(d9 == d10);

    }
}