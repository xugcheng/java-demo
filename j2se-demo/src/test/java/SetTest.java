import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xuguocheng on 2017/1/12.
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Object> set;
        try {
            set = new TreeSet<Object>();
            set.add("1");
            set.add("z");
            set.add("b");
            set.add("a");
            set.add("d");
            set.add("c");
            set.add("2");
            System.out.println("treeSet:" + set);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            set = new HashSet<Object>();
            set.add("1");
            set.add("z");
            set.add("b");
            set.add("a");
            set.add("d");
            set.add("c");
            set.add("2");
            System.out.println("hashSet:" + set);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            set = new LinkedHashSet<Object>();
            set.add("1");
            set.add("z");
            set.add("b");
            set.add("a");
            set.add("d");
            set.add("c");
            set.add("2");

            System.out.println("linkedHashSet:" + set);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
