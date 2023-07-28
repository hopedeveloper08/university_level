package linkedlist;

import model.Person;

public class LinkedList {
    Node header;

    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }

    public boolean search(Person person) {
        Node h = getHeader();
        if (h != null) {
            while (h != null) {
                if (h.getPerson().equals(person)) {
                    return true;
                }
                h = h.next;
            }
        }
        return false;
    }

    public void insert(Person person) {
        Node n = new Node(person);
        Node h = getHeader();
        if (h == null) {
            this.header = n;
        } else {
            while (h.next != null) {
                h = h.next;
            }
            h.next = n;
        }
    }

    public void remove(Person person) {
        Node h = getHeader();
        if (h.getPerson().equals(person) && h.next != null) {
            setHeader(h.next);
        }
        else if (h.next == null) {
            setHeader(null);
        }
        else {
            while (h.next != null) {
                if (h.next.getPerson().equals(person)) {
                    h.setNext(h.next.next);
                    break;
                }
                h = h.next;
            }
        }
    }
}
