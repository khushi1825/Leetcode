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
    
    public boolean isValidBST(TreeNode root) {
        ArrayList<Long> ans = new ArrayList<>();  
        helper(root, ans);
        for(int i = 0; i < ans.size() - 1; i++){
            if(ans.get(i + 1) <= ans.get(i)){  
                return false;
            }
        }
        return true;
    }

    void helper(TreeNode root, ArrayList<Long> ans){
        if(root == null){
            return;
        }
        helper(root.left, ans);
        ans.add((long) root.val); 
        helper(root.right, ans);
    }
}
