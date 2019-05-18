package 算法;

import org.junit.Test;

/*
    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
示例 1:
    输入: 1->1->2
    输出: 1->2
示例 2:
    输入: 1->1->2->3->3
    输出: 1->2->3
 */
public class LeetCode83 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
     }
    //输入: 1,1,2,2,3,3,4,4,5,6,6}
    //    输出: 1->2->3->4->5->6
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur.next!=null) {
            while (next!=null && next.val == cur.val  ) {
                next = next.next;
            }
            cur.next = next;
            if(next==null)
                break;
            cur = cur.next;next = next.next;
        }
        return head;
    }
    //优化版本！
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else
                cur=cur.next;
        }
        return head;
    }

    @Test
    public void test(){
        int[] arr={1,1,2,2,3,3,4,4,5,6,6};
         ListNode head = createListNode(arr);
         ListNode listNode = deleteDuplicates (head);
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
