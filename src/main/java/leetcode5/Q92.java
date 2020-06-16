package leetcode5;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 说明:
 1 ≤ m ≤ n ≤ 链表长度。
 示例:
 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 输出: 1->4->3->2->5->NULL

 */
public class Q92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode listNode = reverseBetween(head, 2, 4);
        printNode(listNode);
    }
    public static void printNode(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+"===>");
            temp = temp.next;
        }
    }

    /**
     * 反转位置m~n的子链表
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;

        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        head = prev.next; // 此时head就是第m个元素

        for (int i = m; i < n; i++) {
            //反转  每次都把当前元素移动到head前边
            ListNode next = head.next;
            head.next = next.next;
            next.next = prev.next;
            prev.next = next;


        }
        return dummy.next;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
}
