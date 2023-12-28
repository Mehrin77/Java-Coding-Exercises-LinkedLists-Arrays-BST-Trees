package com.gradescope.hw7;

/**
 * A guinea pig.
 */
//public class GuineaPig {
public class GuineaPig implements Comparable<GuineaPig>, Squeakable { 
	private int age;
	private String name;

	/**
	 * Initializes a new guinea pig object.
	 * 
	 * @param name - the name
	 * @param age  - the age
	 */
	public GuineaPig(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Initializes a new guinea pig object with default name "arya" and age 1 (Prof
	 * Wu's pet).
	 */
	public GuineaPig() {
		this("arya", 1);
	}

	/**
	 * Returns the name of this guinea pig.
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(GuineaPig o) {
		// TODO Auto-generated method stub
		if (this.age > o.age   ) {
			return 1; 
		}
		if (this.age == o.age) {
			if (this.name.equals(o.name) ){
				return 0;
			}
			return (this.name.compareTo(o.name)); 
				
		}
		
		return -1; 
	}
	
	/**
	 *  returns the Squeak of a Guinea Pig
	 */
	@Override
	public String squeak() {
		return "Squeak! (Feed me!)";
	}
}

// In line 40 compare the age. Returns 1 if this > o then this is greater
// if ages are equal then names are compares. If names are equal then both are equal. 
// if age of this < o then then o is greater and returns -1
