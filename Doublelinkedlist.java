package problem1;


public class Doublelinkedlist<E> {
	private Node start, end;
	private int currentCount;
	public Doublelinkedlist()
	{
		start = null;
		end = null;
		currentCount = 0;
	}
	public void printList()
	{
		Node current = start;
		while(current != null)
		{
			System.out.println(current.value);
			current = current.next;
		}
	}
	public void printListRev()
	{
		Node current = end;
		while(current != null)
		{
			System.out.println(current.value);
			current = current.prev;
		}
	}
	public void add(E val)//O(1)
	{
		Node newItem = new Node(val);

		//if list is empty
		if(start == null)
		{
			start = newItem;
			end = start;//only item in list means end = start
			currentCount++;
		}
		//if list has items
		else
		{
			end.next = newItem;//end -> newItem
			newItem.prev = end;//end <- newItem
			end = newItem;
			currentCount++;
		}
	}
	public void insert(E val, int index)
	{
		if(index < 0)
		{
			index = 0;
		}
		if(index >= currentCount)//insert at end is same as add
		{
			this.add(val);
		}
		else
		{
			Node newItem = new Node(val);
			if(index == 0)//special case, changing start variable
			{
				newItem.next = start;//current list comes after new item
				start.prev = newItem;
				start = newItem;//new item is first in list
			}
			else
			{
				Node current = start;
				for(int i = 1; i < index; i++)
				{
					current = current.next;
				}
				//System.out.println(current.value);

				//current == before at this point
				//current/before <-> index <-> after
				//1 <-> 2 <-> 3
				//goal
				//before <-> new <-> index <-> after
				//1 <-> new <-> 2 <-> 3
				newItem.next = current.next;//new -> index
				current.next.prev = newItem;//new <- index
				current.next = newItem;//before -> new
				newItem.prev = current;//before <- new
			}
			currentCount++;
		}
	}
	public void delete(int index)
	{
		if(index >= 0 && index < currentCount)
		{
			if(index==0)//deal with special case
			{
				start = start.next;
				if(start != null)//in case list just became empty
				{
					start.prev = null;
				}
				else
				{
					end = null;
				}
			}
			else if(index == currentCount -1)
			{
				end = end.prev;
				if(end != null)
				{
					end.next = null;
				}
				else
				{
					start = null;
				}
			}
			else
			{
				Node current = start;
				for(int i = 1; i < index; i++)//find item before the one being deleted
				{
					current = current.next;
				}
				current.next = current.next.next;
				//current <-> deleteMe <-> restoflist
				//current -> restoflist
				//current <- deleteMe <- restoflist
				if(current.next != null)//incase we deleted the last item
				{
					current.next.prev = current;//current <- restoflist
				}
			}
			currentCount--;
		}
	}
	public void swap(int index){
		 if (index == 0){
			 Node temp = start.next;
		     start.next = start.next.next;
		     start.prev = temp;
		     start.next.prev = start;
		     temp.next = start;
		     temp.prev = null;
		     start = temp;
		}else{
			 Node temp = start;
			 
			 for(int i = 0; i < index-1; i++){//goes to node prior to index
		     temp = temp.next;
			 }
			 
			 Node a = temp;
			 Node n = temp.next.next;//node that comes after index
			 Node t = temp.next.next.next;//node that comes after Node n
			 temp = temp.next;
			 
			 t.prev = temp;
			 n.prev = a;
			 temp.prev = n;
			 
			 a.next = n;
			 a.next.next = temp;
			 temp.next = t;
			 
		}
	}


	public E get(int index)//O(N)//could be improved to O(N/2) by starting from start/end depending on index
	{
		if(index >= 0 && index < currentCount)
		{
			Node current = start;
			for(int i = 0; i < index; i++)
			{
				current = current.next;
			}
			//current = node at the index
			return current.value;
		}
		else
		{
			return null;
		}
	}

	private class Node
	{
		E value;
		Node next, prev;
		public Node(E v)
		{
			value = v;
			next = null;//no node after this one
			prev = null;
		}
	}
}
