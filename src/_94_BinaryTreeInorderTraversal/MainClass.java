package _94_BinaryTreeInorderTraversal;

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
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        dfs(root,result);
//        return result;
//    }
//
//    private void dfs(TreeNode root, List<Integer> result){
//        if(root == null) return;
//        dfs(root.left, result);
//        result.add(root.val);
//        dfs(root.right, result);
//    }

    //迭代方法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        s.push(root);
        set.add(root);
        while(!s.isEmpty()){
            TreeNode tmp = s.peek();

            if(tmp.left != null && !set.contains(tmp.left)){
                s.push(tmp.left);
                set.add(tmp.left);
                continue;
            }

            result.add(tmp.val);
            s.pop();

            if(tmp.right != null){
                s.push(tmp.right);
                set.add(tmp.right);
            }
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<Integer> ret = new Solution().inorderTraversal(root);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
