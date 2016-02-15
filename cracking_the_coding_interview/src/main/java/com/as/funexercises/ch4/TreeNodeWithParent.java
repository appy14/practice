package com.as.funexercises.ch4;

public class TreeNodeWithParent extends TreeNode {

    TreeNodeWithParent parent;

    public TreeNodeWithParent(int id) {
        super(id);
    }

    public TreeNodeWithParent(int data, TreeNode left, TreeNode right) {
        super(data, left, right);
    }

}
