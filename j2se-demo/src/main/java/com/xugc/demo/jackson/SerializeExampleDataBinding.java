package com.xugc.demo.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializeExampleDataBinding {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public static String toJSONString(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T parseJSON(String text, Class<T> clazz) throws IOException {
        return mapper.readValue(text, clazz);
    }

    public static void main(String[] args) throws Exception {

        Address address = new Address();
        address.setCity(new String[]{"广州", "深圳"});
        address.setName("地址");
        address.setCode(1);
        address.setDate(new Date());

        String addressStr = toJSONString(address);

        System.out.println(addressStr);

        Address address1 = parseJSON(addressStr, Address.class);

        System.out.println(address1.toString());

    }
}
