package com.fan.objectCopyDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * java浅拷贝demo
 *
 * @author fan.wenqian
 * @date 2022/9/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Cloneable {
    private String name;

    /**
     * 重写Object类的clone()
     *
     * @return 强转成Address的Object对象
     */
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
