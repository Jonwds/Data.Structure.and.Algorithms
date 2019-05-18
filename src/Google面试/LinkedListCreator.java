package Google面试;

import java.util.List;

public class LinkedListCreator {
    public static LinkedList create(List<Integer> list){
        if (list.isEmpty())
            return null;
        LinkedList head = new LinkedList(list.get(0));
        LinkedList headofSubList = create(list.subList(1,list.size()));
        head.next=headofSubList;
        return head;
    }
}
