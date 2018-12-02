package _106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR){
        if(inL > inR) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int k;
        for(k = inL; k <= inR; ++k){
            if(inorder[k] == postorder[postR]){
                break;
            }
        }
        int leftL = k - inL;
        root.left = build(inorder, postorder, inL, k - 1, postL, postL + leftL - 1);
        root.right = build(inorder, postorder, k + 1, inR, postL + leftL, postR - 1);
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
            int[] inorder = stringToIntegerArray(line);
            line = in.readLine();
            int[] postorder = stringToIntegerArray(line);

            TreeNode ret = new Solution().buildTree(inorder, postorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}