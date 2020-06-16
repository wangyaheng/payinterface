package leetcode;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */
public class Q2 {
    public static void main(String[] args) {
        System.out.println(7%10);

    }

    public static ListNode add(ListNode l1,ListNode l2){

        ListNode finalNode = null;
        ListNode node = null;
        int needAdd1 = 0;
        while(true){
            if(l1==null&&l2==null) break;
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            if(finalNode==null){
                finalNode=new ListNode((val1+val2)%10);
                node = finalNode;
            }else{
                ListNode node1 =new ListNode((val1+val2+needAdd1)%10);
                node.next = node1;
                node = node1;
            }
            needAdd1 = (val1+val2+needAdd1)/10!=0?1:0;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;


        }
        if(needAdd1==1)node.next = new ListNode(1);
        return finalNode;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}





