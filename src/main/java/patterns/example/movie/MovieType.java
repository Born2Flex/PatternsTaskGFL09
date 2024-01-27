package patterns.example.movie;

@FunctionalInterface
public interface MovieType {
    MovieType REGULAR = d -> {
        double amount = 2.0;
        if (d > 2) {
            amount += (d - 2) * 1.5;
        }
        return amount;
    };
    MovieType CHILDRENS = d -> {
        double amount = 1.5;
        if (d > 3) {
            amount += (d - 3) * 1.5;
        }
        return amount;
    };
    MovieType NEW_RELEASE = d -> d * 3;
    MovieType DRAMA = d -> d * 1.5;

    double calculate(int daysRented);
}
