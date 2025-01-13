public class GCDofLL {

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

    private static int GCD(int a, int b){
        while (b!=0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode next = head.next;

        while(next != null){
            int gcdVal = GCD(curr.val, next.val);
            ListNode nn = new ListNode(gcdVal);

            curr.next = nn;
            nn.next = next;
            curr = next;
            next = next.next;
        }

        return head;

    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(18);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = node1;
        ListNode ans = insertGreatestCommonDivisors(head);
        printList(ans);
    }
}
