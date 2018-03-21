package com.xugc.demo.ref;

import com.xugc.demo.domain.Person;

import java.lang.ref.WeakReference;

/**
 * @Author: xuguocheng
 * @Desc :
 * @Date : 2018-03-16 11:22
 */
public class WeakReferenceTest {

    public static void main(String[] args) {

        Person person = new Person(1, "张三");
        WeakReference<Person> weakPerson = new WeakReference<Person>(person);
        int i = 0;
        while (true) {
            if (weakPerson.get() != null) {
                i++;
                System.out.println("Object is active for " + i + " loops - " + weakPerson);
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
    }
}
