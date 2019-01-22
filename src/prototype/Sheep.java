package prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wb
 * @date 2019/1/22
 * 浅克隆
 */
public class Sheep implements Cloneable, Serializable {
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

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 浅复制
        Object obj = super.clone();
        return obj;
    }
}