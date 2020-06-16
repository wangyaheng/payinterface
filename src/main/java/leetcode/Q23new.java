package leetcode;

import sun.security.util.Length;

import java.util.Arrays;

public class Q23new {
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
        //mergeTwoLists(listNode,listNodea );
        ListNode listNode2 = mergeKLists(new ListNode[]{listNode, listNodea, listNodeb});
        System.out.println(listNode2);


    }

    /**
     * 非递归解法
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length==0) return null;
        int len = lists.length;
        while(len>1){
            for (int i=0; i<len/2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[len-1-i]);
            }
            len = len/2;

        }
        return lists[0];
    }
    /**
     * 递归解法
     * @param lists
     * @return
     */
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
            ListNode listNode1 = mergeKLists(Arrays.copyOfRange(lists, index, lists.length));
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
                builder.append(temp.val+"->");
                temp = temp.next;
            }
            System.out.println(builder.toString());
        }

        @Override
        public String toString() {
            StringBuilder builder= new StringBuilder();
            ListNode temp = this;
            while (temp!=null){
                builder.append(temp.val+"->");
                temp = temp.next;
            }
            System.out.println(builder.toString());
            return builder.toString();
        }
    }
}
