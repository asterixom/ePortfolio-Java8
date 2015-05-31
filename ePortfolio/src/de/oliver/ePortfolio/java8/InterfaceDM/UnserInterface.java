package de.oliver.ePortfolio.java8.InterfaceDM;

public interface UnserInterface {

	public void methodeA();
	// GEHT NICHT:
	/*public void methodeB(){
		
	}*/
	
	public default void methodeC(){
		System.out.println("Default C!");
	}
	
	public default void methodeD(){
		System.out.println("Default D!");
	}
}
