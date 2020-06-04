package com.instanceofcake.atmecs;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolutionVowel() {
		Solution solution = new Solution();
		String input = "A paper is on the Table";

		String result = solution.solution(input);
		assertEquals("A Paper Is On The table", result);
	}
	
	@Test
	public void testSolutionConsonant() {
		Solution solution = new Solution();
		String input = "This is Paperless";

		String result = solution.solution(input);
		assertEquals("Is paperLess this", result);
	}

}
