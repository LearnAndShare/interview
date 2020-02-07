package com.practice.tree;

import com.sun.source.tree.Tree;

import java.util.*;

/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.


 */
public class BTreeNodesAtDistanceK {

    private Map<TreeNode,TreeNode> nodeParent = null;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> list = new ArrayList<>();


        if(root != null){
            if(K == 0){
                list.add(target.val);
                return list;
            }
            nodeParent=new HashMap<>();
            dfs(root,null);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);
            queue.add(null);
            Set<TreeNode> set =new LinkedHashSet<>();
            set.add(target);
            int d = 1;
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();
                if(t == null){
                    if(d == K){
                        // System.out.println(queue.size());
                        for(TreeNode q:queue){
                            list.add(q.val);
                        }
                        return list;
                    }

                    queue.offer(null);
                    d++;
                } else{

                    if(t.left != null && !set.contains(t.left)){
                        System.out.println(" t.left  ot null");
                        set.add(t.left);
                        queue.offer(t.left);
                    }

                    if(t.right != null && !set.contains(t.right)){
                        System.out.println(" t.right  not null");
                        set.add(t.right);
                        queue.offer(t.right);
                    }

                    TreeNode p =nodeParent.get(t);
                    if(p != null && !set.contains(p)){
                        System.out.println(" t.parent  not null");
                        set.add(p);
                        queue.offer(p);
                    }
                }

            }
        }
        return list;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if(root != null){
            nodeParent.put(root,parent);
            dfs(root.left,root);
            dfs(root.right,root);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeFromArray(new int[]{3,5,1,6,2,0,8,10,11,7,4});
        BTreeNodesAtDistanceK b = new BTreeNodesAtDistanceK();
        List<Integer> list = b.distanceK(root,new TreeNode(5),2);
    }
}
