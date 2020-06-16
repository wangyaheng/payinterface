package leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 */
public class Q21 {
    /**
     * 时间复杂度O（m+n）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevNode =  new ListNode(-1);
        ListNode p = prevNode;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                prevNode.next = l2;
                l2 = l2.next;
            }else{
                prevNode.next = l1;
                l1 = l1.next;
            }
            prevNode = prevNode.next;
        }
        prevNode.next = l1 == null ? l2 : l1;

        return p.next;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
