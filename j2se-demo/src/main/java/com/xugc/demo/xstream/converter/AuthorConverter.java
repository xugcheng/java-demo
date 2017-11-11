package com.xugc.demo.xstream.converter;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.xugc.demo.xstream.domain.Author;

public class AuthorConverter implements SingleValueConverter {

    @Override
    public String toString(Object obj) {
        return ((Author) obj).getName();
    }

    @Override
    public Object fromString(String name) {
        return new Author(name);
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Author.class);
    }
}
