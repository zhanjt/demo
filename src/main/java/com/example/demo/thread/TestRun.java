package com.example.demo.thread;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * <功能说明>
 * 程序启动时执行  实现ApplicationRunner 也可实现CommondLineRunner类   重写run方法
 * 让这个线程一直执行
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/4/30  | 修改内容
 */
@Component
public class TestRun implements ApplicationRunner {
    private static volatile boolean flag = true;
    private static String threadId;

    public static boolean getFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        TestRun.flag = flag;
    }

    public static String getThreadId(){
        return threadId;
    }




    @Override
    public void run(ApplicationArguments args) throws Exception {
        new Thread(() -> {
            threadId = "" + Thread.currentThread().getId();
            System.out.println("运行的线程id：" + Thread.currentThread().getId());
            System.out.println("运行的线程名称：" + Thread.currentThread().getName());

//            while (flag){

                try {
                    System.out.println(System.currentTimeMillis());
                    System.out.println("我先睡1s");
                    Thread.sleep(10000L);
                }catch (Exception e){
//                    throw  new RuntimeException(e);
                    //要try catch 把异常吃掉才可以
                    System.out.println("我要退出来了");
                }
                System.out.println("我立了一个flag...");
//            }

        }).start();

    }
}
