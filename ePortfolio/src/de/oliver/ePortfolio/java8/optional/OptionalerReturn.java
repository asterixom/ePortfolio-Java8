package de.oliver.ePortfolio.java8.optional;

import java.util.Optional;

public class OptionalerReturn {

	public static void main(String[] args) {
		System.out.println(new OptionalerReturn(null).getName().orElse("KeinName"));
		System.out.println(new OptionalerReturn("NichtNull").getName().orElse("KeinName"));
	}
	
	public OptionalerReturn(String name){
		this.name = name;
	}
	
	private String name;
	
	public Optional<String> getName(){
		return Optional.ofNullable(name);
	}
	
}
