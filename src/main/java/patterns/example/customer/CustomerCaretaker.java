package patterns.example.customer;

import patterns.example.movie.Rental;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CustomerCaretaker {
    private final Deque<Customer.Memento> snapshots = new ArrayDeque<>();
    private final Customer curr;

    public CustomerCaretaker(String name) {
        curr = new Customer(name, new ArrayList<>());
    }

    public CustomerCaretaker(String name, List<Rental> list) {
        curr = new Customer(name, list);
    }

    public void save() {
        snapshots.push(curr.takeSnapshot());
    }

    public void restore() {
        if (!snapshots.isEmpty()) {
            curr.restore(snapshots.pop());
        }
    }

    public Customer customer() {
        return curr;
    }
}
