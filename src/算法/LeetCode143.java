package 算法;

import org.junit.Test;

import java.util.List;

/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
    给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
    给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class LeetCode143 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reorderList(ListNode head) {
        //找到中间的元素，将链表一分为二，再将右边的链表逆置，
        //左半边取一个节点 右半边取一个节点 将他们连接起来
        //怎么一次遍历获得链表中间的元素
        //设置两个指针，一个走两步，一个走一步，快的走到头了，慢的指向中间的元素
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }
         //链表节点为偶数 1->2->3->4->5->6
            ListNode right = reverse(slow.next);
            ListNode left = head;
            for (int i=0;i<count;i++){
                ListNode lNext=left.next,rNext=right.next;
                right.next=left.next;
                left.next=right;
                left=lNext;right=rNext;
                //1->6->2->4->3 ->4->5->6
            }
            left.next=right;
            return head;
        //链表节点为奇数 1-2->3->4->5

    }
    //链表反转两种思路：1-2->3->4->5
    //  1.就地反转：把当前链表的节点，插入到虚拟头节点之后
    //  2.新建链表，头节点插入法
    public ListNode reverse(ListNode head){
        ListNode dummy=new ListNode(0);dummy.next=null;
        ListNode cur = head;
        while(cur!=null){
            ListNode t= new ListNode(cur.val);
            t.next=dummy.next;
            dummy.next=t;
            cur=cur.next;
        }
        return dummy.next;
    }

    @Test
    public void test(){
        int[] arr={1,2,3,4};
        ListNode head = createListNode(arr);
        ListNode listNode = reorderList(head);
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
