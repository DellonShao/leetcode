package _143_ReorderList;

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
    public void reorderList(ListNode head) {
        //使用快慢指针
        if(head == null || head.next == null) return ;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null){
            slow = slow.next;
        }
        //后半段开始反转
        //使用头插法
        ListNode before = slow.next;//要交换的前一个节点
        ListNode tmp;//要交换的节点
        while(before != null && before.next != null){
            tmp = before.next;
            before.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        //合并
        tmp = head;
        ListNode aNode = slow.next;
        slow.next = null;
        slow = aNode;

        while(slow != null){
            aNode = slow.next;
            slow.next = tmp.next;
            tmp.next = slow;
            tmp = tmp.next.next;
            slow = aNode;
        }
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

            new Solution().reorderList(head);
            String out = listNodeToString(head);

            System.out.print(out);
        }
    }
}