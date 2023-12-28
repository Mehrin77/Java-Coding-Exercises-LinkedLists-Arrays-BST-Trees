package com.gradescope.hw7;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuineaPigTest {

	@Test
	public void testGuineaPigStringInt() {
		GuineaPig g = new GuineaPig ("pepo", 13);
	}

	@Test
	public void testGuineaPig() {
		GuineaPig g = new GuineaPig ();
	}

	@Test
	public void testGetName() {
		GuineaPig g = new GuineaPig ("pepo", 13);
		assertEquals("pepo", g.getName());
	}

	@Test
	public void testCompareTo_equal() {
		GuineaPig g = new GuineaPig ("pepo", 13);
		GuineaPig h = new GuineaPig ("pepo", 13);
		assertTrue(g.compareTo(h) == 0);
		
	}

	@Test
	public void testCompareTo_lessThan() {
		GuineaPig g = new GuineaPig ("pepo", 13);
		GuineaPig h = new GuineaPig ("pepo", 15);
		GuineaPig i = new GuineaPig ("quora", 13);
		assertTrue(g.compareTo(h) < 0);
		assertTrue(g.compareTo(i) < 0 );
		
	}

	@Test
	public void testCompareTo_greaterThan() {
		GuineaPig g = new GuineaPig ("pepo", 15);
		GuineaPig h = new GuineaPig ("pepo", 13);
		GuineaPig i = new GuineaPig ("appo", 15);
		assertTrue(g.compareTo(h) > 0);
		assertTrue(g.compareTo(i) > 0 );
		
	}
	@Test
	public void testComparable() {
		Comparable <GuineaPig> g = new GuineaPig ("pepo", 15);
		GuineaPig h = new GuineaPig ("pepo", 13);
		GuineaPig i = new GuineaPig ("appo", 15);
		assertTrue(g.compareTo(h) > 0);
		assertTrue(g.compareTo(i) > 0 );
	}
	@Test
	public void testStaticComparable() {
		Comparable <GuineaPig> g = new GuineaPig ("pepo", 15);
		//assertEquals ("pepo", g.getName());
		//getName does not work for static reference
	}
	
	@Test 
	public void test_Squeak() {
		GuineaPig g = new GuineaPig ();
		assertEquals ("Squeak! (Feed me!)", g.squeak());
	}
	
	@Test
	public void testStaticReference () {
		Squeakable s = new GuineaPig();
		//assertEquals ("arya", s.getName() );
		//getName does not work for static reference
	}
	
	@Test 
	public void testStaticSqueak() {
		Squeakable s = new GuineaPig();
		assertEquals ("Squeak! (Feed me!)", s.squeak() );
		
	}
	
}
