import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xuguocheng on 2017/2/23.
 */
public class RegexTest {

    public static void main(String[] args) {
        String str = "01234567899876543210";
        Pattern pattern = Pattern.compile("12|21");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("start:" + matcher.start() + ",end:" + matcher.end() + ",group:" + matcher.group());
        }

        System.out.println(str.matches(str));
        System.out.println(str.matches("(\\w)*"));
        System.out.println(str.matches("(\\d)*"));

    }

}
