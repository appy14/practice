package com.as.funexercises.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    // Ex 4.3
    public static TreeNode createTree(int[] a) {
        if (a.length == 0) {
            throw new IllegalArgumentException();
        }

        return createAndUpdateNodes(a, 0, a.length - 1);
    }

    private static TreeNode createAndUpdateNodes(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = createAndUpdateNodes(a, start, mid - 1);
        node.right = createAndUpdateNodes(a, mid + 1, end);
        return node;
    }

    // Ex 4.4
    public static List<List<TreeNode>> createListAtEachDepth(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        List<List<TreeNode>> list = new ArrayList<List<TreeNode>>();
        addToList(root, 0, list);
        return list;
    }

    private static void addToList(TreeNode node, int index,
            List<List<TreeNode>> list) {
        if (node == null) {
            return;
        }
        if (index >= list.size()) {
            list.add(index, new LinkedList<TreeNode>());
        }

        list.get(index).add(node);
        addToList(node.left, index + 1, list);
        addToList(node.right, index + 1, list);
    }

    public static TreeNode findNext(TreeNodeWithParent node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return findLeftMost(node.right);
        }

        if (node.parent != null) {
            TreeNodeWithParent p = node;
            while (p.parent != null) {
                if (p.parent.left == p) {
                    return p.parent;
                }
                p = p.parent;
            }
        }

        return null;
    }

    private static TreeNode findLeftMost(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
