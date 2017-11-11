package com.xugc.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;

/**
 * Created by xuguocheng on 2017/7/3.
 */
public class BufferAPITest3 {


    /**
     * Created by xuguocheng on 2017/6/29.
     */

    public static void main(String[] args) {

        byte[] data = new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09};

        ByteBuf buf = Unpooled.buffer();
        System.out.println("初始化:" + buf.readerIndex() + "-" + buf.writerIndex());
        System.out.println("readableBytes:" + buf.readableBytes());
        System.out.println(ByteBufUtil.prettyHexDump(buf));

        buf.writeBytes(data);
        System.out.println("writeBytes:" + buf.readerIndex() + "-" + buf.writerIndex());
        System.out.println("readableBytes:" + buf.readableBytes());
        System.out.println(ByteBufUtil.prettyHexDump(buf));

        buf.readByte();
        System.out.println("readByte:" + buf.readerIndex() + "-" + buf.writerIndex());
        System.out.println("readableBytes:" + buf.readableBytes());
        System.out.println(ByteBufUtil.prettyHexDump(buf));

        System.out.println("*******set and get*********");
        buf.setByte(0, 0x09);
        for (int i = 0; i < buf.writerIndex(); i++) {
            System.out.print(buf.getByte(i));
        }
        System.out.println();
        System.out.println("*******set and get*********");

        buf.discardReadBytes();
        System.out.println("discardReadBytes:" + buf.readerIndex() + "-" + buf.writerIndex());
        System.out.println("readableBytes:" + buf.readableBytes());
        System.out.println(ByteBufUtil.prettyHexDump(buf));

        buf.resetReaderIndex();
        System.out.println("resetReaderIndex:" + buf.readerIndex() + "-" + buf.writerIndex());
        System.out.println("readableBytes:" + buf.readableBytes());
        System.out.println(ByteBufUtil.prettyHexDump(buf));

        buf.resetWriterIndex();
        System.out.println("resetWriterIndex:" + buf.readerIndex() + "-" + buf.writerIndex());
        System.out.println("readableBytes:" + buf.readableBytes());
        System.out.println(ByteBufUtil.prettyHexDump(buf));


    }
}
