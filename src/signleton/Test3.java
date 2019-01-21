package signleton;

import java.io.*;

/**
 * @author wb
 * @date 2019/1/20
 * 测试非枚举单例的反序列化漏洞
 */
public class Test3 {
    public static void main(String[] args) throws Exception{
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
    }
}