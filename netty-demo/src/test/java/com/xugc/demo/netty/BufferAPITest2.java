package com.xugc.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Arrays;

/**
 * Created by xuguocheng on 2017/6/8.
 */
public class BufferAPITest2 {

    public static void main(String[] args) {

        System.out.println("args:" + Arrays.asList(args));

        ByteBuf buf1 = Unpooled.buffer();
        buf1.writeBytes(new byte[]{0x01, 0x02, 0x03, 0x04});

        ByteBuf buf2 = Unpooled.buffer();
        buf2.writeBytes(new byte[]{0x01, 0x02, 0x03, 0x04});

        ByteBuf buf3 = buf1.readBytes(4);
        ByteBuf buf4 = buf2.readSlice(4);

        System.out.println(buf1);
        System.out.println(buf2);
        System.out.println(buf3);
        System.out.println(buf4);


    }
}
