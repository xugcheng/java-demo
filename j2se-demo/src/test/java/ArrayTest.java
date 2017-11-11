import java.util.Arrays;

/**
 * Created by xuguocheng on 2017/6/20.
 */
public class ArrayTest {

    public static void main(String[] args) {

        int[] arr = new int[1440];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int x = 31;
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        int[] a3 = new int[10];

        System.arraycopy(arr, x - 30 + 1, a1, 0, a1.length);
        System.arraycopy(arr, x - 20 + 1, a2, 0, a2.length);
        System.arraycopy(arr, x - 10 + 1, a3, 0, a3.length);

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }
}
