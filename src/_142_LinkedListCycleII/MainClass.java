package _142_LinkedListCycleII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution {
    public ListNode detectCycle(ListNode head, int pos) {
        //快慢指针，可以确定环的长度(a+b)
        //a为入环之前的长度，b为环里走的长度
        //再确定一个指针从头和慢指针一块儿走，
        //相遇的位置就是入节点
        if(head == null || head.next == null) return null;
        ListNode slow, fast;
        slow = fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null && fast.next != null && slow != fast);

        if(fast == null || fast.next == null) return null;
        ListNode tmp = head;
        while(tmp != slow){
            tmp = tmp.next;
            slow = slow.next;
        }
        return tmp;
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
            int pos = Integer.parseInt(line);

            ListNode ret = new Solution().detectCycle(head, pos);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}