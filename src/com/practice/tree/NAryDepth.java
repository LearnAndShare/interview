package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class NAryDepth {
    public int maxDepth(Node root) {
        int h = 0;

        if(root != null) {

            Stack<Node> s = new Stack<>();
            s.push(root);
            while (!s.isEmpty()) {

                List<Node> l = new ArrayList<>();
                while (!s.isEmpty()) {
                    Node sn = s.pop();
                    if(sn != null) {
                        l.add(sn);
                    }
                }
                h = h+1;
                for (Node ln : l) {

                    List<Node> snch = ln.children;
                    if (snch!= null && snch.size() > 0) {
                       for (Node nc : snch) {
                            s.push(nc);
                        }

                    }
                }

            }
        }
        return h;
    }


    int cnt =0;
    public int maxDepthR(Node root) {
        if(root != null){
            helper(root,1);
        }
        return cnt;
    }

    public void helper(Node root,int level){
        if(root == null )
            return;
        cnt = Math.max(cnt,level);
        List<Node> c = root.children;
        for (Node nc : c) {
            helper(nc,level+1);
        }

    }

}
