package assignment3_201993133_Magzhan_Amangeldi;


public class Deque<T> {
	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public Deque() {
		first = null;
		last = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;	
	}
	
	public void add_first(T val) {
		Node<T> node  = new Node<>(val);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.next = first;
		    first.prev = node;
		    first = node;
		}
		size ++;
	}
	
	public void add_last(T val) {
		Node<T> node  = new Node<>(val);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			node.prev = last;
			last.next = node;
			last = node;
		}
		size ++;
	}
	
	public T delete_first() {
		if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
		T val = first.val;
		first = first.next;
		if ( first != null) {
			first.prev = null;
		} else {
			last = null;
		}
		
		size --;
		return val;
	}
	
	public T delete_last() { 
		if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
		T val = last.val;
		last = last.prev;
		if ( last != null) {
			last.next = null;
		} else {
			first = null;
		}
		size -- ;
		return val;
	}
	
	public T first() {
		if (isEmpty()) {
	            throw new IllegalStateException("Deque is empty");
	        }
		return this.first.val;
	}

	public T last() {
		if (isEmpty()) {
	            throw new IllegalStateException("Deque is empty");
	        }
		return this.last.val;
	}
	@Override
	public String toString() {
		String s = "[";
		Node<T> current = first;
		
		while(current != null) {
			s += current.val;
			if (current != last) {
				s += ", ";
			}
			current = current.next;
		}
		s += "]";
		return s;
		
	}
	

}
