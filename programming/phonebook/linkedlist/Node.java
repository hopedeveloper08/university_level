package linkedlist;

import model.Person;

public class Node {
    Person person;
    Node next;

    public Node(Person person) {
        this.person = person;
        this.next = null;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "person=" + person +
                ", next=" + next +
                '}';
    }
}
