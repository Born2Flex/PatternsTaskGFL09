package patterns.example.formatter;

import patterns.example.customer.Customer;
import patterns.example.movie.Rental;

public class HtmlStatementFormatter extends StatementFormatter {
    @Override
    protected void addRentalData(StringBuilder sb, Rental r) {
        sb.append("""
                        <div>
                            <p><strong>Movie:</strong>\s
                        """)
                .append(r.movie())
                .append("""
                         <strong>Days Rented:</strong>\s
                        """)
                .append(r.daysRented())
                .append("""
                         <strong>Price:</strong>\s
                        """)
                .append(r.getRentalPrice())
                .append("""
                        </p>
                        </div>
                        """);
    }

    @Override
    protected void addPrefix(StringBuilder sb, Customer customer) {
        sb.append("""
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Rental record for\s
                        """)
                .append(customer.getName())
                .append("""
                        </title>
                        </head>
                        <body>
                        """)
                .append("""
                        <h2>Rental Record for\s
                        """)
                .append(customer.getName())
                .append("""
                        </h2>
                                                
                        """);
    }

    @Override
    protected void addPostfix(StringBuilder sb, double totalPrice) {
        sb.append("""
                                        
                        <p><strong>Amount owed is\s
                        """)
                .append(totalPrice)
                .append("""
                        </strong></p>
                                                
                        </body>
                        </html>
                        """);
    }
}
