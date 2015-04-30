import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends SimpleChannelInboundHandler<String> {

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded( ChannelHandlerContext ctx) throws Exception{
        Channel incoming = ctx.channel();

        for (Channel channel : channels){
            channel.writeAndFlush("[SERVER]" + incoming.remoteAddress() + " has join !\n");
        }
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved( ChannelHandlerContext ctx) throws  Exception{
        Channel incoming = ctx.channel();

        for (Channel channel : channels){
            channel.writeAndFlush("[SERVER]" + incoming.remoteAddress() + " has left !\n");
        }
        channels.remove(ctx.channel());
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels){
            if( channel != incoming ){
                channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + msg + "\n");
            }
        }
    }
}