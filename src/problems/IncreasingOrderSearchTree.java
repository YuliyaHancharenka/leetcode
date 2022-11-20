package problems;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    //897
    public static void main(String[] args) {

    }

    /*
    Approach 1: In-Order Traversal
Intuition
The definition of a binary search tree is that for every node,
all the values of the left branch are less than the value at the root,
and all the values of the right branch are greater than the value at the root.
Because of this, an in-order traversal of the nodes will yield all the values in increasing order.

Algorithm
Once we have traversed all the nodes in increasing order,
we can construct new nodes using those values to form the answer.
     */
    private static TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v : vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    private static void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    //Definition for a binary tree node.
    private static class TreeNode {
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
}
