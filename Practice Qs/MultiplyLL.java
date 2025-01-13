public class MultiplyLL {

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Brute Force (Fails for multiple testcases)
    public long multiplyTwoLists(Node first, Node second) {
        String n1 = "";
        String n2 = "";
        Node temp = first;
        while (temp != null) {
            n1 += temp.data;
            temp = temp.next;
        }
        temp = second;
        while (temp != null) {
            n2 += temp.data;
            temp = temp.next;
        }
        return (Long.parseLong(n2) * Long.parseLong(n1)) % mod;
    }

    static long mod = 1000000007;

    public long changeToNumber(Node head) {
        Node temp = head;
        long num = 0;
        while (temp != null) {
            num = num * 10 + temp.data;
            temp = temp.next;
        }
        return num;
    }

    public long multiplyLists(Node first, Node second) {
        long n1 = changeToNumber(first);
        long n2 = changeToNumber(second);
        return (n1 * n2) % mod;
    }

    public static void main(String[] args) {
        MultiplyLL multiplyLL = new MultiplyLL();
        Node ll = multiplyLL.new Node(499);
        ll.next = multiplyLL.new Node(786);
        ll.next.next = multiplyLL.new Node(632);

        Node ll2 = multiplyLL.new Node(290);
        ll2.next = multiplyLL.new Node(69);
        ll2.next.next = multiplyLL.new Node(7);

        System.out.println(multiplyLL.multiplyTwoLists(ll, ll2));
        System.out.println(multiplyLL.multiplyLists(ll, ll2));

    }
}
