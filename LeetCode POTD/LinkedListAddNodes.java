public class LinkedListAddNodes {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse linkedList

        l1 = reverseListNode(l1);
        l2 = reverseListNode(l2);

        // Calculate string number and convert to integer

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = new ListNode();

        while (temp1 != null && temp2 != null) {
            temp3.val = temp1.val + temp2.val;
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        temp3.next = null;

        return temp3;

    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode nn = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode nn2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(addTwoNumbers(nn, nn2));
    }
}
