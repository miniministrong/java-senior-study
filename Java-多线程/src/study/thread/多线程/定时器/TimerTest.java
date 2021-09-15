package study.thread.多线程.定时器;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用定时器指定定时任务
 */
public class TimerTest {
    public static void main(String[] args) throws ParseException {
        // 创建一个定时器的对象
        Timer timer = new Timer();
        // Timer timer = new Timer(true); // 定义为守护线程的方式
        // timer.schedule(定时任务, 第一次执行的时间, 间隔多久执行一次);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firsttime = sdf.parse("2021-07-06 17:49:40");

        // timer.schedule(new LogTimerTask(), firsttime, 1000 * 10);
        // 每年执行一次
        // timer.schedule(new LogTimerTask(), firsttime, 1000 * 60 * 60 * 24  * 365);
        // 使用匿名内部类的方式
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // code...
            }
        }, firsttime, 1000 * 10);
    }
}
// 这是一个记录日志的任务
class LogTimerTask extends TimerTask{
    @Override
    public void run() {
        // 设置你需要执行的任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + ":完成了一次数据备份");
    }
}