import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created by xuguocheng on 2017/6/26.
 */
public class HexTest {

    public static void main(String[] args) {

        short year = 2017;
        byte month = 06;
        byte day = 26;

        ByteBuf buf = Unpooled.buffer();
        buf.writeShort(year);
        buf.writeByte(month - 1);
        buf.writeByte(day - 1);

        byte[] bytes = new byte[4];

        buf.readBytes(bytes);

        for (int i = 0; i < bytes.length; i++) {
            System.out.println(Integer.toHexString((0xff & bytes[i])));
        }

        byte[] ymd = new byte[]{7, -31, 5, -2};
        buf.clear();
        buf.writeBytes(ymd);

        int y = buf.readShort();
        int m = buf.readByte();
        int d = buf.readByte();

        int y1 = (ymd[0] & 0xff) << 8 | (ymd[1] & 0xff);
        int m1 = (ymd[2] & 0xff);
        int d1 = (ymd[3] & 0xff);

        System.out.println(String.format("%4d%02d%02d",y,m,d));
        System.out.println(String.format("%4d%02d%02d",y1,m1,d1));
    }
}
