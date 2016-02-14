package com.as.funexercises.ch4;

public class Trees {

    public static boolean isTreeBalanced(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException(
                    "Cannot check if tree is balanced for a null tree");
        }
        computeHeight(root);

        int leftNodeHeight = 0;
        int rightNodeHeight = 0;

        if (root.left != null) {
            leftNodeHeight = root.left.getHeight();
        }

        if (root.right != null) {
            rightNodeHeight = root.right.getHeight();
        }

        return (Math.abs(leftNodeHeight - rightNodeHeight) < 2);
    }

    private static int computeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.height = Math.max(computeHeight(node.left),
                computeHeight(node.right)) + 1;
        return node.height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(30);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(40);
        n1.left = n3;

        TreeNode n4 = new TreeNode(50);
        n3.left = n4;

        System.out.println(isTreeBalanced(root));
    }
}
