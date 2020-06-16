package leetcode3;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 示例 1:
 输入: 1->2->3->4->5->NULL, k = 2
 输出: 4->5->1->2->3->NULL
 解释:
 向右旋转 1 步: 5->1->2->3->4->NULL
 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class Q61 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
       //head.next.next.next.next = new ListNode(5);

        ListNode listNode = rotateRight(head, 2);
        ListNode head1 = listNode;
        while (head1!=null){
            System.out.print(head1.val+"===>");
            head1 = head1.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(head.next==null) return  head;
        if(k==0) return head;
        //找到移动的起始位置
        int count = 0;
        // 算出链表的长度
        ListNode node = head;
        while(node!=null){
          count++;
          node = node.next;
        }
        int index = k;// 开始旋转的倒数下标
        if(count<=k) index = k%count;
        if(index==0) return head;
        // 找出开始旋转的节点
        node = head;
        ListNode startNode = head;
        ListNode tail = null;
        int n = 0;
        while(node!=null){
            if(n>index){
                startNode = startNode.next;
            }
            n++;
            if(node.next == null){
                tail = node;// 尾节点
            }
            node = node.next;

        }
       // if(startNode.next!=null){
            ListNode newHead = startNode.next;
            startNode.next = null;
            tail.next = head;
            return newHead;
        //}



    }
}
