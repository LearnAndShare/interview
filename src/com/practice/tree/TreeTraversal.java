package com.practice.tree;

import java.util.*;

/*
https://leetcode.com/problems/binary-tree-preorder-traversal/
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
 */
public class TreeTraversal {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();


        if(root != null){
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            while(!s.isEmpty()) {
                TreeNode t = s.pop();
                l.add(t.val);
                if (t.right != null) {
                    s.push(t.right);
                }

                if (t.left != null) {
                    s.push(t.left);
                }
            }
        }

        return l;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> s = new Stack<>();

            while(root != null){
                s.push(root);
                root = root.left;
            }

            while(!s.isEmpty()){
                TreeNode t = s.pop();
                l.add(t.val);

                t = t.right;
                while(t != null){
                    s.push(t);
                    t=t.left;
                }

            }
        }
        return l;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while(!s1.isEmpty()){
                TreeNode s = s1.pop();
                if(s.left != null)
                    s1.push(s.left);
                if(s.right != null)
                    s1.push(s.right);
                s2.push(s);
            }
            while(!s2.isEmpty()){
                l.add(s2.pop().val);
            }
        }

        return l;
    }
/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


 */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> s1 = new LinkedList<>();
        LinkedList<TreeNode> s2 = new LinkedList<>();
        List<Integer> l1 = new ArrayList<>();
        if(root != null) {
            s1.add(root);
            while(!s1.isEmpty()){
                TreeNode t = s1.remove();
                l1.add(t.val);
                if (t.left != null)
                    s2.add(t.left);
                if (t.right != null)
                    s2.add(t.right);
                if(s1.isEmpty()){
                    s1 = s2;
                    s2 = new LinkedList<>();
                    l.add(l1);
                    l1 = new ArrayList<>();
                }

            }
        }
        return l;
    }
/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
   return its bottom-up level order traversal as:
   [
  [15,7],
  [9,20],
  [3]
]
 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        if(root != null){
            LinkedList<TreeNode> s1 = new LinkedList<>();
            LinkedList<TreeNode> s2 = new LinkedList<>();
            s1.add(root);
            List<Integer> l1 = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode t = s1.pop();
                l1.add(t.val);

                if (t.left != null)
                    s2.add(t.left);
                if (t.right != null)
                    s2.add(t.right);
                if(s1.isEmpty()){
                    s1 = s2;
                    s2 = new LinkedList<>();
                    tmp.add(l1);
                    l1 = new ArrayList<>();

                }

            }
            for(int i=tmp.size()-1;i>=0;i--){
                l.add(tmp.get(i));
            }


        }
        return l;
    }
/*
https://leetcode.com/problems/average-of-levels-in-binary-tree/
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> d= new ArrayList<>();
        if(root != null){
            Stack<TreeNode> s1 = new Stack<>();
            s1.push(root);
            Stack<TreeNode> s2 = new Stack<>();
            while(!s1.isEmpty()){

                int len = s1.size();
                int sum =0;

                Iterator<TreeNode>it = s1.iterator();
                while(it.hasNext()){
                    TreeNode t1 = it.next();
                    if (t1.left != null) {
                        s2.push(t1.left);
                    }
                    if (t1.right != null) {
                        s2.push(t1.right);
                    }
                    sum += t1.val;
                    it.remove();
                }
                double avg = sum/len;
                d.add(avg);

                if(s1.isEmpty()) {
                    s1 = s2;
                    s2 = new Stack<>();
                }
            }
        }

        return d;
    }

/*
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

Example:
                     3(0,0)
                     /\
            (-1,-1) 9  20 (1,-1)
                       /\
               (0,-2) 15 7 (2,-2)
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
 */

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> l =new ArrayList<>();
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        if(root != null){

            LinkedList<TreeNode> l1 = new LinkedList<>();
            LinkedList<Integer> l2 = new LinkedList<>();
            l1.offer(root);
            l2.offer(0);

            while(!l1.isEmpty()){
                TreeNode t = l1.poll();
                int level = l2.poll();
                List<Integer> list = map.get(level);
                if(list == null){
                    list = new ArrayList<>();
                    map.put(level,list);
                }
                list.add(t.val);
                Collections.sort(list);
                if(t.left!=null){
                    l1.offer(t.left);
                    l2.offer(level -1);
                }

                if(t.right!=null){
                    l1.offer(t.right);
                    l2.offer(level + 1);
                }
            }
        }

        for (List<Integer> value : map.values()) {
            Collections.sort(value);
            l.add(value);
        }

        return l;
    }




}
