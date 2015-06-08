package de.oliver.ePortfolio.Lambdas;

import java.util.function.Consumer;

public class TestKlasse {
	public static void main(String[] args) {
		double erg = calculate(2.0,10.0,(a,b)->a+b);
		consume(erg,System.out::println);
	}
	
	public static double calculate(double a, double b, FunktionalInterface c){
		return c.calc(a, b);
	}
	
	public static void consume(double a, Consumer<Double> c){
		c.accept(a);
	}
}
