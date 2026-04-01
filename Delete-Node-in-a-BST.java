1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode deleteNode(TreeNode root, int key) {
18        if(root==null) return null;
19        if(root.val<key){
20            root.right=deleteNode(root.right,key);
21        }
22        else if(root.val>key){
23            root.left=deleteNode(root.left,key);
24        }
25        else{
26            if(root.left==null) return root.right;
27            else if(root.right==null) return root.left;
28            else{
29                int min=min(root.right);
30                root.right=deleteNode(root.right,min);
31                root.val=min;
32            }
33        }
34        return root;
35    }
36
37    public static int min(TreeNode root){
38        if(root==null){
39           return Integer.MAX_VALUE;
40        }
41        int left=min(root.left);
42        return Math.min(left,root.val);
43    }
44}