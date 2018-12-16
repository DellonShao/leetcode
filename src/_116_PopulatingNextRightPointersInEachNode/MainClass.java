package _116_PopulatingNextRightPointersInEachNode;

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
        while(tmp.left != null) {
            TreeLinkNode tmp1 = tmp;
            while (tmp1 != null) {
                tmp1.left.next = tmp1.right;
                if (tmp1.next != null) {
                    tmp1.right.next = tmp1.next.left;
                } else {
                    tmp1.right.next = null;
                }
                tmp1 = tmp1.next;
            }
            tmp = tmp.left;
        }
    }
}

public class MainClass {
}
