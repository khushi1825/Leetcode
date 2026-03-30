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
17    public int sumNumbers(TreeNode root) {
18        return fun(root,0);
19    }
20
21    public int fun(TreeNode root,int sum){
22        if(root==null){
23            return 0;
24        }
25        if(root.left==null && root.right==null){
26            return sum*10+root.val;
27        }
28        int left=fun(root.left,sum*10+root.val);
29        int right=fun(root.right,(sum*10+root.val));
30        return left+right;
31    }
32}