package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */

public class NAryPostOrder {
    public List<Integer> postorder(Node root) {
        List<Integer> l = new ArrayList<>();
        if(root == null)
            return l;
        Stack<Node> s = new Stack<>();
        s.push(root);
        Stack<Node> s2 = new Stack<>();
        while(!s.isEmpty()){
            Node t = s.pop();
            s2.push(t);
            List<Node> c = t.children;
            if(c != null && c.size() > 0) {
                for (Node node : c) {
                    s.push(node);
                }
            }
        }
        while(!s2.isEmpty()){
            l.add(s2.pop().val);
        }
        return l;
    }
}
