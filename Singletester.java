package problem1;

public class Singletester {

	public static void main(String[] args) {
		Singlelinkedlist<Integer> msll = new Singlelinkedlist<>();

		msll.add(1);
		msll.add(2);
		msll.add(3);
		msll.add(4);
		msll.insert(5, 0);
		msll.swap(3);
		//msll.delete(0);
		msll.printList();
		//System.out.println(msll.get(0));//0 steps of for
		//System.out.println(msll.get(3));//3 steps of for

	}
}
