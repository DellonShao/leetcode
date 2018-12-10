package _109_ConvertSortedListToBinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> aList = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            aList.add(tmp.val);
            tmp = tmp.next;
        }

        return dfs(aList, 0, aList.size());
        //第二种方法，可以用快慢指针，2倍，找到中间的位置
    }

    private TreeNode dfs(List<Integer> aList, int begin, int end){
        if(begin >= end) return null;
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(aList.get(mid));

        root.left = dfs(aList, begin, mid);
        root.right = dfs(aList, mid + 1, end);

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

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
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
            ListNode head = stringToListNode(line);

            TreeNode ret = new Solution().sortedListToBST(head);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }
}