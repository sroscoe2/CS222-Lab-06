package main;

public class ComputerListNode {

    private ComputerListNode next;
    private Computer item;

    public ComputerListNode(Computer item) {
        this.item = item;
        this.next = null;
    }

    public Computer getComputer() {
        return item;
    }

    public ComputerListNode getNext() {
        return next;
    }

    public void setNext(ComputerListNode next) {
        this.next = next;
    }
}
