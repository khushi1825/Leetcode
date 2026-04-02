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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18        List<List<Integer>> res=new ArrayList<>();
19        if(root==null) return res;
20        Queue<TreeNode> q=new LinkedList<>();
21        q.add(root);
22        boolean LtoR=true;
23        while(!q.isEmpty()){
24           List<Integer> level=new ArrayList<>();
25           int size=q.size();
26           for(int i=0;i<size;i++){
27                TreeNode rv=q.poll();
28                if(LtoR){
29                    level.add(rv.val);
30                }
31                else{
32                    level.add(0,rv.val);
33                }
34                if(rv.left!=null) q.add(rv.left);
35                if(rv.right!=null) q.add(rv.right);  
36            } 
37            res.add(level);
38            LtoR=!LtoR;
39        }
40        return res;
41    }
42}