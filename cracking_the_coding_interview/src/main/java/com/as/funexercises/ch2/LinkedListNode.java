package com.as.funexercises.ch2;

public class LinkedListNode {
	int data;
	LinkedListNode next;
	
	public LinkedListNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public LinkedListNode(int data, LinkedListNode next) {
		this.data = data;
		this.next = next;
	}
	
	@Override
	public String toString() {
		return String.format("Data %d: ", data);
	}
}
