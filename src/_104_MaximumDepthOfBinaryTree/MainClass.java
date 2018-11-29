package _104_MaximumDepthOfBinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        int max = 0;
        int result = 0;
        if(root == null) return 0;
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> m = new HashSet<>();
        s.push(root);
        m.add(root);
        max++;
        result = max;
        while(!s.empty()){
            TreeNode temp = s.peek();
            if(temp.left != null && !m.contains(temp.left)){
                s.push(temp.left);
                max++;
                m.add(temp.left);
                continue;
            }
            result = Math.max(result, max);
            if(temp.right != null && !m.contains(temp.right)){
                s.push(temp.right);
                max++;
                m.add(temp.right);
                continue;
            }
            result = Math.max(result, max);
            s.pop();
            max--;
        }
        return result;
    }
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution().maxDepth(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
