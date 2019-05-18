package 算法;

import org.junit.Test;

/*
    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
    你应当保留两个分区中每个节点的初始相对位置。

示例:
    输入: 1->4->3->2->5->2, x = 3
    输出: 1->2->2->4->3->5
 */
public class LeetCode86 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    //输入: 1->4->3->2->5->2, x = 3
    //    输出: 1->2->2->4->3->5
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode left = null;ListNode right = null;
        ListNode leftNode = left;ListNode rightNode = right;
        ListNode cur = head;
        while (cur!=null){
            if(cur.val < x){
                if(left==null){
                    left = new ListNode(cur.val);
                    leftNode=left;
                }else{
                    ListNode temp=new ListNode(cur.val);
                    leftNode.next=temp;
                    leftNode=temp;
                }
            }else{  //   cur.val >= x
                if(right==null){
                    right = new ListNode(cur.val);
                    rightNode=right;
                }else{
                    ListNode temp=new ListNode(cur.val);
                    rightNode.next=temp;
                    rightNode=temp;
                }
            }
            cur=cur.next;
        }
        if (leftNode !=null){
            leftNode.next=right;
            return left;
        } else
            return right;
    }
    @Test
    public void test(){
        int[] arr={1};
        ListNode head = createListNode(arr);
        ListNode listNode = partition (head,0);
        printListNode(listNode);

    }
    private void printListNode( ListNode head){
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
        ListNode head = new  ListNode(arr[0]);
        ListNode cur = head;
        for (int i=1;i<arr.length;i++){
            cur.next=new  ListNode(arr[i]);cur=cur.next;
        }
        return head;
    }
}
