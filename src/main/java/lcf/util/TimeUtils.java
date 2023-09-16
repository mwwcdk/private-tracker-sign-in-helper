package lcf.util;

import org.springframework.scheduling.support.CronExpression;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 时间工具
 */
public class TimeUtils {

    /** 一天的毫秒数 */
    public static final long ONE_DAY_MILLIS = 1000 * 60 * 60 * 24;

    /** 日期格式化器 */
    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * 获取该cron表达式的下一个时间点(ms时间戳)
     * @param cron
     * @return
     */
    public static long getNextTime(String cron) {
        if (!CronExpression.isValidExpression(cron)) {
            throw new IllegalArgumentException("非法的cron表达式! cron:" + cron);
        }
        // 当前时间
        LocalDateTime now = LocalDateTime.now();
        // 下个时间点
        LocalDateTime next = CronExpression.parse(cron).next(now);
        return System.currentTimeMillis() + Math.abs(Duration.between(now, next).toMillis());
    }

    /**
     * 格式化时间戳
     * @param timeStamp
     * @return
     */
    public static String format(long timeStamp) {
        return DATE_FORMAT_THREAD_LOCAL.get().format(new Date(timeStamp));
    }

}
