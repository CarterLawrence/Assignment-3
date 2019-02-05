package problem2;
import java.util.*;
public class Ciculartester {
	public static void main(String[] args){
		Circularlinkedlist<Integer> Hotpotato = new Circularlinkedlist<Integer>();
		Scanner scan = new Scanner(System.in);
		int amount1, amount2;
		System.out.println("The number of people playing: ");
		amount1 = scan.nextInt();
		for(int i = 1; i < amount1+1; i++){
			Hotpotato.add(i);
		}
		System.out.println("The number of passes for each round: ");
		amount2 = scan.nextInt();
		for(int i = 1; i < amount1; i++){
			Hotpotato.pass(amount1);
		}
		System.out.println("Player "+Hotpotato.get(0)+" wins");

}
}
