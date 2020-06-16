package leetcode4;


/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Q82 {
    public volatile static int a = 0;
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
       /* head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next= new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);*/

        ListNode listNode = deleteDuplicates(head);
        ListNode p1 = listNode;
        while(p1!=null){
            System.out.print(p1.val+"-->");
            p1 = p1.next;
        }


    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode no1 = new ListNode(0);
        no1.next = head;

        ListNode p1 = no1;
        ListNode p2 = head;
        boolean flag = false;
        while(p1.next!=null){
            while(p2.next!=null&&p1.next.val==p2.next.val){
                p2 = p2.next;
                flag = true;
            }
            if(flag){
                // 有重复元素
                p1.next = p2.next;
                p2 = p2.next;
                flag = false;
            }else{
                // 没有重复元素
                p1 = p2;
                p2 = p2.next;
            }

        }
        return no1.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
