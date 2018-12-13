package problem1;

import java.util.Collection;

public interface Problem1 {
	//appends new object o
	void add(Object o);
	
	//adds object o at index i
	void add(int i, Object o);
	
	//adds everything from collection c to list
	void addAll(Collection c);
	
	//Removes all elements from list
	void  clear();
	
	//returns true if list contains object o
	boolean contains(Object o);
	
	//returns index of object o
	int indexOf(Object o);
	
	//returns true if list contains no elements
	boolean isEmpty();
	
	//returns index of last matching element in list
	int lastIndexOf(Object o);
	
	//removes element at index and returns it from list
	Object remove(int index);
	
	//removes the object from list, returns true is successful
	boolean remove(Object o);
	
	//removes from this list all elements in collection list
	void removeAll(Collection c);
	
	//removes everything from list from index to index
	void removeRange(int fromindex, int toindex);
	
	//keeps in list only objects in the collection
	void retainAll(Collection c);
	
	//sets element at inex to object o
	void set(int index, Object o);
	
	//returns number of elements in list
	int size();
	
	//returns a list from the from index to the toindex
	Object[] subList(int fromindex, int toindex);
	

}
