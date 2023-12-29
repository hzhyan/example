package com.example.myapplication;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[] temp = new int[args.length];
        LinkedList<Integer> list = new LinkedList<>();
    }

    public ListNode mergeKLists(ListNode head, int n) {
        ListNode current = head;
        ListNode slow = head;
        ListNode slowPre = head;
        int i = 1;
        while (current.next != null) {
            current = current.next;
            if (i > n) {
                slowPre = slow;
                slow = slow.next;
            }
            i ++;
        }
        slowPre.next = slow.next;
        return head;
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
