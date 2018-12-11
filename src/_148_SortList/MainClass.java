package _148_SortList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        //用快慢指针，找到中间指针
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast.next != null && fast.next.next != null){
            slow = slow .next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        return merge(sortList(head), sortList(tmp));
    }

    private ListNode merge(ListNode left, ListNode right){
        if(left == null) return left;
        if(right == null) return  right;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(left!=null && right != null){
            if(left.val < right.val){
                tmp.next = left;
                tmp = tmp.next;
                left = left.next;
            }else {
                tmp.next = right;
                tmp = tmp.next;
                right = right.next;
            }
        }

        while(left != null){
            tmp.next = left;
            tmp = tmp.next;
            left = left.next;
        }
        while(right != null){
            tmp.next = right;
            tmp = tmp.next;
            right = right.next;
        }

        return head.next;
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

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().sortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}