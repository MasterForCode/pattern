package prototype;

/**
 * @author wb
 * @date 2019/1/22
 * 性能测试
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        long date1 = System.currentTimeMillis();
        noClone();
        long date2 = System.currentTimeMillis();
        System.out.println(date2 - date1);
        useClone();
        long date3 = System.currentTimeMillis();
        System.out.println(date3 - date2);
    }

    private static void useClone() throws CloneNotSupportedException, InterruptedException {
        Laptop laptop = new Laptop();
        for (int i = 0; i < 999; i++) {
            Laptop laptop1 = (Laptop) laptop.clone();
        }
    }

    private static void noClone() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Laptop laptop = new Laptop();
        }
    }
}