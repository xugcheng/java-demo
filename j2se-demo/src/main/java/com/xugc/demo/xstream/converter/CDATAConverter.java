package com.xugc.demo.xstream.converter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CDATAConverter implements Converter {

    protected static String PREFIX_CDATA = "<![CDATA[";

    protected static String SUFFIX_CDATA = "]]>";

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

        String str = String.valueOf(source);
        writer.setValue(PREFIX_CDATA + str + SUFFIX_CDATA);
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return reader.getValue();
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(String.class);
    }
}
