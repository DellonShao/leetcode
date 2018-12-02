package _105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if(preL >= preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int k;
        for(k = inL; k < inR; ++k){
            if(inorder[k] == preorder[preL]){
                break;
            }
        }
        int leftLen = k - inL;
        root.left = build(preorder, inorder, preL + 1, preL + leftLen + 1, inL, k);
        root.right = build(preorder, inorder, preL + leftLen + 1, preR, k + 1, inR);
        return root;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] preorder = stringToIntegerArray(line);
            line = in.readLine();
            int[] inorder = stringToIntegerArray(line);

            TreeNode ret = new Solution().buildTree(preorder, inorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}