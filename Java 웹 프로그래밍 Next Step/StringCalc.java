package StringCalc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc {
	public int add(String input) throws Throwable {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		
		int[] nums = tokenize(input);
		int total = calcTotal(nums);
		return total;
	}
	
	private int[] tokenize(String input) {
		String[] intString = null;
		int[] intArray = null;
		
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		// Custom Delimiter
		if (m.find()) {
			String customDelimeter = m.group(1);
			intString = m.group(2).split(Pattern.quote(customDelimeter));
		}
		// Formal Delimiter
		else {
			intString = input.split(",|:");
		}
		
		intArray = new int[intString.length];
		for (int i = 0; i < intArray.length; ++i) {
			intArray[i] = Integer.parseInt(intString[i]);
		}
		return intArray;
	}
	
	private int calcTotal(int[] nums) {
		int sum = 0;
		for(int num : nums) {
			if(num < 0) throw new IllegalArgumentException();
			sum += num;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
	}	
}
