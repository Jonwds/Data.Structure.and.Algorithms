package 算法;

import org.junit.Test;

/*
    对链表进行插入排序。
    插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

插入排序算法：
    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    重复直到所有输入数据插入完为止。
 */
public class LeetCode147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;

        ListNode dummyHead = new ListNode(0);dummyHead.next=head;
        ListNode sorted = head,cur=head.next;
        while(cur!=null){
            if(cur.val < sorted.val){
                ListNode next = cur.next;
                ListNode pre = dummyHead;
                ListNode p=dummyHead.next;
                //找到插入的位置
                while(p.val < cur.val){
                    pre=p; p=p.next;
                }
                //在链表头部插入
                //if(pre==dummyHead){

                ListNode temp=new ListNode(cur.val);
                pre.next=temp;temp.next=p;
                sorted.next=next;

                // }else{
                //     ListNode temp=new ListNode(cur.val);
                //     pre.next=temp;temp.next=p;p.next=next;
                // }
                cur=next;

            }else{
                sorted= sorted.next;
                cur=cur.next;
            }
        }
        return dummyHead.next;
    }
    @Test
    public void test(){
        int[] arr1={6,5,3,1,8,7,2,4};
        ListNode head1 = createListNode(arr1);
        ListNode listNode = insertionSortList(head1);
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
