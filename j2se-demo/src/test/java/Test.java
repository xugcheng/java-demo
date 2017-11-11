/**
 * Created by xuguocheng on 2016/12/19.
 */
public class Test {
    public static void main(String[] args) {

        Integer a1, a2;

        a1 = 127;
        a2 = 127;

        System.out.println(a1.equals(a2));
        System.out.println(a1 == a2);

        a1 = 128;
        a2 = 128;


        System.out.println(a1.equals(a2));
        System.out.println(a1 == a2);

        String s = "ff";

        Integer i = Integer.valueOf(s, 16);
        System.out.println("s=" + s);
        System.out.println("i=" + i);

        byte b = 0x0f;
        System.out.println(b & 0xff);

        String s1 = "07e10613";
        int year = Integer.valueOf(s1.substring(0, 4), 16);
        int month = Integer.valueOf(s1.substring(4, 6), 16) + 1;
        int day = Integer.valueOf(s1.substring(6, 8), 16) + 1;
        String dateStr = String.format("%4d%02d%02d", year, month, day);
        System.out.println(dateStr);

        int t = 1497491448;

        System.out.println(t);
        System.out.println(Integer.MAX_VALUE);
    }
}
