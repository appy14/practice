package com.as.funexercises.ch4;

public class Trees {

    // Ex 4.1
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
}
