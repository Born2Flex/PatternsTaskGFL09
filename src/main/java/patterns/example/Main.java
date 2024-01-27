package patterns.example;

import patterns.example.catalog.MovieCatalogImpl;
import patterns.example.customer.CustomerCaretaker;
import patterns.example.data.FileDataStore;
import patterns.example.formatter.HtmlStatementFormatter;
import patterns.example.movie.Movie;
import patterns.example.movie.MovieType;
import patterns.example.movie.Rental;
import patterns.example.service.RentalService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        List<Rental> list = List.of(
//                new Rental(new Movie.Builder(MovieType.NEW_RELEASE, "Wonka").build(), 3),
//                new Rental(new Movie.Builder(MovieType.DRAMA, "Romeo and Juliet").build(), 1),
//                new Rental(new Movie.Builder(MovieType.REGULAR, "King Kong").build(), 2)
//        );
//        CustomerCaretaker customer = new CustomerCaretaker("John Doe", list);
        RentalService rentalService = new RentalService(new HtmlStatementFormatter(), new MovieCatalogImpl(), new FileDataStore("1.html"));
//        rentalService.saveStatement(customer);

        rentalService.addMovie(new Movie.Builder(MovieType.CHILDRENS, "Garfield").build());
        rentalService.addMovie(new Movie.Builder(MovieType.REGULAR, "Forest Gump").build());
        rentalService.addMovie(new Movie.Builder(MovieType.REGULAR, "King Kong").build());
        rentalService.addMovie(new Movie.Builder(MovieType.NEW_RELEASE, "Wonka").build());
        rentalService.addMovie(new Movie.Builder(MovieType.DRAMA, "Romeo and Juliet").build());

        new Main().start(rentalService);
    }
    public void start(RentalService rentalService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("REGISTRATION");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        CustomerCaretaker customer = new CustomerCaretaker(name);
        while (true) {
            System.out.println("\n===== Rental App Menu =====");
            System.out.println("1. Print Statement");
            System.out.println("2. Save Statement");
            System.out.println("3. Print Movies");
            System.out.println("4. Add Movie to catalog");
            System.out.println("5. Find Movie by Title");
            System.out.println("6. Add rental");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    printStatement(rentalService, customer);
                    break;
                case 2:
                    saveStatement(rentalService, customer);
                    break;
                case 3:
                    printMovies(rentalService);
                    break;
                case 4:
                    addMovie(rentalService, scanner);
                    break;
                case 5:
                    findMovieByTitle(rentalService, scanner);
                    break;
                case 6:
                    addRentalToCustomer(rentalService, customer, scanner);
                    break;
                case 0:
                    System.out.println("Exiting Rental App. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addRentalToCustomer(RentalService rentalService, CustomerCaretaker customer, Scanner scanner) {
        System.out.println("Available Movies:");
        rentalService.printMovies();
        System.out.print("Enter the number corresponding to the movie you want to rent: ");
        int movieChoice = scanner.nextInt();
        scanner.nextLine();
        Movie selectedMovie = rentalService.getCatalog().getMovieById(movieChoice - 1);
        System.out.print("Enter the number of days for the rental: ");
        int numberOfDays = scanner.nextInt();
        scanner.nextLine();
        Rental rental = new Rental(selectedMovie, numberOfDays);
        customer.customer().addRental(rental);
        System.out.println("Rental added successfully.");
    }

    private void printStatement(RentalService rentalService, CustomerCaretaker customer) {
        rentalService.printStatement(customer);
    }

    private void saveStatement(RentalService rentalService, CustomerCaretaker customer) {
        rentalService.saveStatement(customer);
    }

    private void printMovies(RentalService rentalService) {
        rentalService.printMovies();
    }

    private void addMovie(RentalService rentalService,Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();

        System.out.println("Choose Movie Type:");
        System.out.println("1. NEW_RELEASE");
        System.out.println("2. CHILDRENS");
        System.out.println("3. DRAMA");
        System.out.println("4. REGULAR");
        System.out.print("Enter the number corresponding to the movie type: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        MovieType movieType = switch (choice) {
            case 1 -> MovieType.NEW_RELEASE;
            case 2 -> MovieType.CHILDRENS;
            case 3 -> MovieType.DRAMA;
            default -> {
                System.out.println("Invalid choice. Defaulting to NEW.");
                yield MovieType.REGULAR;
            }
        };
        Movie movie = new Movie.Builder(movieType, title).build();
        rentalService.addMovie(movie);
        System.out.println("Movie added successfully.");
    }

    private void findMovieByTitle(RentalService rentalService, Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        Movie foundMovie = rentalService.findMovieByTitle(title);
        if (foundMovie != null) {
            System.out.println("Movie found: " + foundMovie);
        } else {
            System.out.println("Movie not found.");
        }
    }
}
