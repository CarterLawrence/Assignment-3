package problem5;

public class QueueTester {
	public static void main(String[] args){
	MyQueue<Integer> q = new MyQueue<Integer>();
	q.enqueue(1);
	q.enqueue(4);
	q.enqueue(2);
	q.enqueue(5);
	System.out.println(q.peek());
	q.printStack();
}
}
