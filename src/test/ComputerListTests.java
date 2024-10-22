package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import main.Computer;
import main.LL;
import main.Node;

class ComputerListTests {

	private Computer c1 = new Computer("Linux", 18.924675, true, 2048, 16, "0731521140");
	private Computer c2 = new Computer("Linux", 19.01026191, true, 1024, 1024, "6406911217");
	private Computer c3 = new Computer("Windows", 19.2986662, true, 2048, 8, "3755316498");
	private Computer c4 = new Computer("Windows", 9.41772366, false, 4, 16, "7525419077");
	private Computer c5 = new Computer("Windows", 15.67663, true, 1024, 2, "8505746556");
	private Computer c6 = new Computer("Macintosh", 17.5708493, true, 16, 8, "3128709750");
	private Computer c7 = new Computer("Linux", 2.344601, true, 4, 256, "4411016555");

	/**
	 * Check you're actually doing the assignment...
	 */
	@Test
	public void noCheatingTest() {
		LL<Computer> testList = new LL<>();
		// Prevent hiding the list by creating on add
		testList.append(Computer.createRandomComputer());
		testList.append(Computer.createRandomComputer());

		Field[] fields = testList.getClass().getDeclaredFields();
		boolean collectionField = false;
		boolean nodeField = false;
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				collectionField |= field.get(testList) instanceof Collection;
			} catch (IllegalAccessException | IllegalArgumentException ignored) {
			}

			nodeField |= field.getType() == Node.class;
		}
		assertTrue(nodeField, "You need to have at least one node in your class's objects");
		assertFalse(collectionField, "No using preexisting Collections...");
	}

	/**
	 * Tests that the {@link TruckList#getSize()} is correct after inserting a new
	 * {@link Truck} with the {@link TruckList#addToStart(Truck)} method.
	 */
	@Test
	public void union01() {
		LL<Computer> testList = new LL<>();
		LL<Computer> list2 = new LL<>();

		testList.append(c1);
		testList.append(c2);
		testList.append(c3);
		list2.append(c1);
		list2.append(c2);
		list2.append(c4);

		testList.union(list2);

        assertEquals(4,testList.size(),"Wrong size of resultant list");

		// 1 2 3 and 4 should be in there but not more than once

		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;

		for (Node<Computer> tmp = testList.getHead(); tmp != null; tmp = tmp.getNext()) {
			Computer data = tmp.getData();
			if (data.equals(c1) && !b1) {
				b1 = true;
			} else if (data.equals(c1) && b1) {
				fail("Computer 1 found multiple times in list");
			}

			if (data.equals(c2) && !b2) {
				b2 = true;
			} else if (data.equals(c2) && b2) {
				fail("Computer 2 found multiple times in list");
			}

			if (data.equals(c3) && !b3) {
				b3 = true;
			} else if (data.equals(c3) && b3) {
				fail("Computer 3 found multiple times in list");
			}

			if (data.equals(c4) && !b4) {
				b4 = true;
			} else if (data.equals(c4) && b4) {
				fail("Computer 4 found multiple times in list");
			}
		}

		if (!(b1 && b2 && b3 && b4)) {
			fail("One or more elements not found in list");
		}

	}

	@Test
	public void union02() {
		LL<Computer> testList = new LL<>();
		LL<Computer> list2 = new LL<>();

		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;


		testList.append(c2);
		testList.append(c3);

		list2.append(c1);
        list2.append(c4);

        testList.union(list2);
        assertEquals(4,testList.size(),"Wrong size of resultant list");


        for (Node<Computer> tmp = testList.getHead(); tmp != null; tmp = tmp.getNext()) {
			Computer data = tmp.getData();
			if (data.equals(c1) && !b1) {
				b1 = true;
			} else if (data.equals(c1) && b1) {
				fail("Computer 1 found multiple times in list");
			}

			if (data.equals(c2) && !b2) {
				b2 = true;
			} else if (data.equals(c2) && b2) {
				fail("Computer 2 found multiple times in list");
			}

			if (data.equals(c3) && !b3) {
				b3 = true;
			} else if (data.equals(c3) && b3) {
				fail("Computer 3 found more multiple times in list");
			}

			if (data.equals(c4) && !b4) {
				b4 = true;
			} else if (data.equals(c4) && b4) {
				fail("Computer 4 found multiple times in list");
			}
		}

		if (!(b1 && b2 && b3 && b4)) {
			fail("One or more elements not found in list");
		}


	}

	@Test
	public void union03() {
		LL<Computer> testList = new LL<>();
		LL<Computer> list2 = new LL<>();

		testList.union(list2);
		assertEquals(true,testList.isEmpty());
        assertEquals(0,testList.size(),"Wrong size of resultant list");

	}


	@Test
	public void intersect01() {
		LL<Computer> testList = new LL<>();
		LL<Computer> list2 = new LL<>();

		testList.append(c5);
		testList.append(c6);
		testList.append(c7);

		list2.append(c1);
        list2.append(c2);
        list2.append(c3);

        testList.intersect(list2);

        assertEquals(0,testList.size(),"Intersection should be empty");


	}

	@Test
	public void intersect02() {
		LL<Computer> testList = new LL<>();
		LL<Computer> list2 = new LL<>();

		testList.append(c1);
		testList.append(c2);
		testList.append(c3);

		list2.append(c7);
        list2.append(c3);

        testList.intersect(list2);


        assertEquals(1,testList.size(),"Intersection size is wrong");
        assertEquals(c3,testList.getHead().getData(),"Computer 3 should be retained");

	}

	@Test
	public void intersect03() {
		LL<Computer> testList = new LL<>();
		LL<Computer> list2 = new LL<>();

		boolean b5 = false;
		boolean b6 = false;
		boolean b7 = false;

		testList.append(c1);
		testList.append(c2);
		testList.append(c3);
		testList.append(c4);
		testList.append(c5);
		testList.append(c6);
		testList.append(c7);

		list2.append(c5);
        list2.append(c6);
        list2.append(c7);

        testList.intersect(list2);
        System.out.println(testList);

        assertEquals(3,testList.size(),"Wrong size of resultant list");

        for (Node<Computer> tmp = testList.getHead(); tmp != null; tmp = tmp.getNext()) {
			Computer data = tmp.getData();
			if (data.equals(c5) && !b5) {
				b5 = true;
			} else if (data.equals(c5) && b5) {
				fail("Computer 5 found multiple times in list");
			}

			if (data.equals(c6) && !b6) {
				b6 = true;
			} else if (data.equals(c6) && b6) {
				fail("Computer 6 found multiple times in list");
			}

			if (data.equals(c7) && !b7 ) {
				b7 = true;
			} else if (data.equals(c7) && b7) {
				fail("Computer 3 found more than 2 times in list");
			}
		}

		if (!(b5 && b6 && b7)) {
			fail("One or more elements not found in list");
		}


	}

}
