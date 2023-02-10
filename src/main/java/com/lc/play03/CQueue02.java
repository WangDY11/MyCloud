package com.lc.play03;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wdy
 * @Description 剑指 Offer 09. 用两个栈实现队列
 * @createTime 2023年02月10日
 */
public class CQueue02 {
    public static void main(String[] args) {
        //
        CQueue02 queue = new CQueue02();
        queue.appendTail(1);
    }
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
     * 队列：先进先出
     */
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue02() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    // queue in 1 2 3    out 1 2 3
    // instack in 1 2 3    out 3 2 1
    // outstack in 3 2 1    out 1 2 3
    public int deleteHead() {
        if (outStack.isEmpty() && !inStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()){
            return -1;
        }
        return outStack.pop();
    }

}
