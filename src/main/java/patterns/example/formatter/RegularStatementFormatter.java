package patterns.example.formatter;

import patterns.example.customer.Customer;
import patterns.example.movie.Rental;

public class RegularStatementFormatter extends StatementFormatter {
    @Override
    protected void addRentalData(StringBuilder sb, Rental r) {
        sb.append('\t')
                .append(r.movie())
                .append('\t')
                .append(r.daysRented())
                .append('\t')
                .append(r.getRentalPrice())
                .append('\n');

    }

    @Override
    protected void addPrefix(StringBuilder sb, Customer customer) {
        sb.append("Rental Record for ")
                .append(customer.getName())
                .append('\n');
    }

    @Override
    protected void addPostfix(StringBuilder sb, double totalPrice) {
        sb.append("Amount owed is ")
                .append(totalPrice)
                .append('\n');
    }
}
