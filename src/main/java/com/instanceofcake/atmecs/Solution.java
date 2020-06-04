package com.instanceofcake.atmecs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public String solution(String input) {
		if (input == null || input.trim().length() <= 0) {
			return null;
		}
		String result = "";

		char[] inputArray = input.toCharArray();
		String firstChar = String.valueOf(inputArray[0]);

		if (firstChar.equalsIgnoreCase("a") || firstChar.equalsIgnoreCase("e") || firstChar.equalsIgnoreCase("i")
				|| firstChar.equalsIgnoreCase("o") || firstChar.equalsIgnoreCase("u")) {

			 result = alterInCaseVowel(inputArray);

		} else {
			result = alterInConsonant(input);
		}

		return result;

	}

	private String alterInConsonant(String input) {
		char[] inputArray = input.toCharArray();
		String newInput = new String(input);
		StringBuilder buff = new StringBuilder();
		Map<Integer, Boolean> indexCaseMap = new HashMap<Integer, Boolean>();
		Character first = Character.valueOf(inputArray[0]);
		indexCaseMap.put(0, Character.isUpperCase(first));
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] == ' ') {
				Character next = Character.valueOf(inputArray[i + 1]);
				indexCaseMap.put(i + 1, Character.isUpperCase(next));
			}

		}

		int index = newInput.indexOf(' ');
		buff.append(newInput.substring(index + 1, newInput.length()));
		buff.append(" ");
		buff.append(newInput.substring(0, index));

		char[] buffArray = buff.toString().toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < buffArray.length; i++) {
			if (indexCaseMap.containsKey(i)) {
				boolean isUpperCase = indexCaseMap.get(i);
				Character charV = Character.valueOf(buffArray[i]);
				if (isUpperCase) {
					result.append(Character.toUpperCase(charV));
				} else {
					result.append(Character.toUpperCase(charV));
				}
			} else {
				if (!indexCaseMap.containsKey(i)) {

					result.append(buffArray[i]);

				}
			}
		}

		return result.toString();
	}

	private String alterInCaseVowel(char[] inputArray) {
		String result = "";
		StringBuilder buff = new StringBuilder();
		boolean append = true;
		for (int i = 0; i < inputArray.length - 1; i++) {
			if (i == 0) {
				buff.append(Character.toUpperCase(inputArray[0]));

			} else if (inputArray[i] == ' ') {
				char nextChar = inputArray[i + 1];
				if (nextChar != ' ' && append == true) {
					buff.append(inputArray[i]);
				}
				buff.append(Character.isUpperCase(nextChar) ? Character.toLowerCase(nextChar)
						: Character.toUpperCase(nextChar));
			} else if (i != 0 || inputArray[i] != ' ') {

				buff.append(inputArray[i + 1]);
				append = false;

			}
		}
		result = buff.toString();
		return result;

	}

}
