package leetcode;

/**
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 示例:
 给定 1->2->3->4, 你应该返回 2->1->4->3.

 */
public class Q24 {
    public static void main(String[] args) {
        ListNode prev = new ListNode(1);
        prev.next = new ListNode(2);
        prev.next.next = new ListNode(3);
        prev.next.next.next = new ListNode(4);

        swapPairs(prev);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode temp = prev;
        while(temp.next!=null&&temp.next.next!=null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;

            temp = start;


        }
        return prev.next;
    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
