package com.gradescope.hw7;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClarinetTest {

	@Test
	public void testClarinet() {
		Clarinet s = new Clarinet();
	}

	@Test
	public void testGetKey() {
		Clarinet c = new Clarinet();
		assertEquals(c.getKey(), "Bb");
	}
	
	@Test
	public void testStatic () {
		Instrument i = new Clarinet();
		assertEquals (i.getKey(),"Bb");
	}
	@Test 
	public void test_Squeak() {
		Clarinet c = new Clarinet();
		assertEquals ("Squeak! (Need more practice...)", c.squeak() ); 
	}
	@Test 
	public void testStaticSqueak() {
		Squeakable s = new Clarinet();
		assertEquals ("Squeak! (Need more practice...)", s.squeak() );
	}

}
