package signleton;

/**
 * @author wb
 * @date 2019/1/20.
 * 双重检测锁
 */
public class Demo3 {
    private static Demo3 instance = null;

    private Demo3() {
    }

    public static Demo3 getInstance() {
        if (instance == null) {
            Demo3 i;
            synchronized (Demo3.class) {
                i = instance;
                if (i == null) {
                    synchronized (Demo3.class) {
                        if (i == null) {
                            i = new Demo3();
                        }
                    }
                }
                i = instance;
            }
        }
        return instance;
    }
}