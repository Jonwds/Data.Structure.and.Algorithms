package Google面试;

public class LinkedList {
     int val;
     LinkedList next;

    public LinkedList(int val) {
        this.val = val;
        this.next=null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public static void print(LinkedList list){
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList:");
        while(list!=null){
            sb.append(list.val +"->");
            list=list.next;
        }
        sb.append("NULL");
        System.out.println(sb.toString());
    }
}
