public class AlternatingLL {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node[] alternatingSplitList(Node head) {
        Node temp = head;
        Node odd = null, even = null;
        Node a1 = null, a2 = null;
        int count = 0;
        while (temp != null) {
            if (count % 2 == 0) {
                if (a1 == null) {
                    a1 = temp;
                    even = a1;
                } else {
                    even.next = temp;
                    even = even.next;
                }
            } else {
                if (a2 == null) {
                    a2 = temp;
                    odd = a2;
                } else {
                    odd.next = temp;
                    odd = odd.next;
                }
            }
            count++;
            temp = temp.next;
        }

        if (even != null) {
            even.next = null;
        }
        if (odd != null) {
            odd.next = null;
        }

        return new Node[] { a1, a2 };
    }

    public static void printAns(Node ans) {
        Node temp1 = ans;
        System.out.println("Linked List: ");
        while (temp1 != null) {
            System.out.print(temp1.data + "->");
            temp1 = temp1.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(6);
        Node[] ans = alternatingSplitList(head);
        printAns(ans[0]);
        System.out.println();
        printAns(ans[1]);
    }
}
