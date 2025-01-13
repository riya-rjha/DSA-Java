import java.util.HashMap;

public class DeleteNodesFromLL {

    public class ListNode {
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

    // HashSet has better complexity than HashMap
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], nums[i]);
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null) {
            if (hm.containsKey(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next; // head

    }

    public void toArrayList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int[] heads = { 1, 2, 3, 4, 5 };
        DeleteNodesFromLL headVal = new DeleteNodesFromLL();
        ListNode h = headVal.new ListNode(heads[0]);
        ListNode curr = h;
        for (int i = 1; i < heads.length; i++) {
            curr.next = headVal.new ListNode(heads[i]);
            curr = curr.next;
        }
        ListNode ans = headVal.modifiedList(nums, h);
        headVal.toArrayList(ans);
    }
}
