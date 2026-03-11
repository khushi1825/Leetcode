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
19        Queue<TreeNode> q=new LinkedList<>();
20        if(root==null){
21            return res;
22        }
23        q.add(root);
24        boolean LeftToRight=true;
25        while(!q.isEmpty()){
26            int size=q.size();
27            List<Integer> level=new ArrayList<>();
28            for(int i=0;i<size;i++){
29                TreeNode n=q.poll();
30                if(LeftToRight){
31                    level.add(n.val);
32                }
33                if(!LeftToRight){
34                    level.add(0,n.val);
35                }
36                if(n.left!=null){
37                    q.add(n.left);
38                }
39                if(n.right!=null){
40                    q.add(n.right);
41                }
42            }
43            res.add(level);
44            LeftToRight=!LeftToRight;
45        }
46        return res;
47    }
48}