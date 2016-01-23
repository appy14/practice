package com.as.funexercises.ch2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testRemoveDupsWithoutABuffer() {
		LinkedListNode n1 = new LinkedListNode(10);
		LinkedListNode n2 = new LinkedListNode(20);
		LinkedListNode n3 = new LinkedListNode(10);
		LinkedListNode n4 = new LinkedListNode(30);
		LinkedListNode n5 = new LinkedListNode(20);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		LinkedList.removeDuplicatesWithoutABuffer(n1);
		
		assertEquals(n2, n1.next);
		assertEquals(n4, n2.next);
		assertEquals(null, n4.next);
		
		// No duplicates
		LinkedList.removeDuplicatesWithoutABuffer(n1);
		assertEquals(n2, n1.next);
		assertEquals(n4, n2.next);
		assertEquals(null, n4.next);
		
		// There is only one node
		LinkedListNode n6 = new LinkedListNode(40);
		assertEquals(n6, LinkedList.removeDuplicatesWithoutABuffer(n6));
		assertEquals(null, n6.next);
		
		// Pass null 
		assertEquals(null, LinkedList.removeDuplicatesWithoutABuffer(null));
		
	}
	
	@Test
	public void testRemoveDuplicatesWithABuffer() {
		LinkedListNode n1 = new LinkedListNode(10);
		LinkedListNode n2 = new LinkedListNode(20);
		LinkedListNode n3 = new LinkedListNode(10);
		LinkedListNode n4 = new LinkedListNode(30);
		LinkedListNode n5 = new LinkedListNode(20);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		LinkedList.removeDuplicatesWithABuffer(n1);
		
		assertEquals(n2, n1.next);
		assertEquals(n4, n2.next);
		assertEquals(null, n4.next);
		
		// No duplicates
		LinkedList.removeDuplicatesWithABuffer(n1);
		assertEquals(n2, n1.next);
		assertEquals(n4, n2.next);
		assertEquals(null, n4.next);
		
		// There is only one node
		LinkedListNode n6 = new LinkedListNode(40);
		assertEquals(n6, LinkedList.removeDuplicatesWithABuffer(n6));
		assertEquals(null, n6.next);
		
		// Pass null 
		assertEquals(null, LinkedList.removeDuplicatesWithABuffer(null));
	}
	
	@Test
	public void testFindNthLast() {
		LinkedListNode n1 = new LinkedListNode(10);
		LinkedListNode n2 = new LinkedListNode(20);
		LinkedListNode n3 = new LinkedListNode(10);
		LinkedListNode n4 = new LinkedListNode(30);
		LinkedListNode n5 = new LinkedListNode(20);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		assertEquals(n5, LinkedList.findNthLast(n1, 0));
		assertEquals(n4, LinkedList.findNthLast(n1, 1));
		assertEquals(n3, LinkedList.findNthLast(n1, 2));
		assertEquals(n2, LinkedList.findNthLast(n1, 3));
		assertEquals(n1, LinkedList.findNthLast(n1, 4));
		
		assertEquals(null, LinkedList.findNthLast(n1, 5));
		assertEquals(null, LinkedList.findNthLast(n1, -1));
	}
}
