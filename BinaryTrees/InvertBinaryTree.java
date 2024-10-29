package BinaryTrees;

import java.util.*;
import static BinaryTrees.TreeNodeUtil.TreeNode;
import static BinaryTrees.PrintTree.printBinaryTree;

public class InvertBinaryTree {

    // Iterative Approach
    static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode leftPart = node.left;
            TreeNode rightPart = node.right;
            node.left = rightPart;
            node.right = leftPart;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    // Recursive Approach
    static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null)
            return root;
        if (root.left != null)
            invertTreeRecursive(root.left);
        if (root.right != null)
            invertTreeRecursive(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printBinaryTree(root);
        System.out.println();
        printBinaryTree(invertTree(root));
        System.out.println();
        printBinaryTree(invertTreeRecursive(root));

    }
}
