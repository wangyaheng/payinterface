package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：
 给定一个链表: 1->2->3->4->5, 和 n = 2.
 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：
 给定的 n 保证是有效的。

 */
public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(head);
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            nodes.add(temp);
        }
        if(nodes.size()==n) return head.next;
        ListNode listNode = nodes.get(nodes.size() - n);
        ListNode prevNode = nodes.get(nodes.size() - n-1);
        prevNode.next = listNode.next;
        listNode = null;
        return head;
    }

    /**
     * 官方解题巧妙用了两个指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 0;i<n;i++){
            first = first.next;
        }
        while(first.next!=null){
            first = first.next;
            second = second.next;
        }
        // sencond指针指向的就是倒数第N-1个节点
        second.next = second.next.next;
        return head;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
