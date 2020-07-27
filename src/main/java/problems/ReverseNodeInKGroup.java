package problems;

public class ReverseNodeInKGroup {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
         public void setNext(ListNode next) {
             this.next = next;
         }
         public ListNode getNext(ListNode next) {
             return next;
         }

         @Override
         public String toString() {
             return "ListNode{" +
                     "val=" + val +
                     ", next=" + next +
                     '}';
         }
     }

    public static ListNode solute(ListNode head, int k) {

        ListNode tail = head;
        for (int i = 0; i < k-1; i++) {
            if (tail == null || tail.next == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode nextRangeNode = tail.next;
        reverseRange(head, tail);
        head.next = solute(nextRangeNode, k);

        return tail;
    }
    private static void reverseRange(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != tail) {
            ListNode tempNextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNextNode;
        }
    }
}
