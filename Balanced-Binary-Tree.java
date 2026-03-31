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
16
17class DiaPair{
18    boolean isBal=true;
19    int ht=-1;
20
21}
22class Solution {
23    public boolean isBalanced(TreeNode root) {
24        return balance(root).isBal;
25    }
26
27    public DiaPair balance(TreeNode root){
28        if(root==null){
29            return new DiaPair();
30        }
31        DiaPair lbp=balance(root.left);
32        DiaPair rbp=balance(root.right);
33        DiaPair sbp=new DiaPair();
34        sbp.ht=Math.max(lbp.ht,rbp.ht)+1;
35        boolean sb=Math.abs(lbp.ht-rbp.ht)<=1;
36        sbp.isBal=lbp.isBal && rbp.isBal && sb;
37        return sbp;
38    }
39}