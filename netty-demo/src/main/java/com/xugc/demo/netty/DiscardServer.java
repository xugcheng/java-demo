package com.xugc.demo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * Created by xuguocheng on 2017/5/23.
 */
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);

        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new MyChannelInboundHandler1())
                                    .addLast(new MyChannelInboundHandler2())
                                    .addLast(new MyChannelOutboundHandler1())
                                    .addLast(new MyChannelOutboundHandler2())
                                    .addLast(new IdleStateHandler(30, 15, 0))
                                    .addLast(new DiscardServerHander());
                        }
                    })
                    // option() is for the NioServerSocketChannel that accepts incoming connections.
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // childOption() is for the channels accepted by the parent ServerChannel,
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture f = bootstrap.bind(port).sync();
            f.awaitUninterruptibly();
            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {

        int port = 8000;
        new DiscardServer(port).run();
    }
}
