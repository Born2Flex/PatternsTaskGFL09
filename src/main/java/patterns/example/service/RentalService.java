package patterns.example.service;

import patterns.example.catalog.MovieCatalog;
import patterns.example.customer.CustomerCaretaker;
import patterns.example.data.DataStore;
import patterns.example.formatter.StatementFormatter;
import patterns.example.movie.Movie;

public class RentalService {
    private StatementFormatter formatter;
    private DataStore dataStore;
    private final MovieCatalog catalog;

    public RentalService(StatementFormatter formatter, MovieCatalog catalog, DataStore dataStore) {
        this.formatter = formatter;
        this.catalog = catalog;
        this.dataStore = dataStore;
    }

    public void printStatement(CustomerCaretaker customer) {
        System.out.println(formatter.formatStatement(customer.customer()));
    }

    public void saveStatement(CustomerCaretaker customer) {
        dataStore.save(formatter.formatStatement(customer.customer()));
        System.out.println("Statement successfully saved");
    }

    public void setFormatter(StatementFormatter formatter) {
        this.formatter = formatter;
    }

    public void setDataStore(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void printMovies() {
        catalog.printAllMovies();
    }

    public void addMovie(Movie movie) {
        catalog.addMovie(movie);
    }

    public Movie findMovieByTitle(String title) {
        return catalog.findMovieByTitle(title);
    }

    public MovieCatalog getCatalog() {
        return catalog;
    }
}
