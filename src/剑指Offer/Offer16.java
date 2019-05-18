package 剑指Offer;
/*  合并两个排序的链表
    输入两个单调递增的链表，输出两个链表合成后的链表，
    当然我们需要合成后的链表满足单调不减规则。
 */
public class Offer16 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //非递归版本
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode resultHead=null;ListNode curNode=null;
        while(list1!=null && list2!=null){
            if(list1.val<= list2.val){
                if(resultHead==null){
                    resultHead=list1;curNode=list1;
                }else {
                    curNode.next=list1;
                    curNode=curNode.next;
                }
                list1=list1.next;
            }else{
                if(resultHead==null){
                    resultHead=list2;curNode=list2;
                }else {
                    curNode.next=list2;
                    curNode=curNode.next;
                }
                list2=list2.next;
            }
        }
        if(list1==null){
            curNode.next=list2;
        }else {
            curNode.next=list1;
        }
        return resultHead;
    }

    //递归版本
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode mergeHead = null;
        if(list1.val<=list2.val){
            mergeHead=list1;
            mergeHead.next=Merge2(list1.next,list2);
        }else {
            mergeHead=list2;
            mergeHead.next=Merge2(list1,list2.next);
        }
        return mergeHead;
    }
}
