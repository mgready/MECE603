package assignment3_201993133_Magzhan_Amangeldi;

public class Main {
	
	public static void main(String[] args) {
		
		Deque D = new Deque<>();
		
		D.add_last(5);
		System.out.println(D);
		
		D.add_first(3);
		System.out.println(D);
		
		D.add_first(7);
		System.out.println(D);
		
		System.out.println(D.first());
		System.out.println(D);
		
		System.out.println(D.delete_last());
		System.out.println(D);
		
		System.out.println(len(D));
		
		System.out.println(D.delete_last());
		System.out.println(D);
		
		System.out.println(D.delete_last());
		System.out.println(D);
		
		D.add_first(6);
		System.out.println(D);
		
		System.out.println(D.last());
		System.out.println(D);
		
		D.add_first(8);
		System.out.println(D);
		
		System.out.println(D.isEmpty());
		
		System.out.println(D.last());
		System.out.println(D);

	}
	private static int len(Deque D) {
		return D.size();
	}

}
