/**
 * Created by xuguocheng on 2017/6/30.
 */
public class Test3 {

    public static void main(String[] args) {

        int length = 4;

        System.out.println(0 & (length - 1));
        System.out.println(1 & (length - 1));
        System.out.println(2 & (length - 1));
        System.out.println(3 & (length - 1));
        System.out.println(4 & (length - 1));
        System.out.println(5 & (length - 1));
        System.out.println(6 & (length - 1));
        System.out.println(7 & (length - 1));
        System.out.println(8 & (length - 1));

        System.out.println(0 & length - 1);
        System.out.println(1 & length - 1);
        System.out.println(2 & length - 1);
        System.out.println(3 & length - 1);
        System.out.println(4 & length - 1);
        System.out.println(5 & length - 1);
        System.out.println(6 & length - 1);
        System.out.println(7 & length - 1);
        System.out.println(8 & length - 1);

        System.out.println("isPowerOfTwo");
        for (int i = 0; i < 10000; i++) {
            if ((i & -i) == i) {
                System.out.println(i);
            }
        }

    }
}
