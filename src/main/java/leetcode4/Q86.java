package leetcode4;


/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Q86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode partition = partition(head, 3);
        printNode(partition);

    }

    public static void printNode(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+"===>");
            temp = temp.next;
        }
    }
    /**
     * 双指针，遍历链表 小于X的节点放到第一个链表，大于X的节点放到第二个链表
     * 最后将两个链表链接起来
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;

        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while(head!=null){

            if(head.val<x){
                // 添加到第一个链表中
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next=null;
        // 将两个链表链接起来
        if(before_head.next==null) return after_head.next;
        before.next = after_head.next;

        return before_head.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
