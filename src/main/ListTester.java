package main;

public class ListTester {

    public static void main (String[] args){

    	//TODO: Test cases should be made here
    	ComputerList cl = new ComputerList();
    	Computer c = Computer.createRandomComputer();
    	cl.addToEnd(c);
    	cl.print();
	
	}
}
