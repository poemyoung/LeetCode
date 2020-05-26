package Four31_40.ReverseList;

/**
 * 单链表反转
 */
public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode pre  = null;
        ListNode cur = head;
         while (cur!=null){
            ListNode tmpNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmpNext;
        }
         return pre;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
  public ListNode buildList(int[] a){
        ListNode head = new ListNode(0,null);
        ListNode headR = head;
        for (int t : a){
            head.next = new ListNode(t,null);
            head = head.next;
        }
        return headR;
  }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Reverse test = new Reverse();

    }
}
