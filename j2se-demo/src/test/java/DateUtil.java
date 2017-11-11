import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Created by xuguocheng on 2016/12/30.
 */
public class DateUtil {

    public static void main(String[] args) {

        DateTime date;


        //创建任意时间对象
        date = new DateTime(2016, 12, 31, 23, 59, 59);
        System.out.println(date.toString("yyyy-MM-dd HH:mm:ss sss"));


        date = DateTime.now()
                .minusDays(1)
                .plusDays(2)
                .withHourOfDay(12)
                .withMinuteOfHour(30)
                .withSecondOfMinute(31);
        System.out.println(date.toString("yyyy-MM-dd HH:mm:ss sss"));


        //计算日期相差的天数
        LocalDate start = new LocalDate(2016, 12, 1);
        LocalDate end = new LocalDate(2016, 12, 31);
        int days = Days.daysBetween(start, end).getDays();
        System.out.println("days:" + days);

        //获取18天后的某天,在下个月的当前周的第一天日期.
        String dateStr = new DateTime()
                .plusDays(18)
                .plusMonths(1)
                .dayOfWeek().withMinimumValue()
                .toString("yyyy-MM-dd HH:mm:ss sss");
        System.out.println("dateStr:" + dateStr);
    }

}
