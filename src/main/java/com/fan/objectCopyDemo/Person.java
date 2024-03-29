package com.fan.objectCopyDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * java浅拷贝demo - 程序入口
 *
 * @author fan.wenqian
 * @date 2022/9/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {

    private Address address;

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            // 需要子类也重写Object的clone方法，如果没有重写，默认使用Object的clone()
            person.setAddress(person.getAddress().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
        //输出结果为 false, 也就是说person1对象和person1Copy对象内部的address对象不是同一个对象实例
        System.out.println(person1.getAddress() == person1Copy.getAddress());
    }
}
