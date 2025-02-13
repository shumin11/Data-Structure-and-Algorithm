import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class BinaryTreeVerticalOrderTraversal {
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