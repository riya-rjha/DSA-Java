import java.util.LinkedList;
import java.util.Queue;

public class MinOpsToSortBinaryTree {

    static class TreeNode {
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

    static TreeNode buildTree(Integer[] values) {
        if (values.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);
        int i = 1;
        while (i < values.length) {
            TreeNode curr = queue.poll();
            if (values[i] != null) {
                curr.left = new TreeNode(values[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                curr.right = new TreeNode(values[i]);
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    static int minimumOperations(TreeNode root) {
        
    }

    static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(10);
        printTree(root);
        System.out.println();
        Integer[] values = { 1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10 };
        TreeNode root2 = buildTree(values);
        printTree(root2);

    }
}
