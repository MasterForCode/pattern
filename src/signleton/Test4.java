package signleton;

import java.util.concurrent.CountDownLatch;

/**
 * @author wb
 * @date 2019/1/20
 * 测试单例的性能
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int threadCount = 10;
        // 线程计数器
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
//                    Demo1 demo1 = Demo1.getInstance();
//                    Demo2 demo2 = Demo2.getInstance();
//                    Demo3 demo3 = Demo3.getInstance();
                    Demo4 demo4 = Demo4.getInstance();
//                    Demo5 demo5 = Demo5.INSTANCE;
                }
                // 每个线程执行完，线程计数器减去1
                countDownLatch.countDown();
            }).start();
        }
        // 等待线程计数器值为0
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}