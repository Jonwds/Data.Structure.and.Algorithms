package 算法;

import org.junit.Test;

import java.util.Stack;

/*
    给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
    它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
    你可以假设除了数字 0 之外，这两个数字都不会以零开头。
进阶:
    如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
示例:
    输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出: 7 -> 8 -> 0 -> 7
 */
public class LeetCode445 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        ListNode dummyHead = new ListNode(0);
        ListNode p=l1,q=l2,cur=dummyHead;int carry=0;
        while (p!=null || q!=null){
            if (p!=null){
                stack1.push(p.val);
                p=p.next;
            }
            if (q!=null){
                stack2.push(q.val);
                q=q.next;
            }
        }
        while ( stack1.size()>0 || stack2.size()>0){
            int x =(stack1.size()>0) ? stack1.pop():0;
            int y =(stack2.size()>0) ? stack2.pop():0;
            int sum = x + y + carry;
            carry = sum/10;
            result.push(sum%10);
        }
        if (carry>0){
           result.push(carry);
        }
        while(result.size()>0){
            cur.next=new ListNode(result.pop());
            cur=cur.next;
        }

        return dummyHead.next;
    }
    @Test
    public void test(){
        int[] arr1={5};int[] arr2={5};
        ListNode head1 = createListNode(arr1);ListNode head2 = createListNode(arr2);
        ListNode listNode = addTwoNumbers (head1,head2);
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
