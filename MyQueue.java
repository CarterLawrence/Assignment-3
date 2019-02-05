package problem5;

public class MyQueue<E> {
	private Node top;
	private Node bottom;
	private int currentCount;
	public MyQueue(){
		bottom = null;
		top = null;
		currentCount = 0;
	}
	public void printStack(){
		Node current = top;
		while(current != null){
			System.out.println(current.value);
			current = current.next;
		}
	}
	public void enqueue(E val){
		Node item = new Node(val);
		Node PBottom = bottom;
		bottom = item;
		if(top == null){
			top = bottom;
		}else{
			PBottom.next = bottom;
			
		}
		currentCount++;
	}
	public E dequeue(){
		if(top == null){
			return null;
		}else{
			E val = top.value;
			top = top.next;
			currentCount--;
			return val;
		}
	}
	public E peek(){
		if(top == null){
			return null;
		}else{
			E val = top.value;
			return val;
		}
	}
	private class Node{
		E value;
		Node next;
		public Node(E v){
			value = v;
			next = null;
		}
	}
}
