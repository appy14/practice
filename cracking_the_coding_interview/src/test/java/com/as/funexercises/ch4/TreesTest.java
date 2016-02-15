package com.as.funexercises.ch4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

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

    @Test
    public void testCreateListAtEachDepth() {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n3.left = n6;
        n3.right = n7;

        List<List<TreeNode>> list = Trees.createListAtEachDepth(n1);
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0).size());
        assertEquals(2, list.get(1).size());
        assertEquals(4, list.get(2).size());

        assertEquals(n1, list.get(0).get(0));
        assertEquals(n2, list.get(1).get(0));
        assertEquals(n3, list.get(1).get(1));
        assertEquals(n4, list.get(2).get(0));
        assertEquals(n5, list.get(2).get(1));
        assertEquals(n6, list.get(2).get(2));
        assertEquals(n7, list.get(2).get(3));
    }

    @Test
    public void testFindNext() {
        TreeNodeWithParent n1 = new TreeNodeWithParent(1);
        TreeNodeWithParent n2 = new TreeNodeWithParent(2);
        TreeNodeWithParent n3 = new TreeNodeWithParent(3);

        n1.left = n2;
        n1.right = n3;
        n2.parent = n1;
        n3.parent = n1;

        TreeNodeWithParent n4 = new TreeNodeWithParent(4);
        n2.left = n4;
        n4.parent = n2;

        TreeNodeWithParent n5 = new TreeNodeWithParent(5);
        n2.right = n5;
        n5.parent = n2;

        TreeNodeWithParent n6 = new TreeNodeWithParent(6);
        n5.left = n6;
        n6.parent = n5;

        assertEquals(n2, Trees.findNext(n4));
        assertEquals(n1, Trees.findNext(n5));
        assertEquals(n6, Trees.findNext(n2));
    }
}
