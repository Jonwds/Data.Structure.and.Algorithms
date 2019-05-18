package 算法;

import org.junit.Test;

import java.util.Stack;

public class LeetCode92 {
     class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>n)
            return null;
        ListNode dummyHead = new ListNode(0);//定义一个虚拟头节点
        dummyHead.next = head;

        ListNode mPre = dummyHead;//m位置的前一个节点
        ListNode nNext = null;//n位置的后一个节点

        ListNode curNode = null; //当前反转的节点
        ListNode nextNode = null; //当前反转的后一个节点

        for(int i=0;i<m-1;i++)
            mPre = mPre.next;

        curNode = mPre.next; //开始反转的节点 2
        nextNode = curNode.next;// 3
        nNext=nextNode ;
        for(int i=0;i<n-m;i++){
            //  nNext保存nextNode的下一个节点, nextNode的next指向cur节点
            nNext=nextNode.next;nextNode.next=curNode;
            //移到下一个待反转节点
            curNode=nextNode;nextNode=nNext;
        }
        // 反转完毕，需要将 mPre 与 nNext 和 cur连接
        mPre.next.next=nNext;
        mPre.next=curNode;
        return dummyHead.next;
    }



    @Test
    public void test(){
         int[] arr={1,2,3,4,5};
         ListNode head = createListNode(arr);
         ListNode listNode = reverseBetween (head, 2, 4);
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
