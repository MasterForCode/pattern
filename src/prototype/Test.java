package prototype;

import java.util.Date;

/**
 * @author wb
 * @date 2019/1/22
 * 浅克隆
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
       // 浅克隆
        Date date = new Date(12546);
        Sheep sheep = new Sheep("张三", date);
        Sheep sheep1 = (Sheep) sheep.clone();

        System.out.println(sheep);
        System.out.println(sheep.getBirthday());
        System.out.println(sheep.getName());
        date.setTime(221111112);
        sheep1.setName("Doly");
        System.out.println(sheep1.getBirthday());
        System.out.println(sheep.getBirthday());



    }
}