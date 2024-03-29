package 剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/*
    输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 */

public class Offer03 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrayList =new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return  arrayList;

    }



    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode==null)
            return arrayList;
        printList(listNode,arrayList);
        return arrayList;
    }
    public void  printList(ListNode listNode,ArrayList<Integer> arrayList){
        if(listNode.next!=null)
            printList(listNode.next,arrayList);
        arrayList.add(listNode.val);
    }
}


//递归的思路，只要链表不为空，一直往后进行遍历，然后直到到达链表的末尾，就开始用数组保存下来结果
