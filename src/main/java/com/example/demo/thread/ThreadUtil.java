package com.example.demo.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/4/30  | 修改内容
 */
public class ThreadUtil {


    private static ThreadGroup rootThreadGroup = null;

    public static ThreadGroup getRootThreadGroup() {
        if (rootThreadGroup != null){
            return rootThreadGroup;
        }
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        ThreadGroup ptg;
        while ((ptg = tg.getParent()) != null){
            tg = ptg;
        }

        rootThreadGroup = tg;
        return tg;

    }

    public static Thread[] getAllThreads() {
        final ThreadGroup root = getRootThreadGroup();

        final ThreadMXBean thbean = ManagementFactory.getThreadMXBean();

        int nAlloc = thbean.getThreadCount();
        int n = 0;
        Thread[] threads = null;

        do {
            nAlloc *= 2;
            threads = new Thread[nAlloc];
            n = root.enumerate(threads, true);
        } while (n == nAlloc);

        return java.util.Arrays.copyOf(threads, n);
    }

    public static Thread getThread(final String name) {

        if (name == null)
            throw new NullPointerException("Null name");

        final Thread[] threads = getAllThreads();

        for (Thread thread : threads) {
            if (thread.getName().equals(name))
                return thread;
        }
        return null;
    }


    public static Thread getThread(final long id) {
        final Thread[] threads = getAllThreads();
        for (Thread thread : threads) {
            if (thread.getId() == id){
                return thread;
            }
        }
        return null;

    }

}
