package com.xugc.demo.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.xugc.demo.xstream.domain.Person;
import com.xugc.demo.xstream.domain.PhoneNumber;

public class XStreamDemo {

    public static void main(String[] args) {

        PhoneNumber phoneNumber1 = new PhoneNumber(123, "1234567");
        PhoneNumber phoneNumber2 = new PhoneNumber(456, "9999-9999");

        Person person = new Person();
        person.setFirstName("张");
        person.setLastName("三");
        person.setPhone(phoneNumber1);
        person.setFax(phoneNumber1);
        person.setX_y("x_y");

        XStream xStream = new XStream(new Xpp3Driver());
        //xStream.setMode(XStream.NO_REFERENCES);
        xStream.alias("person", Person.class);
        xStream.alias("phoneNumber", PhoneNumber.class);
        xStream.aliasField("xy",Person.class,"x_y");

        String xml = xStream.toXML(person);
        System.out.println(xml);
        Person person1 = (Person) xStream.fromXML(xml);
        System.out.println(person1);

    }
}
