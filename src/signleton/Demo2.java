package signleton;

/**
 * @author wb
 * @date 2019/1/20.
 * 懒汉式
 */
public class Demo2 {
    private static Demo2 instance;

    private Demo2() {
    }

    public static synchronized Demo2 getInstance() {
        if (instance == null) {
            instance = new Demo2();
        }
        return instance;
    }
}