package com.lc.play03;

import java.util.List;

/**
 * @author wdy
 * @Description 两数相加
 * @createTime 2023年02月02日
 */
public class addTwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode res = new ListNode(0);
        while (l1.next != null && l2.next != null){
            if (l1.next == null){
                l1.next = new ListNode(0);
            }
            if (l2.next == null){
                l2.next = new ListNode(0);
            }
            /**
             * 输入：l1 = [2,4,3], l2 = [5,6,4]
             * 输出：[7,0,8]
             * 解释：342 + 465 = 807.
             */
            int sum = temp1.val + temp2.val;
            int n = (sum) % 10;
            res.next = new ListNode(n);
            if (sum >= 10){
                l1.next.val = l1.next.val + 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
