package co.uk.dev.codility.examples;

import static java.lang.Integer.toBinaryString;

import java.util.stream.Stream;

/**
 * This is Binary GAP solution from codility
 */
public class CalculateBinaryGap {
	public static void main(String[] args) {
		CalculateBinaryGap cal = new CalculateBinaryGap();
		System.out.println(cal.calculateBinaryGap(37));

	}

	public int calculateBinaryGap(int N) {
		return Stream
				.of(
						// integer to binary string
						toBinaryString(N)
								// trim 0(s) at the end
								.replaceAll("0+$", "")
								// split string with 1(s)
								.split("1+"))
				// lambda expressions: use filter to keep not null elements
				.filter(a -> a != null)
				// method references: convert string to integer by using the
				// length of string
				.map(String::length)
				// method references: find the largest number in the stream by
				// using integer comparator
				.max(Integer::compare)
				// return 0 if nothing matches after the process
				.orElse(0);
	}
}
// http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
