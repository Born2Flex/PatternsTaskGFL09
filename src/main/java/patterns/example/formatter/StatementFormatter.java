package patterns.example.formatter;


import patterns.example.customer.Customer;
import patterns.example.movie.Rental;

public abstract class StatementFormatter {
    public String formatStatement(Customer customer) {
        StringBuilder sb = new StringBuilder();
        addPrefix(sb, customer);
        double totalPrice = 0;
        for (Rental r : customer.getRentals()) {
            totalPrice += r.getRentalPrice();
            addRentalData(sb, r);
        }
        addPostfix(sb, totalPrice);
        return sb.toString();
    }

    protected abstract void addRentalData(StringBuilder sb, Rental r);

    protected abstract void addPrefix(StringBuilder sb, Customer customer);

    protected abstract void addPostfix(StringBuilder sb, double totalPrice);
}
