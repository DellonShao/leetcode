package _103_BinaryTreeZigzagLevelOrderTraversal;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> rightWay = new Stack<>();
        Stack<TreeNode> reverseWay = new Stack<>();
        rightWay.add(root);
        int flag = 0;
        while(!rightWay.empty() || !reverseWay.empty()){
            if(flag == 0){
                List<Integer> rightlist = new ArrayList<>();
                while(!rightWay.empty()){
                    TreeNode tmp = rightWay.pop();
                    rightlist.add(tmp.val);
                    if (tmp.left != null) {
                        reverseWay.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        reverseWay.add(tmp.right);
                    }
                }
                result.add(rightlist);
                flag = 1;
                continue;
            }
            if (flag == 1) {
                List<Integer> reverselist = new ArrayList<>();
                while(!reverseWay.empty()){
                    TreeNode tmp = reverseWay.pop();
                    reverselist.add(tmp.val);
                    if (tmp.right != null) {
                        rightWay.add(tmp.right);
                    }
                    if (tmp.left != null) {
                        rightWay.add(tmp.left);
                    }
                }
                result.add(reverselist);
                flag = 0;
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

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            List<List<Integer>> ret = new Solution().zigzagLevelOrder(root);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}