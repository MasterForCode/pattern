package signleton;

import java.lang.reflect.Constructor;

/**
 * @author wb
 * @date 2019/1/20.
 * 测试非枚举单例的反射漏洞
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Constructor<Demo1> constructor = (Constructor<Demo1>) Class.forName("signleton.Demo1").getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Demo1 d11 = constructor.newInstance();
        Demo1 d12 = constructor.newInstance();
        System.out.println(d11);
        System.out.println(d12);
    }
}