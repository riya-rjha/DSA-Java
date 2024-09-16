public class AddTwoNoLL {

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

    // Reverse a Linked List
    static ListNode reverseLL(ListNode head) {
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

    // Calculate sum of numbers of Linked List
    static long getSumOfNodes(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();

        while (temp1 != null) {
            n1.append(temp1.val);
            temp1 = temp1.next;
        }
        // System.out.println("Num1 : " + n1);

        while (temp2 != null) {
            n2.append(temp2.val);
            temp2 = temp2.next;
        }
        // System.out.println("Num2 : " + n2);

        long num1 = Long.parseLong(n1.toString());
        // System.out.println(num1);
        long num2 = Long.parseLong(n2.toString());
        // System.out.println(num2);

        return num1 + num2;
    }

    // Convert number to Linked List
    static ListNode convertToLL(long number) {
        // System.out.println("Value of number in func: " + number);
        ListNode head = null;
        ListNode curr = null;

        if (number == 0) {
            return new ListNode(0);
        }

        // Build the linked list from least significant to most significant digit
        while (number > 0) {
            int ld = (int) (number % 10); // Get the last digit
            // System.out.println("Digit: " + ld);
            ListNode nn = new ListNode(ld);
            // System.out.println("Node val: " + nn.val);
            if (head == null) {
                head = nn;
                curr = head;
            } else {
                curr.next = nn;
                curr = curr.next;
            }
            number /= 10; // Remove the last digit
        }

        return head;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1 = reverseLL(l1);
        // printLL(revL1);
        ListNode revL2 = reverseLL(l2);
        // printLL(revL2);
        long sum = getSumOfNodes(revL1, revL2);
        // System.out.println(sum);
        ListNode head = convertToLL(sum);
        return head;
    }

    static void printLL(ListNode result) {
        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) {
                System.out.print(" -> ");
            }
            result = result.next;
        }
        System.out.println();
    }

    // Optimized Approach
    // Above method does not work for BigIntegers - 5 testcases failed

    static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // List l1: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // List l2: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // // Reverse a Linked List
        // ListNode result = reverseLL(l2);
        // printLL(result);

        // // Calculate sum of nodes of a Linked List
        // int sum = getSumOfNodes(result);
        // System.out.println("Sum of nodes: " + sum);

        // // Convert number to a Linked List
        // ListNode ans = convertToLL(sum);
        // ListNode newAns = reverseLL(ans);
        // printLL(newAns);

        // ListNode nn = addTwoNumbers(l1, l2);
        // printLL(nn);

        // System.out.println(getSumOfNodes(l1, l2));

        // Creating the linked list lst1 = [9]
        ListNode lst1 = new ListNode(1);
        ListNode current = lst1;
        for (int i = 0; i < 10; i++) {
            current.next = new ListNode(0);
            current = current.next;
        }
        current.next = new ListNode(1);

        // Creating the linked list lst2 = [5,6,4]
        ListNode lst2 = new ListNode(5);
        lst2.next = new ListNode(6);
        lst2.next.next = new ListNode(4);

        // Adding the two numbers
        ListNode result = addTwoNumbersOptimized(lst1, lst2);
        printLL(result);

        // ListNode t1 = reverseLL(lst1);
        // ListNode t2 = reverseLL(lst2);
        // printLL(t1);
        // printLL(t2);
        // ListNode ans = convertToLL(getSumOfNodes(t1, t2));
        // printLL(ans);

    }
}
