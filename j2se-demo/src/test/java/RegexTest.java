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

        String reg = "^ICW(01|02|03)-\\d{6,7}$";
        System.out.println("ICW01-000111".matches(reg));
        System.out.println("ICW01-0001111".matches(reg));

        System.out.println("ICW02-000111".matches(reg));
        System.out.println("ICW02-0001111".matches(reg));

        System.out.println("ICW02-00011".matches(reg));
        System.out.println("ICW02-00011111".matches(reg));
        System.out.println("ICW02-00011b".matches(reg));

        System.out.println("ICW03-000111".matches(reg));
        System.out.println("ICW03-0001111".matches(reg));

    }

}
