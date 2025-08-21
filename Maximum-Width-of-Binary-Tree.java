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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null){ 
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair<TreeNode, Long>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0L));

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().getValue();
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> cur = q.poll();
                TreeNode node = cur.getKey();
                long index = cur.getValue() - minIndex; 

                if (i == 0){ 
                    first = index;
                }
                
                if (i == size - 1){ 
                    last = index;
                }

                if (node.left != null) {
                    q.add(new Pair<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    q.add(new Pair<>(node.right, 2 * index + 1));
                }
            }
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }
        return maxWidth;
    }
}