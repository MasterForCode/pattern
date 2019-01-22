package prototype;

import java.util.Date;

/**
 * @author wb
 * @date 2019/1/22
 * 深克隆
 */
public class Sheep2 implements Cloneable{
    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sheep2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 浅复制
        Object obj = super.clone();
        // 添加如下代码深复制
        Sheep2 sheep = (Sheep2)obj;
        sheep.birthday = (Date) this.birthday.clone();
        return obj;
    }
}