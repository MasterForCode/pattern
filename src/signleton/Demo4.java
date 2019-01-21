package signleton;

/**
 * @author wb
 * @date 2019/1/20.
 * 静态内部类
 */
public class Demo4 {
    private Demo4() {
    }

    public static Demo4 getInstance() {
        return Demo4Instance.instance;
    }

    private static class Demo4Instance {
        private static final Demo4 instance = new Demo4();

    }
}