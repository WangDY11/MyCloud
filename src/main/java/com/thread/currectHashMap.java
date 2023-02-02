package com.thread;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wdy
 * @Description TODO
 * @createTime 2022年12月14日
 */
public class currectHashMap {

    public static void main(String[] args) {
        List<String> objects = Collections.synchronizedList(new ArrayList<String>());
        // 高并发环境性能最好的队列
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.offer(3);
        concurrentLinkedQueue.add(4);
        // 高效读取队列
        CopyOnWriteArrayList<String> s = new CopyOnWriteArrayList<>();
        s.add("s");
        // 跳表-快速查找
        ConcurrentSkipListMap<Integer, Integer> p = new ConcurrentSkipListMap<>();
        p.put(1,2);
    }
}
