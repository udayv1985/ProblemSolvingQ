package com.uday.ds.linkedlist;

public class LinkedList {

    Node head;

    public Node findLoop(Node node) {
        if (null == node || null == node.next) {
            return null;
        }
        Node slow = node.next;
        Node fast = node.next.next;
        while (!slow.equals(fast) && null != slow && null != fast) {
            slow = slow.next;
            fast = (null != fast.next ? fast.next.next : null);
        }
        return null != slow ? slow : null;
    }

    public int length(Node head) {
        if (null == head) {
            return 0;
        }
        int length = 1;
        Node temp = head.next;
        while (null != temp && !temp.equals(head)) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    public Node reverse(Node head) {

        Node n1 = head;
        Node n2 = head.next;

        Node temp = n2.next;

        n2.next = n1;
        n1.next = null;
        temp.next = n2;


        return null;
    }
}
