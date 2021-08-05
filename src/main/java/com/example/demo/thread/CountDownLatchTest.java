package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/7/16  | 修改内容
 */
@Slf4j
@RestController
@RequestMapping("/countDownLatch")
public class CountDownLatchTest {
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5,
            5L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1000));

    @GetMapping("/test01")
    public void test01() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i <10 ; i++) {
            executor.execute(() -> {
                log.info(">>>>线程" + Thread.currentThread().getName());
                list.add(Thread.currentThread().getName());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info(">>>循环结束了");
        for (String s : list){
            log.info(s);
        }
    }


}
