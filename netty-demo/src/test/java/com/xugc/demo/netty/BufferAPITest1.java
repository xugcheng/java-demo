package com.xugc.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

import java.nio.charset.Charset;

/**
 * Created by xuguocheng on 2017/5/24.
 */
public class BufferAPITest1 {

    public static void main(String[] args) {

        ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer();
        buf.writeCharSequence("中", Charset.forName("utf-8"));
        buf.writeCharSequence("中", Charset.forName("unicode"));
        System.out.println(buf);
        String str = ByteBufUtil.prettyHexDump(buf);
        System.out.println(str);

    }
}
