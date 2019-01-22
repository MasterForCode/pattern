package prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author wb
 * @date 2019/1/22
 * 利用序列化和反序列化实现深克隆
 */
public class Test3 {
    public static void main(String[] args) throws Exception{
        Date date = new Date(12546);
        Sheep sheep = new Sheep("张三", date);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(sheep);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep sheep1 = (Sheep)ois.readObject();


        System.out.println(sheep);
        System.out.println(sheep.getBirthday());
        System.out.println(sheep.getName());
        date.setTime(221111112);
        sheep1.setName("Doly");
        System.out.println(sheep1.getBirthday());
        System.out.println(sheep.getBirthday());


    }
}