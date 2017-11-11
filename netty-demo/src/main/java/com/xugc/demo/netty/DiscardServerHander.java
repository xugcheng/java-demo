package com.xugc.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xuguocheng on 2017/5/23.
 */
public class DiscardServerHander extends ChannelInboundHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicInteger readerIdleCounter = new AtomicInteger(0);

    private AtomicInteger writerIdleCounter = new AtomicInteger(0);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /**
         * Please keep in mind that
         * it is the handler's responsibility to release any reference-counted object passed to the handler.
         */
        try {
            logger.info("channel-read:" + Thread.currentThread().getName());
            System.out.println("className:" + msg.getClass().getName());
            ByteBuf buf = (ByteBuf) msg;
            System.out.println(ByteBufUtil.prettyHexDump(buf));
            System.out.print(buf.toString(CharsetUtil.UTF_8));
            logger.info("write前,buf.refCnt()=" + buf.refCnt());
            ctx.write(buf);
            logger.info("write后,buf.refCnt()=" + buf.refCnt());
            ctx.flush();
            logger.info("flush后,buf.refCnt()=" + buf.refCnt());
        } finally {
            //ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        /**
         *
         *  In most cases,
         *  the caught exception should be logged and its associated channel should be closed here
         */

        logger.info("exception-caught:");
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            logger.info("userEventTriggered:" + event.state());
            if (event.state() == IdleState.READER_IDLE) {
                int count = readerIdleCounter.incrementAndGet();
                logger.info("读空闲次数:" + count);
                if (count >= 5) {
                    ctx.close();
                }
            } else if (event.state() == IdleState.WRITER_IDLE) {
                int count = writerIdleCounter.incrementAndGet();
                logger.info("写空闲次数:" + count);
                if (count >= 2) {
                    ByteBuf buf = Unpooled.buffer();
                    System.out.println("write ping");
                    buf.writeBytes("ping\r\n".getBytes());
                    ctx.writeAndFlush(buf);
                    writerIdleCounter.set(0);
                }
            }
        }
    }
}
