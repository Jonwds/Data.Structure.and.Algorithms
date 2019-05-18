package 剑指Offer;
/*
    输入一个链表，反转链表后，输出新链表的表头。
 */
public class Offer15 {

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
 }

 // 想到以下几种测试用例：
 //  输入的指针为空
 //  输入的链表只有一个节点
 //  输入的链表有多个节点
 public ListNode ReverseList(ListNode head) {
     ListNode nowNode=head;
     ListNode preNode=null,nextNode=null,lastNode=null;
     while(nowNode!=null){
         nextNode=nowNode.next;
         if(nextNode==null)
             lastNode=nowNode;
         nowNode.next=preNode;
         preNode=nowNode;
         nowNode=nextNode;
     }
     return lastNode;

 }
}
