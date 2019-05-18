package 剑指Offer;



//链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个结点。
public class Offer14 {
    public static void main(String[] args) {
        ListNode node =new ListNode(1);ListNode head = node;
        node.next=new ListNode(2); node=node.next;
        node.next=new ListNode(3);node=node.next;
        node.next=new ListNode(4);node=node.next;
        node.next=new ListNode(5);node=node.next;
        node.next=new ListNode(6);
        while(head.next!=null){
            System.out.println(head.val);
        }

    }
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //自己写的第一版
    //用两个指针来遍历,当第一个指针遍历了k次,第二个指针开始同时遍历,
    // 第一个指针到链表尾部,第二个指针即指向倒数第k个节点
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode first=head;
        ListNode second=head;
        int count=0;
        while(first.next!=null){
            first=first.next;count++;
            if(count>=k)
                second=second.next;
        }
        return second;
    }

    //注意鲁棒性:
    // 1.输入的head为空指针;
    // 2.k=0;
    // 3.链表节点数<k
    public ListNode FindKthToTail2(ListNode head,int k) {
        if(head==null || k==0)
            return null;
        ListNode first=head;
        ListNode second=head;
       for (int i=0;i<k-1;++i){
           if (first.next!=null)
               first=first.next;
           else
               return null;
       }

        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }
}
