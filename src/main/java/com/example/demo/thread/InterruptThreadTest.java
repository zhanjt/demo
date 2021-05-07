package com.example.demo.thread;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <功能说明>
 * 尝试停止另一个线程
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/4/30  | 修改内容
 */
@RestController
public class InterruptThreadTest {



    @GetMapping("/interruptThread")
    public String interruptThread(){
        String threadId = TestRun.getThreadId();
        boolean flag = TestRun.getFlag();
        System.out.println("threadId:" + threadId + ", flag: " + flag);

        if(!StringUtils.hasLength(threadId)){
            Thread thread = ThreadUtil.getThread(Long.parseLong(threadId));
            System.out.println("线程名称：" + thread.getName());
            //停止一个线程。
            thread.interrupt();
            //下面这种是where true的方式
//            TestRun.setFlag(false);
        }
        System.out.println("停止线程完成：");
        return "success";
    }

}
