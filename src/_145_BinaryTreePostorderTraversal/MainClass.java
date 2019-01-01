package _145_BinaryTreePostorderTraversal;

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

class Pair{
    TreeNode node;
    int val;

    public TreeNode getNode() {
        return node;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Pair(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
}
class Solution {
    //迭代算法
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        dfs(root, result);
//        return result;
//    }
//
//    private void dfs(TreeNode root, List<Integer> result){
//        if(root == null){
//            return ;
//        }
//        dfs(root.left, result);
//        dfs(root.right, result);
//        result.add(root.val);
//    }

    //非迭代算法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        if(root != null){
            Pair pTmp = new Pair(root, -1);
            stack.push(pTmp);
            while(!stack.empty()){
                int val = stack.peek().getVal();
                TreeNode tmp = stack.peek().getNode();
                if(val == -1){
                    //往左遍历
                    stack.peek().setVal(0);
                    if(tmp.left != null){
                        stack.push(new Pair(tmp.left, -1));
                    }

                }else if(val == 0){
                    //往右遍历
                    stack.peek().setVal(1);
                    if(tmp.right != null){
                        stack.push(new Pair(tmp.right, -1));
                    }
                }else{
                    //栈退出
                    result.add(stack.pop().getNode().val);
                }
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

            List<Integer> ret = new Solution().postorderTraversal(root);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}