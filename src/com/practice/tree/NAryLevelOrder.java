package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root != null){
            LinkedList<Node> s2 = new LinkedList<>();
            LinkedList<Node> s1 = new LinkedList<>();
            s1.push(root);
            List<Integer> l = new ArrayList<>();
            while(!s1.isEmpty()){
                Node n = s1.pop();
                l.add(n.val);
                if(n.children != null && n.children.size()>0)
                    s2.addAll(n.children);
                if(s1.isEmpty()){
                    list.add(l);
                    l = new ArrayList<>();
                    s1 = s2;
                    s2 = new LinkedList<>();
                }

            }
        }
        return list;
    }


   /*
   Recursive
   public List<List> levelOrder(Node root) {
        List<List> li = new ArrayList<List>();
        if(root==null)
            return li;
        helper(0, root, li);
        return li;
    }
    public void helper(int level, Node root, List<List> li){
        if(root==null)
            return;
        if(level==li.size()){
            li.add(new ArrayList());
        }
        li.get(level).add(root.val);
        for(Node child: root.children){
            helper(level+1, child, li);
        }
    }*/
}
