package problem1;

public class Doubletester {
	public static void main(String[] args){
	Doublelinkedlist<Integer> mdll = new Doublelinkedlist<>();

	mdll.add(0);
	mdll.add(1);
	mdll.add(2);
	mdll.add(3);
	mdll.insert(5, 2);
	mdll.swap(2);
	//mdll.delete(4);
	System.out.println("Forward");
	mdll.printList();
	System.out.println("Rev");
	mdll.printListRev();

}
}