package leetcode4;


/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Q83 {
    public static void main(String[] args) {
        Q83.ListNode head = new Q83.ListNode(1);
        head.next = new Q83.ListNode(1);
       head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode listNode = deleteDuplicates(head);
        Q83.ListNode p1 = listNode;
        while(p1!=null){
            System.out.print(p1.val+"-->");
            p1 = p1.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode now = head;
        ListNode next = null;
        while(now!=null){
            next = now.next;
            while(next!=null&&next.val==now.val){
                next = next.next;
            }
           now.next = next;
           now = now.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
