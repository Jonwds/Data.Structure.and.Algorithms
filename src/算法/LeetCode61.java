package 算法;

import org.junit.Test;

/*
    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:
    输入: 1->2->3->4->5->NULL, k = 2
    输出: 4->5->1->2->3->NULL
解释:
    向右旋转 1 步: 5->1->2->3->4->NULL
    向右旋转 2 步: 4->5->1->2->3->NULL

示例 2:
    输入: 0->1->2->NULL, k = 4
    输出: 2->0->1->NULL
解释:
    向右旋转 1 步: 2->0->1->NULL
    向右旋转 2 步: 1->2->0->NULL
    向右旋转 3 步: 0->1->2->NULL
    向右旋转 4 步: 2->0->1->NULL
 */
public class LeetCode61 {
     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
      /*  超时了！！！！
      public ListNode rotateRight(ListNode head, int k) {
            ListNode p = head;
            while(k > 0){
                p = RotateRight(p);

                k--;
            }
            return p;
        }
        public ListNode RotateRight(ListNode head){
            if(head.next == null)
                return null;
            ListNode dummy = new ListNode(0); dummy.next = head;
            ListNode p = head,pre=dummy;
            while(p.next != null){
                p=p.next;pre=pre.next;
            }
            p.next = head;
            pre.next=null;
            return p;
        }*/


      //[1,2,3,4,5]
     public ListNode rotateRight(ListNode head, int k) {
         if(head==null || k==0 )
             return head;
         int length=1;
         ListNode fast = head,slow =null;
         while( fast.next !=null){
             fast=fast.next;
             length++;
         }
         length=length-(k%length);
         fast.next=head;
         slow=fast;
         fast=head;
         for (int i=0;i<length;i++){
             fast=fast.next;slow=slow.next;
         }
         slow.next=null;
         return fast;
      }



    @Test
    public void test(){
        int[] arr={1,2};
        ListNode head = createListNode(arr);
        ListNode listNode = rotateRight(head,2);
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
