package _141_LinkedListCycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        //快慢指针
//        if(head == null) return false;
//        ListNode pSlow = head;
//        ListNode pFast = head;
//        while(pSlow != null){
//            if(pSlow.next != null){
//                pSlow = pSlow.next;
//            }else{
//                return false;
//            }
//            if(pFast.next != null && pFast.next.next != null){
//                pFast = pFast.next.next;
//            }else return false;
//
//            if(pSlow == pFast) return true;
//        }
//        return false;

        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new Solution().hasCycle(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}