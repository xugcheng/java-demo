package com.xugc.demo.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.StringWriter;

public class SerializeExampleTreeModle {

    public static void main(String[] args) throws Exception {

        JsonNodeFactory jsonNodeFactory = new JsonNodeFactory(false);

        JsonFactory jsonFactory = new JsonFactory();

        StringWriter writer = new StringWriter();

        JsonGenerator jsonGenerator = jsonFactory.createGenerator(writer);

        ObjectNode root = jsonNodeFactory.objectNode();
        root.put("name", "张三");
        root.put("age", 22);

        ArrayNode node1 = jsonNodeFactory.arrayNode();
        node1.add("广州");
        node1.add("深圳");

        root.putPOJO("city", node1);

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeTree(jsonGenerator, root);

        String jsonStr = writer.toString();

        System.out.println(jsonStr);
    }
}
