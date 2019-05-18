package 算法;

import org.junit.Test;

/*
请判断一个链表是否为回文链表。

示例 1:
    输入: 1->2
    输出: false

示例 2:
    输入: 1->2->2->1
    输出: true
进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LeetCode234 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        //1.找到中间节点
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right = reverse(slow.next);
        ListNode left = head;
        while(right!=null){
            if(head.val!=right.val)
                return false;
            head=head.next;right=right.next;
        }
        return true;
    }
    //1->2->3->4->5
    public ListNode reverse(ListNode head){
        ListNode dummy=new ListNode(0);dummy.next=head;
        ListNode cur = head.next, pre = head;
        while(cur!=null){
            pre.next=cur.next;
            cur.next=dummy.next;
            dummy.next=cur;
            cur=pre.next;
        }
        return dummy.next;
    }
    @Test
    public void test(){
        int[] arr={1,2,3,3,2,1};
        ListNode head = createListNode(arr);
        System.out.println(isPalindrome(head));
        //printListNode(listNode);

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
