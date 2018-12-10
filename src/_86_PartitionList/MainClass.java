package _86_PartitionList;

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
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
            line = in.readLine();
            int x = Integer.parseInt(line);

            ListNode ret = new Solution().partition(head, x);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
