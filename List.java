package com.gradescope.hw6;

import java.util.NoSuchElementException;

/**
 * A singly-linked list in which each element references the next element.
 */
public class List<DataType extends Comparable<DataType>> {

	private ListNode myHead;
	private int mySize;

	/**
	 * Constructs an empty list
	 */
	public List() {
		this.myHead = null;
		this.mySize = 0;
	}

	/**
	 * A node in a list that contains data and references the next node.
	 */
	private class ListNode {

		private DataType myData;
		private ListNode myNext;

		private ListNode(DataType element, ListNode next) {
			this.myData = element;
			this.myNext = next;
		}

		private ListNode(DataType element) {
			this(element, null);
		}
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int length() {
		return this.mySize;
	}

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty() {
		return this.length() == 0;
	}

	/**
	 * Returns a string representation of this list.
	 * 
	 * The string representation consists of the list's elements in order, separated
	 * by a space. Elements are converted to strings by object.toString().
	 * 
	 * @return a string representation of this list
	 */
	public String toString() {
		String result = "( ";
		ListNode node = this.myHead;
		while (node != null) {
			result = result + node.myData.toString() + " ";
			node = node.myNext;
		}
		return result + ")";
	}

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * More formally, if o==null, this list returns true if and only if this list
	 * contains at least one null element. Otherwise, this list returns true if and
	 * only if this list contains at least one element e such that o.equals(e).
	 * 
	 * @param o - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(DataType o) {
		if (o == null) {
			for (ListNode node = this.myHead; node != null; node = node.myNext) {
				if (node.myData == null) {
					return true;
				}
			}
		} else {
			for (ListNode node = this.myHead; node != null; node = node.myNext) {
				if (o.equals(node.myData)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	public DataType get(int index) {
		// check that index is within the bounds of the list
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index to get must be at least 0.");
		}
		if (index >= this.length()) {
			throw new IndexOutOfBoundsException("Index to get is too large.");
		}

		// iterate through the list and find the right node
		int currentIndex = 0;
		ListNode currentNode = this.myHead;
		while (currentIndex != index) {
			currentIndex++;
			currentNode = currentNode.myNext;
		}

		return currentNode.myData;
	}

	/**
	 * Compares the specified object with this list for equality.
	 * 
	 * Returns true if and only if the specified object is also a list, both lists
	 * have the same size, and all corresponding pairs of elements in the two lists
	 * are equal. In other words, two lists are defined to be equal if they contain
	 * the same elements in the same order.
	 * 
	 * @param obj - the object to be compared for equality with this list
	 * @return true if the specified object is equal to this list
	 */
	public boolean equals(Object obj) {
		// @CS60: You do not need to understand the code in this method,
		// but feel free to take a look and ask questions about it,
		// if you are interested!

		// if obj is not of type List, they are not equal
		if (!(obj instanceof List)) {
			return false;
		}

		// cast the object to a List and use the overloaded version of equals
		@SuppressWarnings("unchecked")
		List<DataType> other = (List<DataType>) obj;
		// if the two lists are different sizes, they are not equal
		if (this.mySize != other.mySize) {
			return false;
		}

		// compare element by element
		ListNode node1 = this.myHead;
		ListNode node2 = other.myHead;
		for (int i = 0; i < this.mySize; i++) {
			// get the two strings, so we can compare them
			DataType s1 = node1.myData;
			DataType s2 = node2.myData;
			if (!s1.equals(s2)) {
				return false;
			}
			node1 = node1.myNext; // walk down this list
			node2 = node2.myNext; // walk down other list
		}
		return true;
	}

	/**
	 * Inserts the specified element at the beginning of this list.
	 * 
	 * Note that the list is modified. Nothing is returned. It is different than the
	 * constructor, which does create a new list.
	 * 
	 * @param e - the element to add
	 */
	public void addFirst(DataType e) {
		ListNode newNode = new ListNode(e); //data stored in a node
		newNode.myNext = this.myHead; //data directed to lst
		this.myHead = newNode; //head of the lst is replaced
		this.mySize +=1; //incrementing the size ff the lst
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws NoSuchElementException if this list is empty
	 */
	public DataType removeFirst() {
		if (this.isEmpty() ) {
			throw new NoSuchElementException();
		}
		
		DataType result= this.myHead.myData;
		this.myHead= this.myHead.myNext; 
		this.mySize -=1; 
		return result;
	}

	/**
	 * Removes the first element from this list and adds it at the beginning of the
	 * other list.
	 * 
	 * @param other - the list to which to move the element
	 * @throws NoSuchElementException if this list is empty
	 */
	public void moveFirstElementTo(List<DataType> other) {
		if (this.isEmpty() ) {
			throw new NoSuchElementException();
		}
		ListNode temp = this.myHead;
		this.myHead = temp.myNext;
		if (other.isEmpty() ) {
			other.myHead =temp;
			other.myHead.myNext= null;
		}
		else {
			temp.myNext = other.myHead;
			other.myHead= temp;
		}
		this.mySize -=1;
		other.mySize +=1;
	
		// Do this without creating a new ListNode (meaning you cannot use addFirst).
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * Note that the list is modified. Nothing is returned. It is different than the
	 * constructor, which does create a new list.
	 * 
	 * @param e - element to be appended to this list
	 */
	public void add(DataType e) {
		ListNode newNode= new ListNode(e); //creates new node
		if (this.isEmpty() ) {
			this.myHead= newNode; 
		}
		else {
			ListNode node = this.myHead;
			while (node.myNext != null) {
				node = node.myNext;
			}
			node.myNext = newNode;
		}
		this.mySize += 1;
		 
	}

	/**
	 * Constructs a list containing containing the elements of the string array, in
	 * the same order.
	 * 
	 * This static method can be thought of as another constructor.
	 * 
	 * @param stringArray - the array whose elements are to be placed into this list
	 */
	public static List<String> makeFromStringArray(String[] stringArray) {
		List<String> result = new List<String>();
		for (int i = stringArray.length -1; i>=0; i--) { //runs string array in reverse to keep the order correct
			result.addFirst(stringArray[i] );
		}
		/**
		 * Use addFirst, **not** add. addFirst takes constant time whereas add takes
		 * time proportional to the size of the list. This implementation will allow you
		 * to add all elements to your list in time proportional to stringArray.length.
		 */
		return result;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element). Elements are converted to strings by
	 * object.toString().
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence
	 */
	public String[] toStringArray() { 
		String[] result= new String[this.mySize]; //creating empty array
		ListNode node = this.myHead; //starts at he head
		int i=0; //index array
		while (node != null) {
			result[i] = (String) node.myData; //adds data to array
			node = node.myNext;
			i+=1;
		}
		return result;
	}
		
	/**
	 * Appends all of the elements in the other list to the end of this list, in the
	 * order that they are stored by the other list.
	 * 
	 * This operation is in-place. Note that the other list should not be modified
	 * while the operation is in progress. (This will occur if the specified
	 * collection is this list, and it is nonempty.)
	 * 
	 * @param other - list containing elements to be added to this list
	 */
	public void append(List<DataType> other) {
		if (other.isEmpty()) {
			return;
		}
		if (this.isEmpty()) {
			this.myHead= other.myHead;
			this.mySize= other.mySize;
			return;
		}
		ListNode node = this.myHead;
		while (node.myNext != null) {
			node = node.myNext;
		}
		node.myNext = other.myHead;
		this.mySize += other.mySize;
	}
	

	/**
	 * Reverses the elements of this list.
	 * 
	 * This operation is in-place.
	 */
	public void reverse() {
		if (this.isEmpty() ) {
			return;
		}
		ListNode prev = null;
		ListNode curr = this.myHead;
		ListNode nex = this.myHead.myNext;
		while (curr != null) {
			nex = curr.myNext; 
			curr.myNext =prev;
			prev =curr;
			curr = nex;
		}
		this.myHead =prev;
		/**
		 * We recommend creating ListNode references to refer to the previous, current,
		 * and next ListNode as you "walk" the list...
		 */
	}

	/**
	 * Splits this list in two.
	 * 
	 * Afterwards, this list contains only elements from the first half, and the
	 * returned list contains only elements from the second half.
	 * 
	 * If this list has an odd number of elements, afterwards, it should contain one
	 * more element than the list that is returned. If this list has one element, it
	 * is unmodified, and an empty list is returned.
	 * 
	 * @return a new list that contains the second half of the elements in the
	 *         original list
	 */
	public List<DataType> split() {
		List<DataType> result = new List<>();
		if ( this.mySize ==1) {
			return result;
		}
		int m =0;
		int newSize=0;
		if (this.mySize %2 ==0) { //even n/2
			m = this.mySize/2; 
			newSize =m;
		}
		else  {
			m = ((this.mySize +1)/2 ); //for odd n+1/2
			newSize=m-1;
		}
		
		ListNode node = this.myHead;
		int i=1;
		int thisSize =m;
		while (i != m) {
			node= node.myNext;
			i+=1;
		}
		result.myHead = node.myNext;
		node.myNext = null;
		result.mySize= newSize;
		this.mySize= thisSize ;
		return result;
	}

	/**
	 * Merges this list with the other list.
	 * 
	 * Both this list and other list should already be in sorted order.
	 * 
	 * This method will modify this list and the other list. When completed, other
	 * should be empty and this list should contain all elements in sorted order.
	 * 
	 * @param other - the list to be merged with this list
	 */
	public void merge(List<DataType> other) {
		if (other.isEmpty() ) {
			return;
		}
		if (this.isEmpty() ) {
			this.myHead = other.myHead;
			this.mySize = other.mySize;
			other.myHead= null; 
			other.mySize = 0;
			return;	
		}
		int resultSize = this.mySize + other.mySize;
		List<DataType> result = new List<>(); //creates a empty list to work with
		ListNode thisHead = this.myHead; // thisHead is a new variable
		ListNode otherHead = other.myHead; //thisHead and otherHead is the current nodes
		while (thisHead != null && otherHead != null) { //iterates over lst until one ends
			if ( thisHead.myData.compareTo(otherHead.myData) <= 0) { //checks smaller/equal
				this.moveFirstElementTo(result); //first element moves to result
				thisHead =this.myHead; //2nd element becomes the first head
			}
			else {
				other.moveFirstElementTo(result); //sorted order but reverse as add to first not last
				otherHead = other.myHead;
			}
		}
		result.reverse(); //reversed back to keep the order correct
		if (thisHead == null) {
			result.append(other);
		}
		else {
			result.append(this); 
		}
		this.myHead = result.myHead; //updating
		this.mySize = resultSize; //update  size
		other.myHead = null; 
		other.mySize = 0;

		/**
		 * You will find Java's compareTo method helpful.
		 * 
		 * You can make an extra List object (such as the mergedList that will become
		 * the result), but you should not create any new ListNode Objects.
		 */
	}

	/**
	 * Sorts this list using merge sort.
	 */
	public void mergeSort() {
		if (this.myHead.myNext == null ) { //itirates before the null
			return;
		}
		List<DataType> other = this.split(); 
		this.mergeSort();
		other.mergeSort();
		this.merge(other);
		// Use split() and merge(List other).
	}

	public static void main(String[] args) {
		System.out.println("You can add code here to test your List implementation!");
		System.out.println("Also, look at the assignment for debugging tips.");

		// For example, you might start like this:
		// List<Dog> myList = new List<Dog>();
		// System.out.println(myList.myHead.myData);
	}
}
