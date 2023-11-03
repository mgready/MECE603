package doublehashing;

public class HashTable {
	
	private Integer size = 13;
	private Integer[] table = new Integer [size];

	public HashTable() {
	  
	}
	public HashTable(Integer size) {
		this.size = size;
		this.table = new Integer[size];
	}
	public Integer getSize() {
		return this.size;
	}
	private Integer h1(Integer key) {
		return key % size;
	}
	private Integer h2(Integer key) {
		return 11 - key%11;
	}
	private Integer getIndex(Integer key, Integer i) {
		return (h1(key)+h2(key)*i)%size;
	}
	
	public void add(Integer key) {
		Integer i = 0;
		
		while(i<size) {
			
			Integer index = getIndex(key,i);
	    if (table[index]==null) {
	    	table[index] = key;
	    	return;
	    }
	    i++;
		}
		
	}
	
	public boolean contains(Integer key){
		
		Integer i = 0 ;
		while(i<size) {
			Integer index = getIndex(key,i);
			if(table[index] == key){
				return true;
				
			} 
			if(table[index] == 0){
				return false;
				
			}
			i ++ ;
		}
		return false;
		
		
	}
	
	public void print() {
		System.out.println("ht: ");
		for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
	}
}
