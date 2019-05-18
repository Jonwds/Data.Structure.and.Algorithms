package 算法;

import org.junit.Test;

/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
    输入: 1->2->3->3->4->4->5
    输出: 1->2->5
示例 2:
    输入: 1->1->1->2->3
    输出: 2->3
 */
public class LeetCode82 {
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
     //    输入: 1->1->1->2->3
     //    输出: 2->3
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);dummyHead.next=head;
        ListNode pre = dummyHead,cur=head;
        boolean flag = false;
        while( cur!=null&&cur.next!=null) {
            if (cur.next.val==cur.val){
                cur.next=cur.next.next;
                flag=true;
            }else{
                if(flag){
                    pre.next=cur.next;
                    cur=pre.next;
                    flag=false;
                }else{
                    pre=cur;cur=cur.next;
                }
            }
        }
        if(flag){
            pre.next=cur.next;
            cur=pre.next;
        }
        return dummyHead.next;
    }
    @Test
    public void test(){
        int[] arr1={1,1};
        ListNode head1 = createListNode(arr1);
        ListNode listNode = deleteDuplicates (head1);
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
