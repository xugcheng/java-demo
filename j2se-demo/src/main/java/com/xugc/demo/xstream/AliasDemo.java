package com.xugc.demo.xstream;

import com.thoughtworks.xstream.XStream;
import com.xugc.demo.xstream.converter.AuthorConverter;
import com.xugc.demo.xstream.domain.Author;
import com.xugc.demo.xstream.domain.Blog;
import com.xugc.demo.xstream.domain.Entry;

public class AliasDemo {

    public static void main(String[] args) {

        Author author = new Author("张三");
        Entry entry1 = new Entry("first", "firstDesc");
        Entry entry2 = new Entry("second", "secondDesc");
        Blog blog = new Blog(author);
        blog.addEntry(entry1);
        blog.addEntry(entry2);

        XStream xStream = new XStream();

        String xml1 = xStream.toXML(blog);
        System.out.println(xml1);
        System.out.println("********************");

        xStream.alias("blog", Blog.class);
        xStream.alias("entry", Entry.class);

        String xml2 = xStream.toXML(blog);
        System.out.println(xml2);

        System.out.println("********************");

        xStream.addImplicitCollection(Blog.class, "entries");
        xStream.useAttributeFor(Blog.class, "author");
        xStream.aliasField("writer", Blog.class, "author");
        xStream.registerConverter(new AuthorConverter());

        String xml3 = xStream.toXML(blog);
        System.out.println(xml3);
        System.out.println("********************");

    }
}
