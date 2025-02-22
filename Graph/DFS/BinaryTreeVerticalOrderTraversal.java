import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        HashMap<Integer, List<Integer>> columnsMap = new HashMap<>();
        Queue<Pair<Integer, TreeNode>> queue = new ArrayDeque<>();
        queue.add(new Pair(0, root));
        columnsMap.put(0, new ArrayList<>());
        columnsMap.get(0).add(root.val);
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> curr = queue.poll();
            int col = curr.getKey();
            TreeNode currNode = curr.getValue();
            if (currNode.left != null) {
                queue.add(new Pair(col - 1, currNode.left));
                columnsMap.put(col - 1, columnsMap.getOrDefault(col - 1, new ArrayList<>()));
                columnsMap.get(col - 1).add(currNode.left.val);
            }
            if (currNode.right != null) {
                queue.add(new Pair(col + 1, currNode.right));
                columnsMap.put(col + 1, columnsMap.getOrDefault(col + 1, new ArrayList<>()));
                columnsMap.get(col + 1).add(currNode.right.val);
            }
        }
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for (int c : columnsMap.keySet()) {
            minCol = Math.min(minCol, c);
            maxCol = Math.max(maxCol, c);
        }
        List<List<Integer>> results = new ArrayList<>();
        for (int j = minCol; j <= maxCol; j++) {
            List<Integer> cur = columnsMap.get(j);
            results.add(cur);
        }
        return results;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {
        }
    
        TreeNode(int val) {
            this.val = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static Map<Integer, ArrayList<SimpleEntry<Integer, Integer>>> columnTable = new HashMap<>();
    public static int minColumn = 0, maxColumn = 0;

    public static void DFS(TreeNode node, Integer row, Integer column) {
        if (node == null)
            return;
        if (!columnTable.containsKey(column)) {
            columnTable.put(column, new ArrayList<Pair<Integer, Integer>>());
        }
        columnTable.get(column).add(new SimpleEntry<>(row, node.val));
        minColumn = Math.min(minColumn, column);
        maxColumn = Math.max(maxColumn, column);
        DFS(node.left, row + 1, column - 1);
        DFS(node.right, row + 1, column + 1);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        DFS(root, 0, 0);
        for (int i = minColumn; i <= maxColumn; i++) {
            Collections.sort(columnTable.get(i), new Comparator<SimpleEntry<Integer, Integer>>() {
                public int compare(SimpleEntry<Integer, Integer> p1, SimpleEntry<Integer, Integer> p2) {
                    return p1.getKey() - p2.getKey();
                }
            });
            List<Integer> sortedColumn = new ArrayList();
            for (Pair<Integer, Integer> p : columnTable.get(i)) {
            for (SimpleEntry<Integer, Integer> p : columnTable.get(i)) {
            }
            output.add(sortedColumn);
        }
        return output;
    }

    public static void main(String[] args) {

    }
}