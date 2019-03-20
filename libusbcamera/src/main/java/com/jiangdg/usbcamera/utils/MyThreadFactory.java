package com.jiangdg.usbcamera.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 自定义线程工厂
 *
 * @author sunpan
 * @date 2019-03-18
 */
public class MyThreadFactory implements ThreadFactory {

    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable run) {
        Thread t = new Thread(run, name + "-thread-" + counter);
        counter++;
        stats.add(String.format("Created thread %d with name %s on%s\n", t.getId(), t.getName(), new Date()));
        return t;
    }

    public String getStas() {
        StringBuilder buffer = new StringBuilder();
        for (String stat : stats) {
            buffer.append(stat);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
