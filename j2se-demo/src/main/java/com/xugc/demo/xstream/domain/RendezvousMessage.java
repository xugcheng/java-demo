package com.xugc.demo.xstream.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.xugc.demo.xstream.converter.CDATAConverter;
import com.xugc.demo.xstream.converter.CalendarConverter;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@XStreamAlias("message")
public class RendezvousMessage {

    @XStreamAlias("type")
    @XStreamAsAttribute
    private int messageType;

    @XStreamImplicit(itemFieldName = "part")
    private List<String> content;

    @XStreamConverter(value = BooleanConverter.class, booleans = {false}, strings = {"yes", "no"})
    @XStreamAsAttribute
    private boolean important;

    @XStreamConverter(value = CalendarConverter.class)
    private Calendar created = new GregorianCalendar();

    @XStreamConverter(value = CDATAConverter.class)
    private String desc;

    public RendezvousMessage(int messageType) {
        this.messageType = messageType;
    }

    public RendezvousMessage(int messageType, String... content) {
        this.messageType = messageType;
        this.content = Arrays.asList(content);
    }

    public RendezvousMessage(int messageType, boolean important, String... content) {
        this.messageType = messageType;
        this.content = Arrays.asList(content);
        this.important = important;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
