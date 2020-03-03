package com.practice.tree.medium;

import com.practice.tree.TreeNode;

import java.util.List;
import java.util.Stack;


public class BSTIterator {
    List<Integer> vals ;
    int idx = 0;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        /*vals = new ArrayList<>();
        inorder(root,vals);*/
        this.stack = new Stack<TreeNode>();
        simInorder(root);
    }

    private void simInorder(TreeNode root) {
        while(root!= null){
            stack.push(root);
            root = root.left;
        }
    }

    private void inorder(TreeNode root, List<Integer> vals) {
        if(root != null){
            inorder(root.left,vals);
            vals.add(root.val);
            inorder(root.right,vals);
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode t = stack.pop();
        if(t.right != null){
            simInorder(t.right);
        }
//        return vals.get(idx++);
        return t.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
//        return idx<vals.size();
        return stack.size()>0;
    }
}
