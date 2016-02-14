package com.as.funexercises.ch4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TreesTest {

    @Test
    public void testBalancedTree() {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(30);
        root.left = n1;
        root.right = n2;

        assertTrue(Trees.isTreeBalanced(root));

        TreeNode n3 = new TreeNode(40);
        n1.left = n3;

        assertTrue(Trees.isTreeBalanced(root));

        TreeNode n4 = new TreeNode(50);
        n3.left = n4;
        assertFalse(Trees.isTreeBalanced(root));

        try {
            Trees.isTreeBalanced(null);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }
}
