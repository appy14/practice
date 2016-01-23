package com.as.funexercises.ch2;

import java.util.HashSet;

public class LinkedList {
	
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
}
