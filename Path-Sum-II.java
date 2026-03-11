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
16class Solution{
17    public List<List<Integer>> pathSum(TreeNode root,int targetSum){
18        List<List<Integer>> res=new ArrayList<>();
19        List<Integer> path=new ArrayList<>();
20        dfs(root,targetSum,path,res);
21        return res;
22    }
23
24    public void dfs(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> res){
25        if(root==null){
26            return;
27        }
28        path.add(root.val);
29        targetSum-=root.val;
30        if(root.left==null&&root.right==null&&targetSum==0){
31            res.add(new ArrayList<>(path));
32        }
33        dfs(root.left,targetSum,path,res);
34        dfs(root.right,targetSum,path,res);
35        path.remove(path.size()-1);
36    }
37}
38
39