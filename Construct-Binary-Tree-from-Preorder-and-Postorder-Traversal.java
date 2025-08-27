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
class TreeNode
{
    int val;
    TreeNode left, right;
    TreeNode(int x) 
    { 
        val = x;
    }
}

class Solution
{
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) 
    {
        if (preorder.length == 0)
        {
            return null; 
        } 
        
        return buildTree(preorder, postorder);
    }

    public TreeNode buildTree(int[] pre, int[] post)
    {
        if (pre.length == 0)
        {
            return null;
        } 

        TreeNode root = new TreeNode(pre[0]);

        if (pre.length == 1)
        {
            return root;
        } 

        int leftRootVal = pre[1];
        int leftSubtreeSize = 0;

        for (int i = 0; i < post.length; i++)
        {
            if (post[i] == leftRootVal)
            {
                leftSubtreeSize = i + 1;
                break;
            }
        }

        int[] leftPre = Arrays.copyOfRange(pre, 1, leftSubtreeSize + 1);
        int[] rightPre = Arrays.copyOfRange(pre, leftSubtreeSize + 1, pre.length);

        int[] leftPost = Arrays.copyOfRange(post, 0, leftSubtreeSize);
        int[] rightPost = Arrays.copyOfRange(post, leftSubtreeSize, post.length - 1);

        root.left = buildTree(leftPre, leftPost);
        root.right = buildTree(rightPre, rightPost);

        return root;
    }
}