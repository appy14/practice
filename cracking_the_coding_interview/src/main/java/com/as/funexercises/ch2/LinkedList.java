package com.as.funexercises.ch2;

import java.util.HashSet;

public class LinkedList {

    // Assuming an unsorted list
    public static LinkedListNode removeDuplicatesWithoutABuffer(LinkedListNode n) {

        // considering n as the head, singly linked list
        if (n == null || n.next == null) {
            return n;
        }

        LinkedListNode current = n.next;
        LinkedListNode prev = n;

        while (current != null) {
            LinkedListNode runner = n;

            while (runner != current) {
                if (runner.data == current.data) {
                    prev.next = current.next;
                    current = current.next;
                    break;
                }
                runner = runner.next;
            }

            if (runner == current) {
                prev = current;
                current = current.next;
            }
        }
        return n;
    }

    // Assuming an unsorted list
    public static LinkedListNode removeDuplicatesWithABuffer(LinkedListNode n) {
        if (n == null || n.next == null) {
            return n;
        }

        HashSet<Integer> values = new HashSet<Integer>();

        LinkedListNode current = n.next;
        LinkedListNode prev = n;
        values.add(n.data);

        while (current != null) {
            if (values.contains(current.data)) {
                prev.next = current.next;
                current = current.next;
                continue;
            }
            values.add(current.data);
            prev = current;
            current = current.next;
        }
        return n;
    }

    public static LinkedListNode findNthLast(LinkedListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }

        LinkedListNode current = head;

        LinkedListNode pointer = head;

        int count = 0;

        while (count++ < n && pointer != null) {
            pointer = pointer.next;
        }

        if (pointer == null) {
            return null;
        }

        while (pointer.next != null) {
            current = current.next;
            pointer = pointer.next;
        }

        return current;
    }

    // Ex 2.3 delete a node in the middle of a singly linked list,
    // given only access to that node
    public static boolean deleteMidNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }

        while (n.next.next != null) {
            n.data = n.next.data;
            n = n.next;
        }
        n.data = n.next.data;
        n.next = null;
        return true;
    }

    // Ex 2.4
    public static LinkedListNode addTwoLinkedLists(LinkedListNode n1,
            LinkedListNode n2, int carry) {

        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }
        int value = carry;

        if (n1 != null) {
            value += n1.data;
        }

        if (n2 != null) {
            value += n2.data;
        }

        carry = value / 10;

        LinkedListNode n = new LinkedListNode(value % 10);
        n1 = (n1 == null) ? null : n1.next;
        n2 = (n2 == null) ? null : n2.next;
        n.next = addTwoLinkedLists(n1, n2, carry);

        return n;
    }
}
