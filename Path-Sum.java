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
17    public boolean hasPathSum(TreeNode root, int targetSum) {
18        if(root==null){
19            return false;
20        }
21        if(root.left==null && root.right==null){
22            return targetSum-root.val==0;
23        }
24        boolean left=hasPathSum(root.left,targetSum-root.val);
25        boolean right=hasPathSum(root.right,targetSum-root.val);
26        return left || right;
27
28
29    }
30}