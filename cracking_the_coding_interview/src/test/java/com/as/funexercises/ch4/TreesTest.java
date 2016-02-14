package com.as.funexercises.ch4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

    @Test
    public void testCreateMinimalTree() {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = Trees.createTree(a);

        assertNotNull(root);

        assertEquals(4, root.data);
        assertNotNull(root.left);
        assertNotNull(root.right);

        TreeNode n = root.left;
        assertEquals(2, n.data);
        assertNotNull(n.left);
        assertNotNull(n.right);
        assertEquals(1, n.left.data);
        assertEquals(3, n.right.data);

        TreeNode n1 = n.left;
        assertNull(n1.left);
        assertNull(n1.right);

        n1 = n.right;
        assertNull(n1.left);
        assertNull(n1.right);

        n = root.right;
        assertEquals(6, n.data);
        assertNotNull(n.left);
        assertNotNull(n.right);
        assertEquals(5, n.left.data);
        assertEquals(7, n.right.data);

        n1 = n.left;
        assertNull(n1.left);
        assertNull(n1.right);

        n1 = n.right;
        assertNull(n1.left);
        assertNull(n1.right);

        assertTrue(Trees.isTreeBalanced(root));
    }

    @Test
    public void testCreateMinimalTree2() {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        TreeNode root = Trees.createTree(a);

        assertNotNull(root);

        assertEquals(4, root.data);
        assertNotNull(root.left);
        assertNotNull(root.right);

        TreeNode n = root.left;
        assertEquals(2, n.data);
        assertNotNull(n.left);
        assertNotNull(n.right);
        assertEquals(1, n.left.data);
        assertEquals(3, n.right.data);

        TreeNode n1 = n.left;
        assertNull(n1.left);
        assertNull(n1.right);

        n1 = n.right;
        assertNull(n1.left);
        assertNull(n1.right);

        n = root.right;
        assertEquals(6, n.data);
        assertNotNull(n.left);
        assertNotNull(n.right);
        assertEquals(5, n.left.data);
        assertEquals(7, n.right.data);

        n1 = n.left;
        assertNull(n1.left);
        assertNull(n1.right);

        n1 = n.right;
        assertNull(n1.left);
        assertNotNull(n1.right);
        assertEquals(8, n1.right.data);

        assertTrue(Trees.isTreeBalanced(root));
    }
}
