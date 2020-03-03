package com.practice.tree.easy;

import com.practice.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NAryPreOrder {
    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();
        if (root != null) {

            Node t = root;
            LinkedList<Node> l = new LinkedList<>();

            l.add(t);


            while (!l.isEmpty()) {
                Node n = l.pollFirst();
                list.add(n.val);
                if (n.children != null && !n.children.isEmpty()) {
                    for (int i = n.children.size() - 1; i >= 0; i--) {
                        l.addFirst(n.children.get(i));
                    }


                }
            }
        }
        return list;
    }

    public void preorderrecursive(Node n,List<Integer> list){
        if(n ==null)
            return;
        list.add(n.val);
        for (Node child : n.children) {
            preorderrecursive(child,list);
        }
    }
}
