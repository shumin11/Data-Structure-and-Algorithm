package BinarySearch;

public class countNodes {

    public class TreeNode {
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

    public int countDepth(TreeNode root) {
        int d = 0;
        while (root.left != null) {
            root = root.left;
            d++;
        }
        return d;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d = countDepth(root);
        
        if (d == 0) return 1;

        int left = 0, right = (int) Math.pow(2, d) - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (exists(mid, d, root)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int lastIndex = exists(right, d, root) ? right : left;
        return lastIndex + 1 + (int)Math.pow(2, d) - 1;
    }

    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        for (int i = 0; i < d; i++) {
            int mid = left + (right - left) / 2;
            if (idx <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null;
    }

    public static void main(String[] args) {
        countNodes s = new countNodes();
        TreeNode root = s.new TreeNode(1);
        root.left = s.new TreeNode(2);
        root.right = s.new TreeNode(3);
        root.left.left = s.new TreeNode(4);
        root.left.right = s.new TreeNode(5);
        root.right.left = s.new TreeNode(6);
        root.right.right = s.new TreeNode(7);
        System.out.println(s.countNodes(root));
    }

}
