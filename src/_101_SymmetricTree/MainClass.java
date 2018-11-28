package _101_SymmetricTree;

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
    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            TreeNode temp;
//            int len = queue.size();
//            for(int i = 0; i < len; ++i){
//                temp = queue.pop();
//                if(temp.val != Integer.MAX_VALUE) {
//                    if (temp.left == null) queue.addLast(new TreeNode(Integer.MAX_VALUE));
//                    else queue.addLast(temp.left);
//                    if (temp.right == null) queue.addLast(new TreeNode(Integer.MAX_VALUE));
//                    else queue.addLast(temp.right);
//                }
//            }
//            if((queue.size() & 1) == 1) return false;
//            else{
//                Iterator i1 = queue.iterator();
//                Iterator i2 = queue.descendingIterator();
//                while(i1.hasNext() && i2.hasNext()){
//                    if(((TreeNode)i1.next()).val != ((TreeNode)i2.next()).val) return false;
//                }
//            }
//        }
//        return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
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

            boolean ret = new Solution().isSymmetric(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
