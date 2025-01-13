
public class LLBinTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            // Linked List has been traversed and answer found
            return true;
        }
        if (root == null) {
            // Tree has been traversed but answer not found
            return false;
        }
        if (root.val != head.val) {
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (dfs(head, root)) {
            return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public static void main(String[] args) {

        LLBinTree valueTree = new LLBinTree();
        TreeNode root = valueTree.new TreeNode(1);
        root.left = valueTree.new TreeNode(4);
        root.right = valueTree.new TreeNode(4);
        root.left.right = valueTree.new TreeNode(2);
        root.left.right.left = valueTree.new TreeNode(1);
        root.right.left = valueTree.new TreeNode(2);
        root.right.left.left = valueTree.new TreeNode(6);
        root.right.left.right = valueTree.new TreeNode(8);
        root.right.left.right.left = valueTree.new TreeNode(1);
        root.right.left.right.right = valueTree.new TreeNode(3);

        LLBinTree valueLL = new LLBinTree();
        LLBinTree.ListNode head = valueLL.new ListNode(4);
        head.next = valueLL.new ListNode(2);
        head.next.next = valueLL.new ListNode(8);

        LLBinTree ans = new LLBinTree();
        System.out.println(ans.isSubPath(head, root));

    }
}
