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
17class BstPair{
18    long min=Long.MAX_VALUE;
19    long max=Long.MIN_VALUE;
20    boolean isBst=true;
21}
22class Solution {
23    public boolean isValidBST(TreeNode root) {
24        return valid(root).isBst;
25    }
26
27    public BstPair valid(TreeNode root){
28        if(root==null){
29            return new BstPair();
30        }
31        BstPair lbp=valid(root.left);
32        BstPair rbp=valid(root.right);
33        BstPair sbp=new BstPair();
34        sbp.max=Math.max(lbp.max,Math.max(rbp.max,root.val));
35        sbp.min=Math.min(lbp.min,Math.min(rbp.min,root.val));
36        sbp.isBst=lbp.isBst && rbp.isBst && lbp.max<root.val && rbp.min>root.val;
37        return sbp;
38    }
39}