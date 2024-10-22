package main;

public class ListDemo {

	public static void main(String[] args) {
		LL<Computer> list1 = new LL<>();
		Computer c1 = Computer.createRandomComputer();
		Computer c2 = Computer.createRandomComputer();
		Computer c3 = Computer.createRandomComputer();
		Computer c4 = Computer.createRandomComputer();
		list1.append(c1);	
		list1.append(c2);
		list1.append(c3);
		System.out.println(list1);
		
		LL<Computer> list2 = new LL<>(list1.getHead()); // list2 = computerList
		LL<Computer> list3 = new LL<>(list1.getHead());
		list3.append(c4);
		list3.delete(2);
		
		System.out.println("List 1 and 2 equals? " + list1.equals(list2) );
		System.out.println("List 1 and 3 equals? " + list1.equals(list3) );
		
		// TODO: add tester commands for union and intersection as needed. 
		
	}

}
