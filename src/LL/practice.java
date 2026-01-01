package LL;

public class practice {
    class ListNode {
     int val;
   ListNode next;
    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

     ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
  }
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode current  = head;
        ListNode Next = head.next;
        while(Next!=null){
            ListNode temp = Next.next;
            Next.next = current;
            current = Next;
            Next = temp;
        }
        return head;
    }
}
