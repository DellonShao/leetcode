package _160_IntersectionOfTwoLinkedLists;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //规整到同等长度
        if(headA == null || headB == null)
            return null;
        int cntA = 0, cntB = 0;
        ListNode temp = headA;
        while(temp != null){
            cntA++;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            cntB++;
            temp = temp.next;
        }
        ListNode temp2 = headB;
        temp = headA;
        if(cntA > cntB){
            do{
                temp = temp.next;
                cntA--;
            }while(cntA > cntB);
        }else if(cntA < cntB){
            do{
                temp2 = temp2.next;
                cntB--;
            }while(cntA < cntB);
        }
        while(temp != null && temp2 != null){
            if(temp == temp2){
                return temp;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return null;
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
            ListNode headA = stringToListNode(line);
            line = in.readLine();
            ListNode headB = stringToListNode(line);

            ListNode ret = new Solution().getIntersectionNode(headA, headB);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}