package signleton;

import java.io.Serializable;

/**
 * @author wb
 * @date 2019/1/20.
 * 饿汉式
 */
public class Demo1 implements Serializable {
    private static Demo1 instance = new Demo1();

    private Demo1() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    public static Demo1 getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}