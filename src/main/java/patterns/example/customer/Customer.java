package patterns.example.customer;

import patterns.example.movie.Rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final String name;
    private List<Rental> rentals;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public Memento takeSnapshot() {
        List<Rental> copy = new ArrayList<>();
        Collections.copy(copy, rentals);
        return new Memento(copy);
    }

    public void restore(Memento snapshot) {
        this.rentals = snapshot.rentals();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public record Memento(List<Rental> rentals) {}
}
