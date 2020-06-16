package leetcode;


/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 k 是一个正整数，它的值小于或等于链表的长度。
 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 示例 :
 给定这个链表：1->2->3->4->5
 当 k = 2 时，应当返回: 2->1->4->3->5
 当 k = 3 时，应当返回: 3->2->1->4->5
 说明 :
 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
。
 */
public class Q25 {

    public static void main(String[] args) {
        ListNode prev = new ListNode(1);
        prev.next = new ListNode(2);
        prev.next.next = new ListNode(3);
        prev.next.next.next = new ListNode(4);
        prev.next.next.next.next = new ListNode(5);

        ListNode reverse = reverse(prev);
        System.out.println(reverse);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode start = head;
        int count = 1;
        while (temp.next!=null){
            temp = temp.next;
            if(count%k==0){
                // 转换之前k个节点
                ListNode innerTemp = start.next;
                ListNode innerHead = start;
                while(innerTemp!=temp){


                }
                start.next = temp;
                if(count==k) head = innerHead;
            }

            count++;
        }

        return head;
    }


    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
       ListNode prev = null;
       ListNode current = head;
       //每次处理一个节点，当前节点指向前一个节点
       while(current!=null){
           ListNode temp = current.next;// 记录当前节点的下一个节点，防止改变指针后找不到
           current.next = prev;
           prev = current;
           current = temp;

       }
       return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder builder= new StringBuilder();
            ListNode temp = this;
            while (temp!=null){
                builder.append(temp.val+"->");
                temp = temp.next;
            }
            //System.out.println(builder.toString());
            return builder.toString();
        }
    }
}
