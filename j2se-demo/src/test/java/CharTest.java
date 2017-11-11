/**
 * Created by xuguocheng on 2017/3/1.
 */
public class CharTest {

    public static void main(String[] args) {

        System.out.println("min:" + (int) Character.MIN_VALUE);
        System.out.println("max:" + (int) Character.MAX_VALUE);
        System.out.println(Integer.toString((int) Character.MIN_VALUE, 2));
        System.out.println(Integer.toString((int) Character.MAX_VALUE, 2));

        System.out.println(Integer.toString((int) Character.MIN_VALUE, 16));
        System.out.println(Integer.toString((int) Character.MAX_VALUE, 16));

    }

}
