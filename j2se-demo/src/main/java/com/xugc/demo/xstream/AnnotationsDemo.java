package com.xugc.demo.xstream;

import com.thoughtworks.xstream.XStream;
import com.xugc.demo.xstream.domain.RendezvousMessage;
import org.apache.commons.lang.StringEscapeUtils;

public class AnnotationsDemo {

    public static void main(String[] args) {

        XStream xstream = new XStream();
        RendezvousMessage msg = new RendezvousMessage(15);

        System.out.println(xstream.toXML(msg));
        System.out.println("******************");

        xstream.processAnnotations(RendezvousMessage.class);
        System.out.println(xstream.toXML(msg));
        System.out.println("******************");

        RendezvousMessage msg1 = new RendezvousMessage(16, "xx", "yy", "zz");
        System.out.println(xstream.toXML(msg1));
        System.out.println("******************");

        RendezvousMessage msg2 = new RendezvousMessage(17, false, "aa", "bb", "cc");
        msg2.setDesc("描述");
        System.out.println(xstream.toXML(msg2));
        System.out.println("******************");

        System.out.println(StringEscapeUtils.unescapeXml(xstream.toXML(msg2)));
        System.out.println("******************");
    }
}
