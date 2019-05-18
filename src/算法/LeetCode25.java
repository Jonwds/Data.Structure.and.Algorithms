package 算法;

import org.junit.Test;

/*
    给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

示例 :
    给定这个链表：1->2->3->4->5
    当 k = 2 时，应当返回: 2->1->4->3->5
    当 k = 3 时，应当返回: 3->2->1->4->5
说明 :
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //给定这个链表：1->2->3->4->5
    //    当 k = 2 时，应当返回: 2->1->4->3->5
    //    当 k = 3 时，应当返回: 3->2->1->4->5
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        ListNode dummyHead = new ListNode(0);dummyHead.next = head;
        ListNode pre = dummyHead;
        while(p!=null){
            int n = k;
            ListNode inside = p;
            // 检查是否可以翻转
            while(n>0 && inside!=null){
                inside = inside.next;
                n--;
            }
            if(n == 0){ //说明可以反转
                ListNode node1 = inside; //node1 表示node2要指向的节点
                ListNode node2 = p; //node2 表示每次反转的节点
                n = k;  // 反转k次,每次反转1个节点
                while(n >0){
                    ListNode next = node2.next;
                    node2.next = node1; //反转
                    //进行下一个节点的反转
                    node1 = node2;node2 = next;
                    n --;
                }
                pre.next = node1;//反转k次结束,pre要指向node1,即反转后的头部
                pre = p;  //反转后的尾部
            }
            //继续检查剩余的部分能否反转
            p = inside;
        }
        return dummyHead.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }

        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }

            if (next != null) {  // head 为链表翻转后的尾节点
                head.next = reverseKGroup2(next, k);
            }
            return prev;    // prev 为链表翻转后的头结点

        }else // 不满住翻转条件，直接返回 head 即可
            return head;
    }
    @Test
    public void test(){
        int[] arr1={1,2,3,4,5};
        ListNode head1 = createListNode(arr1);
        ListNode listNode = reverseKGroup(head1,2);
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
