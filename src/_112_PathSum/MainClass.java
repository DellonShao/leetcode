package _112_PathSum;

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
    public boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null) return false;
//        Stack<TreeNode> stack = new Stack<>();
//        Set<TreeNode> set  = new HashSet<>();
//        int cnt = 0;
//        stack.push(root);
//        set.add(root);
//        cnt += root.val;
//        while(!stack.isEmpty()){
//            TreeNode temp = stack.peek();
//            if(temp.left != null && !set.contains(temp.left)){
//                stack.push(temp.left);
//                set.add(temp.left);
//                cnt += temp.left.val;
//                continue;
//            }
//
//            if(temp.right != null && !set.contains(temp.right)){
//                stack.push(temp.right);
//                set.add(temp.right);
//                cnt += temp.right.val;
//                continue;
//            }
//            if(temp.left == null && temp.right == null){
//                if(cnt == sum) return true;
//            }
//            stack.pop();
//            cnt -= temp.val;
//        }
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == root.val){
            return true;
        }else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int sum = Integer.parseInt(line);

            boolean ret = new Solution().hasPathSum(root, sum);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}