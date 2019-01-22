package prototype;

import java.util.Date;

/**
 * @author wb
 * @date 2019/1/22
 */
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 深克隆
        Date date = new Date(12546);
        Sheep2 sheep2 = new Sheep2("张三", date);
        Sheep2 sheep3 = (Sheep2) sheep2.clone();

        System.out.println(sheep2);
        System.out.println(sheep2.getBirthday());
        System.out.println(sheep2.getName());
        date.setTime(221111112);
        sheep2.setName("Doly");
        System.out.println(sheep3.getBirthday());
        System.out.println(sheep2.getBirthday());
    }
}