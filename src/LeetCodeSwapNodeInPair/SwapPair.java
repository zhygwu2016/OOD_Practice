package LeetCodeSwapNodeInPair;

import com.sun.istack.internal.NotNull;

/**
 * Created by FLK on 11/4/18.
 */
public class SwapPair {

    /*
     *
     * */
    public ListNode swapPairs(@NotNull ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
    }

}
