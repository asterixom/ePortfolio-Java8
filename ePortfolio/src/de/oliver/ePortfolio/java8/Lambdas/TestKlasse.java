package de.oliver.ePortfolio.java8.Lambdas;

import java.util.function.Consumer;

public class TestKlasse {
	public static void main(String[] args) {
		double erg1 = calculate(2.0, 10.0, new FunktionalInterface() {
			
			@Override
			public double calc(double a, double b) {
				return a+b;
			}
		});
		double erg2 = calculate(2.0,10.0,(c,b)->{
			return c+b;
			});
		
		double erg3 = calculate(2.0, 10.0, (a,b)->a+b);
		
		
		consume(erg1,new Consumer<Double>() {
			
			@Override
			public void accept(Double t) {
				System.out.println(t);
			}
		});
		consume(erg2,(x)->System.out.println(x));
		consume(erg3,System.out::println);
	}
	
	public static double calculate(double a, double b, FunktionalInterface c){
		return c.calc(a, b);
	}
	
	public static void consume(double a, Consumer<Double> c){
		c.accept(a);
	}
}
