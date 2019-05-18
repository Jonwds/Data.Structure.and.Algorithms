package 剑指Offer;
/*  复杂链表的复制
    输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Offer25 {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode(int label) { this.label = label; }
    }
    //分解成三个步骤：
    // 1.复制链表的每个节点N成N',并连接到N的后面
    // 2.复制N的random指针
    // 3.拆分成两个链表
    public RandomListNode Clone(RandomListNode pHead)
    {
        CloneNode(pHead);
        CloneRandom(pHead);
        return ReconnectNodes(pHead);
    }

    public void CloneNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode!=null){
            RandomListNode pCloned=new RandomListNode(pNode.label);
            pCloned.next=pNode.next;
            pCloned.random=null;
            pNode.next=pCloned;
            pNode=pCloned.next;
        }
    }

    public void CloneRandom(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode!=null){
            RandomListNode pCloned=pNode.next;
            if(pNode.random!=null)
                pCloned.random=pNode.random.next;// N'->S'
            pNode=pCloned.next;
        }
    }
    public RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;RandomListNode pClonedNode = null;
        if (pNode!=null){
            pClonedHead=pNode.next;pClonedNode=pNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }
        while (pNode!=null){
            pClonedNode.next = pNode.next;
            pClonedNode=pClonedNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }
        return pClonedHead;
    }
}
