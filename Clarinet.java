package com.gradescope.hw7;

public class Clarinet extends Instrument implements Squeakable {
	
	public Clarinet() {
		super("Bb");
	}

	/**
	 *  returns the Squeak of a clarinet.
	 */
	@Override
	public String squeak() {
		return  "Squeak! (Need more practice...)";
	}
}
