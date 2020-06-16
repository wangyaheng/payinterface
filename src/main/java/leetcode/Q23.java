/*
package leetcode;

import org.apache.xpath.operations.String;
import org.aspectj.weaver.ast.Var;

import java.util.Arrays;
import java.util.List;

*/
/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 示例:
 输入:
 [
   1->4->5,
   1->3->4,
   2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 *//*

public class Q23 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = new ListNode(5);


        ListNode listNodea = new ListNode(1);
        ListNode listNode1a = new ListNode(4);
        listNodea.next = listNode1a;
        listNode1a.next = new ListNode(7);

        ListNode listNodeb = new ListNode(2);
        ListNode listNode1b = new ListNode(3);
        listNodeb.next = listNode1b;

        listNode.listNodes();
        mergeTwoLists(listNode,listNodea );
        mergeKLists(new ListNode[]{listNode,listNodea,listNodeb});
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 切割为两个数组进行排序
        if(lists.length==1){
            return lists[0];
        }else if(lists.length==2){
            // 排序
            return mergeTwoLists(lists[0],lists[1]);
        }else{
            int index = lists.length%2==0?lists.length/2-1:(lists.length+1)/2;
            ListNode listNode = mergeKLists(Arrays.copyOfRange(lists, 0, index));
            ListNode listNode1 = mergeKLists(Arrays.copyOfRange(lists, index-1, lists.length - 1));
            return mergeKLists(new ListNode[]{listNode,listNode1});
        }


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevNode =  new ListNode(-1);
        System.out.println();
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

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public void listNodes(){
            StringBuilder builder= new StringBuilder();
            ListNode temp = this;
            while (temp!=null){
                builder.append(temp);
                temp = temp.next;
            }
            System.out.println(builder.toString());
        }
    }
}
*/
