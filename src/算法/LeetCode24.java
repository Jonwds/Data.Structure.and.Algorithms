package 算法;

import org.junit.Test;

/*
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

示例:
    给定 1->2->3->4, 你应该返回 2->1->4->3.
说明:
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //给定 1->2->3->4, 你应该返回 2->1->4->3.
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);dummyHead.next=head;
        ListNode p = head,q=p.next,pre=dummyHead;
        while(p!=null&&q!=null ){
            ListNode next = q.next;
            pre.next=q;
            q.next=p;
            p.next=next;
            pre=p;
            if(next==null){
                break;
            }
            p=next;q=p.next;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);dummyHead.next=head;
        ListNode p =dummyHead;

        while(p.next!=null && p.next.next!=null ){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next=node1;
            node1.next=next;
            p.next=node2;

            p=node1;
        }
        return dummyHead.next;
    }
    @Test
    public void test(){
        int[] arr1={1,2,3,4};
        ListNode head1 = createListNode(arr1);
        ListNode listNode = swapPairs2(head1);
        printListNode(listNode);

    }
    private void printListNode(ListNode head){
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print( "NULL");
    }
    private ListNode createListNode(int[] arr){
        if(arr.length<=0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i=1;i<arr.length;i++){
            cur.next=new ListNode(arr[i]);cur=cur.next;
        }
        return head;
    }
}
