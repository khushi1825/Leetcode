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
17    public int diameterOfBinaryTree(TreeNode root) {
18        if(root==null) return 0;
19        int ld=diameterOfBinaryTree(root.left);
20        int rd=diameterOfBinaryTree(root.right);
21        int sd=height(root.left)+height(root.right)+2;
22        return Math.max(sd,Math.max(ld,rd));
23    }
24
25    public static int height(TreeNode root){
26        if(root==null) return -1;
27        int left=height(root.left);
28        int right=height(root.right);
29        return Math.max(left,right)+1;
30
31    }
32}