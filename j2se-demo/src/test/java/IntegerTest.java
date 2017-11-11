/**
 * Created by xuguocheng on 2017/4/20.
 */
public class IntegerTest {

    public static void main(String[] args) {

        String s1 = "58";
        String s2 = "3A";

        Integer x1 = Integer.valueOf(s1, 10);
        Integer x2 = Integer.valueOf(s2, 16);

        System.out.println(x1);
        System.out.println(Integer.toString(x1, 2));
        System.out.println(Integer.toString(x1, 10));
        System.out.println(Integer.toString(x1, 16));

        System.out.println(x2);
        System.out.println(Integer.toString(x2, 2));
        System.out.println(Integer.toString(x2, 10));
        System.out.println(Integer.toString(x2, 16));

        System.out.println("******解析B2******");

        String s3 = "B2";
        Integer x3 = Integer.valueOf(s3,16);
        System.out.println(x3);

        byte b = (byte)(x3 & 0x000000ff);
        System.out.println((int)b);

        System.out.println("******解析-78******");

        String s4 = "-78";
        Integer x4 = Integer.valueOf(s4,10);
        System.out.println(x4);
    }
}
