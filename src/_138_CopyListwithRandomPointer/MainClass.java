package _138_CopyListwithRandomPointer;


import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode tmp = head;
        RandomListNode newTmp = newHead;
        Map<RandomListNode, Integer> oldMap = new HashMap<>();
        Map<Integer, RandomListNode> newMap = new HashMap<>();
        oldMap.put(head, 0);
        newMap.put(0, newHead);
        int cnt = 1;
        while(tmp.next != null){
            newTmp.next = new RandomListNode(tmp.next.label);
            tmp = tmp.next;
            newTmp = newTmp.next;
            oldMap.put(tmp, cnt);
            newMap.put(cnt++, newTmp);
        }

        tmp = head;
        newTmp = newHead;
        while(tmp != null){
            newTmp.random = newMap.get(oldMap.get(tmp.random));
            tmp = tmp.next;
            newTmp = newTmp.next;
        }
        return newHead;
    }
}

public class MainClass {

}
