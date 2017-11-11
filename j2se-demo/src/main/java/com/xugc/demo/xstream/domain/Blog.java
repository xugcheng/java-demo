package com.xugc.demo.xstream.domain;

import java.util.ArrayList;
import java.util.List;

public class Blog {

    private Author author;

    private List<Entry> entries;

    public Blog(Author author) {
        this.author = author;
        this.entries = new ArrayList<>();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }
}
