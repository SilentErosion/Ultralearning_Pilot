package StringCalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc {
	public int add(String input) {
		if (isEmpty(input)) {
			return 0;
		}

		String[] intStrings = tokenize(input);
		int[] posInts = toPosInts(intStrings);
		int total = calcTotal(posInts);

		return total;
	}

	private String[] tokenize(String input) {
		String[] strings = null;

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		// Custom Delimiter
		if (m.find()) {
			String customDelimeter = m.group(1);
			strings = m.group(2).split(Pattern.quote(customDelimeter));
		}
		// Formal Delimiter
		else {
			strings = input.split(",|:");
		}

		return strings;
	}

	private int calcTotal(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private int[] toPosInts(String[] strings) {
		int[] posInts = new int[strings.length];
		for (int i = 0; i < posInts.length; ++i) {
			posInts[i] = Integer.parseInt(strings[i]);
			if (posInts[i] < 0) {
				throw new RuntimeException();
			}
		}
		return posInts;
	}

	public static void main(String[] args) {

	}
}
