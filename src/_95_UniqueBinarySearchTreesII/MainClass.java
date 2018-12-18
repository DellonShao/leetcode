package _95_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 0) return result;
        result = buildTree(1, n);
        return result;
    }

    private List<TreeNode> buildTree(int l, int r){
        List<TreeNode> result = new LinkedList<>();
        if(l > r){
            result.add(null);
            return result;
        }
        for(int i = l; i <= r; ++i){
            List<TreeNode> left = buildTree(l, i - 1);
            List<TreeNode> right = buildTree(i + 1, r);
            for(TreeNode leftTmp : left){
                for(TreeNode rightTmp : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTmp;
                    root.right = rightTmp;
                    result.add(root);
                }
            }
        }
        return result;
    }
}

public class MainClass {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateTrees(5);
    }
}
