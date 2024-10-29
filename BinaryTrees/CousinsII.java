package BinaryTrees;

import static BinaryTrees.PrintTree.printBinaryTree;
import static BinaryTrees.TreeNodeUtil.TreeNode;

import java.util.*;

public class CousinsII {

    static TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> lst = new ArrayList<>();
        queue.offer(root);

        // Using BFS to calculate Level Order Sum
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lst.add(sum);
        }

        // Update node to sum of cousins
        int level = 0;
        queue.offer(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int sum = 0;
                TreeNode node = queue.poll();
                if (node.left != null) {
                    sum += node.left.val;
                }
                if (node.right != null) {
                    sum += node.right.val;
                }
                if (node.left != null) {
                    node.left.val = lst.get(level + 1) - sum;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = lst.get(level + 1) - sum;
                    queue.offer(node.right);
                }
            }
            level++;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);

        TreeNode ans = replaceValueInTree(root);
        printBinaryTree(ans);
    }
}
