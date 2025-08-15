class Solution {

    static class Pair {
        TreeNode node;
        int hd;  
        int row; 
        Pair(TreeNode n, int h, int r) {
            node = n;
            hd = h;
            row = r;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));
        
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            TreeNode node = cur.node;
            int hd = cur.hd;
            int row = cur.row;
            
            map.computeIfAbsent(hd, k -> new ArrayList<>()).add(new int[]{row, node.val});
            
            if (node.left != null){
                q.add(new Pair(node.left, hd - 1, row + 1));
            }
            if (node.right != null){
                q.add(new Pair(node.right, hd + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (ArrayList<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            List<Integer> colList = new ArrayList<>();
            for (int[] arr : list) {
                colList.add(arr[1]); 
            }
            result.add(colList);
        }

        return result;
    }
}
