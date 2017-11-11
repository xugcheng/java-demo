import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuguocheng on 2017/8/29.
 */
public class Test5 {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = sdf.parse("2017-08-29 09:43:00");
        Date date2 = sdf.parse("2017-08-29 09:43:00");
        Date date3 = sdf.parse("2017-08-29 09:44:00");
        System.out.println(date1 == date2);
        System.out.println(date1.equals(date2));
        System.out.println(date1.before(date3));
        System.out.println(date2.before(date3));
    }
}
