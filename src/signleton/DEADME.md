---
title: 单例模式
tags: 设计模式
---


1. 核心作用
   > 保证一个类只有一个实例，并且提供一个访问该实例的全局访问点
   
2. 应用场景
   > windows的任务管理器
   > windows的回收站
   > 网站的计数器
   > 日志管理
   > 数据库连接池
   > 文件系统
   
3. 优点
   > 由于单例模式只生成一个实例，**减小系统性能开销**，当一个对象的生产需要比较多的资源时，如读取配置文件，产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留的方式解决
   > 单例模式可以在系统设置全局的访问点，**优化环境资源访问**，例如可以设计一个单例类，负责所有数据表的映射

4. 常见的实现方式
   > 主要
   > * 饿汉式（线程安全，调用率高，但是不能延迟加载）
   > * 懒汉式（线程安全，调用率不高，但是可以延时加载）
   > 其他
   > * 双串检测锁式（由于JVM底层内部模型原因，偶尔会出问题，不建议使用）
   > * 静态内部类式（线程安全，调用率高，但是可以延迟加载）
   > * 枚举单利（线程安全，调用率高，不能延时加载 ）
   
5. 实现
  > 构造函数私有化
  > 提供公有方法获取实例
```java
// 饿汉式
public class Demo1 {
// 类初始化时立即加载这个对象（没有延时加载），加载类时天然线程安全
    private static Demo1 instance = new Demo1();

    private Demo1() {

    }
// 方法没有同步块，调用效率高
    public static Demo1 getInstance() {
        return instance;
    }
}

// 懒汉式
public class Demo2 {
// 延时加载，资源利用率高
    private static Demo2 instance;

    private Demo2() {
    }
// 原始懒汉式是非线程安全的，此处使用同步方法，实现线程安全，但会导致调用效率低
    public static synchronized Demo2 getInstance() {
        if (instance == null) {
            instance = new Demo2();
        }
        return instance;
    }
}

// 双重检测锁模式，将同步内容下放到if内部，提高了执行效率，不必每次获取对象时都进行同步，只有在第一次才同步，创建了以后就没必要了，但是由于编译器优化原因和JVM底层内部模型原因（同步块执行的顺序可能被调整），偶尔会出错，不建议使用
public class Demo3 {
    private static Demo3 instance = null;

    private Demo3() {
    }

    private static Demo3 getInstance() {
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

// 静态内部类，没有static属性实现了延时加载，只有调用了getInstance()才会加载静态内部类。加载类时是线程安全的。instance是static final类型，保证了内存中只有一个实例存在，而且只能被赋值一次，从而保证了线程安全。该实现方法兼备了并发高效调用和延时加载优势
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

// 枚举单例，实现简单，枚举本身就是单例模式。由于JVM从根本上提供保障，避免通过反射和反序列化漏洞创建新对象，但无法延时加载
public enum Demo5 {
    /**
     * 单例的实例
     */
    INSTANCE;

    public void singletonOperation() {
        // do  something....
    }
}
```
6. 如何选用
   >  单例对象占用资源少不需要延时加载：枚举好于饿汉式
   >  单例对象占用资源大需要延时加载：静态内部类好于懒汉式   

7. 非枚举方式的破解
   > 通过反射破解
   ```java
   // 通过反射调用私有构造器破解
   Constructor<Demo1> constructor = (Constructor<Demo1>) Class.forName("Demo1").getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Demo1 d11 = constructor.newInstance();
        Demo1 d12 = constructor.newInstance();
        System.out.println(d11);
        System.out.println(d12);
	// 解决：在构造器中添加以下机制，禁止通过反射创建新的对象‘’。
	 if (instance != null) {
            throw new RuntimeException();
        }
		
	// 通过反序列化破解（被破解对象要实现了序列化）
	  FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Demo1 d13 = null;
        try {
            // 序列化
            fos = new FileOutputStream("d:/a.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(Demo1.getInstance());

            // 反序列化
            fis = new FileInputStream("d:/a.txt");
            ois = new ObjectInputStream(fis);
            d13 = (Demo1) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Demo1.getInstance());
            System.out.println(d13);
        }
	// 解决，在被序列化的对象的类中添加如下方法，如果定义了该方法则反序列化时直接返回此方法指定的对象，而不是创建新的对象
	 private Object readResolve() {
        return instance;
    }
   ```