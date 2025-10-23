package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Random;

import main.*;

/**
 * A JUnit test suite of test cases for the {@link ComputerList}
 * linked list implementation.
 *
 */
public class ComputerListTests {

    private ComputerList testList;

    /**
     * Initializes a new {@link ComputerList}
     */
    @BeforeEach
    public void setUp() {
        testList = new ComputerList();
    }
    
    /**
     * Check you're actually doing the assignment...
     */
    @Test
    public void noCheatingTest() {
        // Prevent hiding the list by creating on add
        testList.addToEnd(Computer.createRandomComputer());
        testList.addToEnd(Computer.createRandomComputer());
        
        Field[] fields = testList.getClass().getDeclaredFields();
        boolean collectionField = false;
        boolean nodeField = false;
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                collectionField |= field.get(testList) instanceof Collection;
            } catch (IllegalAccessException|IllegalArgumentException ignored) {}
            
            nodeField |= field.getType() == ComputerListNode.class;
        }
        assertTrue(nodeField, "You need to have at least one node in your class's objects");
        assertFalse(collectionField, "No using preexisting Collections...");
    }

    /**
     * Tests that the {@link ComputerList#getSize()} is correct after
     * inserting a new {@link Computer} with the
     * {@link ComputerList#addToStart(Computer)} method.
     */
    @Test
    public void getSizeAddToStart() {
        Computer testElement = Computer.createRandomComputer();
        for (int i = 0; i < 10; i++) {
            assertEquals(i, testList.getSize(), String.format("Added %d elements to the start of the computer list and size() returned %d", i, testList.getSize()));
            testList.addToStart(testElement);
        }
    }

    /**
     * Tests that the {@link ComputerList#getSize()} is correct after
     * inserting a new {@link Computer} with the
     * {@link ComputerList#addToEnd(Computer)} method.
     */
    @Test
    public void getSizeAddToEnd() {
        Computer testElement = Computer.createRandomComputer();
        for (int i = 0; i < 10; i++) {
            assertEquals(i, testList.getSize(), String.format("Added %d elements to the end of the computer list and size() returned %d", i, testList.getSize()));
            testList.addToEnd(testElement);
        }
    }

    /**
     * Tests that the {@link ComputerList#getSize()} is correct after
     * removing a {@link Computer} with the {@link ComputerList#remove(int)}
     * method.
     */
    @Test
    public void getSizeRemove() {
        Computer testElement = Computer.createRandomComputer();
        for (int i = 0; i < 10; i++) {
            testList.addToStart(testElement);
        }

        Random randomRemover = new Random();
        for (int i = 10; i > 0; i--) {
            assertEquals(i, testList.getSize(), String.format("Removed elements from a computer list leaving %d elements and size() returned %d", i, testList.getSize()));
            testList.remove(randomRemover.nextInt(i));
        }
    }

    /**
     * Tests that the {@link ComputerList#getSize()} is correct after
     * clearing out the list using the {@link ComputerList#clear()}
     * method.
     */
    @Test
    public void clear() {
        assertEquals(0, testList.getSize(), "Lists should start empty");
        testList.clear();
        assertEquals(0, testList.getSize(), "Clearing should empty a list");
        testList.addToEnd(Computer.createRandomComputer());
        testList.addToStart(Computer.createRandomComputer());
        testList.clear();
        assertEquals(0, testList.getSize(), "Clearing should empty a list");
    }

    /**
     * Tests that the {@link ComputerList#addToStart(Computer)} is correct.
     */
    @Test
    public void addToStart() {
        for (int i = 0; i < 10; i++) {
            Computer testElement = Computer.createRandomComputer();
            testList.addToStart(testElement);
            assertEquals(testElement, testList.getComputer(0), String.format("Added %d elements to the start of the computer list and size() returned %d", i, testList.getSize()));
        }
    }

    /**
     * Tests that the {@link ComputerList#addToEnd(Computer)} is correct.
     */
    @Test
    public void addToEnd() {
        for (int i = 0; i < 10; i++) {
            Computer testElement = Computer.createRandomComputer();
            testList.addToEnd(testElement);
            assertEquals(testElement, testList.getComputer(i), String.format("Added %d elements to the end of the computer list and size() returned %d", i, testList.getSize()));
        }
    }

    /**
     * Tests that the {@link ComputerList#remove(int)} is correct.
     */
    @Test
    public void remove() {
        Computer[] testElements = {Computer.createRandomComputer(), Computer.createRandomComputer(), Computer.createRandomComputer(),
                Computer.createRandomComputer(), Computer.createRandomComputer()};

        for (Computer c : testElements) {
            testList.addToEnd(c);
        }

        assertEquals(testElements[0], testList.getComputer(0), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[1], testList.getComputer(1), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[2], testList.getComputer(2), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[3], testList.getComputer(3), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[4], testList.getComputer(4), "remove() is causing Computers to be in an unexpected order");
        assertEquals(5, testList.getSize(), String.format("size() returned %d for a list with %d elements", testList.getSize(), 5));

        testList.remove(0);
        assertEquals(testElements[1], testList.getComputer(0), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[2], testList.getComputer(1), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[3], testList.getComputer(2), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[4], testList.getComputer(3), "remove() is causing Computers to be in an unexpected order");
        assertEquals(4, testList.getSize(), String.format("size() returned %d for a list with %d elements", testList.getSize(), 4));

        testList.remove(3);
        assertEquals(testElements[1], testList.getComputer(0), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[2], testList.getComputer(1), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[3], testList.getComputer(2), "remove() is causing Computers to be in an unexpected order");
        assertEquals(3, testList.getSize(), String.format("size() returned %d for a list with %d elements", testList.getSize(), 3));

        testList.remove(1);
        assertEquals(testElements[1], testList.getComputer(0), "remove() is causing Computers to be in an unexpected order");
        assertEquals(testElements[3], testList.getComputer(1), "remove() is causing Computers to be in an unexpected order");
        assertEquals(2, testList.getSize(), String.format("size() returned %d for a list with %d elements", testList.getSize(), 2));

        testList.remove(0);
        assertEquals(testElements[3], testList.getComputer(0), "remove() is causing Computers to be in an unexpected order");
        assertEquals(1, testList.getSize(), String.format("size() returned %d for a list with %d elements", testList.getSize(), 1));

        testList.remove(0);
        assertEquals(0, testList.getSize(), String.format("size() returned %d for a list with %d elements", testList.getSize(), 0));
    }

    /**
     * Tests that the {@link ComputerList#getComputer(int)} is correct.
     */
    @Test
    public void getComputer() {
        Computer[] testElements = {Computer.createRandomComputer(), Computer.createRandomComputer(), Computer.createRandomComputer(),
                Computer.createRandomComputer(), Computer.createRandomComputer()};

        for (Computer c : testElements) {
            testList.addToEnd(c);
        }

        assertEquals(testElements[0], testList.getComputer(0), "getComputer() is returning an unexpected element");
        assertEquals(testElements[1], testList.getComputer(1), "getComputer() is returning an unexpected element");
        assertEquals(testElements[2], testList.getComputer(2), "getComputer() is returning an unexpected element");
        assertEquals(testElements[3], testList.getComputer(3), "getComputer() is returning an unexpected element");
        assertEquals(testElements[4], testList.getComputer(4), "getComputer() is returning an unexpected element");
    }


}
