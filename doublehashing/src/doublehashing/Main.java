package doublehashing;

public class Main {

	public static void main(String [] args) {
	
	HashTable hashtable = new HashTable();
	
    Integer[] numbers = {23, 45, 12, 34, 56, 78, 90, 1, 5, 3, 9, 25, 41, 60, 88};
	for (Integer num : numbers) {
		hashtable.add(num);
		
	}

    hashtable.print();
   
    System.out.println(hashtable.contains(45));
    System.out.println(hashtable.contains(99));
	}
}
