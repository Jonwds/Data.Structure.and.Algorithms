package Google面试;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import org.junit.Test;

import java.security.DigestException;
import java.util.Arrays;

public class LinkedListReverser {

    public LinkedList reverseLinkedList(LinkedList head){
        LinkedList dummy = new LinkedList(0); dummy.next=null;
        while(head!=null){
            LinkedList next = head.next;
            head.next = dummy.next ;
            dummy.next=head;
            head = next;
        }
        return dummy.next;
    }

    public LinkedList DiGuiReverseLinkedList(LinkedList head){
        if(head==null || head.next==null)
            return head;
        LinkedList newHead = DiGuiReverseLinkedList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    @Test
    public void test(){
        LinkedList.print(
                DiGuiReverseLinkedList(LinkedListCreator.create( Arrays.asList(1, 2, 3, 4, 5) ) ));
    }

}
