package com.example.demo.java8;

import com.example.demo.utils.JsonUtil;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2022/1/14  | 修改内容
 */
public class Test {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20,
            5L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000));

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executor.execute(() -> {
            System.out.println("我是1");
            list.add(0, "我是1");
            countDownLatch.countDown();
        });
        executor.execute(() -> {
            System.out.println("我是2");
            list.add(1, "我是2");
            countDownLatch.countDown();
        });
        executor.execute(() -> {
            System.out.println("我是3");
            list.add(2, "我是3");
            countDownLatch.countDown();
        });

        System.out.println("我是4");
        countDownLatch.await();
        System.out.println("我是5");
        System.out.println(JsonUtil.object2JsonStr(list));
    }
}
