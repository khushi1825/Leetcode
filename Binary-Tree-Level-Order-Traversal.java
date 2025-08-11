/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        
        
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer> level=new ArrayList<>();
    
            for(int i=1;i<=len;i++){
                TreeNode n=q.poll();
                level.add(n.val);
                if(n.left!=null){
                    q.add(n.left);
                }
            
                if(n.right!=null){
                    q.add(n.right);
                }
            }

            list.add(level);
            
        }

        return list;
    }
}