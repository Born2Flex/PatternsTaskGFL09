package patterns.example.catalog;

import patterns.example.movie.Movie;

public interface MovieCatalog {
    void printAllMovies();

    void addMovie(Movie movie);

    Movie findMovieByTitle(String name);

    Movie getMovieById(int id);
}
