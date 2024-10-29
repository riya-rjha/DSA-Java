package BinaryTrees;

import static BinaryTrees.TreeNodeUtil.TreeNode;

public class PrintTree {

    static void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printBinaryTree(root.left);
        System.out.print(root.val + " -> ");
        printBinaryTree(root.right);
    }
}
