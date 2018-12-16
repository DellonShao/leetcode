package _117_PopulatingNextRightPointersInEachNodeII;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        root.next = null;
        TreeLinkNode tmp = root;
        TreeLinkNode next = null;
        int cnt = 0;
        do{
            TreeLinkNode pre = new TreeLinkNode(0);
            next = null;
            cnt = 0;
            while (tmp != null) {
                if (tmp.left != null) {
                    pre.next = tmp.left;
                    pre = tmp.left;
                    cnt++;
                    if (cnt == 1) {
                        next = tmp.left;
                    }
                }
                if (tmp.right != null) {
                    pre.next = tmp.right;
                    pre = tmp.right;
                    cnt++;
                    if (cnt == 1) {
                        next = tmp.right;
                    }
                }
                tmp = tmp.next;
            }
            pre.next = null;
            tmp = next;
        }while(next != null);
    }
}

public class MainClass {
}
