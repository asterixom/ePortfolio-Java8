package de.oliver.ePortfolio.java8.overflow;

public class OverflowTest {

	public static void main(String[] args) {
		for (int x = Integer.MAX_VALUE - 30; x > 0; x += 10) {
			System.out.print("normal:");
			int y = x + 10;
			System.out.println(x + "+10=" + y);
			System.out.print("addExact: ");
			int z = Math.addExact(x, 10);
			System.out.println(x + "+10=" + z);
			System.out.println();
		}
	}
}
