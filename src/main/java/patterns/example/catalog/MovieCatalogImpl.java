package patterns.example.catalog;

import patterns.example.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogImpl implements MovieCatalog {
    private final List<Movie> list = new ArrayList<>();

    public void printAllMovies() {
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + ". " + list.get(i - 1));
        }
    }

    public void addMovie(Movie movie) {
        list.add(movie);
    }

    public Movie findMovieByTitle(String name) {
        for (Movie m : list) {
            if (m.getTitle().equals(name) || m.getTitle().contains(name)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Movie getMovieById(int id) {
        return list.get(id);
    }
}
