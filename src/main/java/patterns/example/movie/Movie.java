package patterns.example.movie;

public class Movie {
    private MovieType priceCode;
    private String title;
    private String origin;
    private String shortDescription;
    private String director;

    private Movie() {
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static class Builder {
        private MovieType priceCode;
        private final String title;
        private String origin;
        private String shortDescription;
        private String director;

        public Builder(MovieType priceCode, String title) {
            this.priceCode = priceCode;
            this.title = title;
        }

        public Builder priceCode(MovieType priceCode) {
            this.priceCode = priceCode;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = origin;
            return this;
        }

        public Builder shortDescription(String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder director(String director) {
            this.director = director;
            return this;
        }

        public Movie build() {
            Movie m = new Movie();
            m.priceCode = priceCode;
            m.title = title;
            m.origin = origin;
            m.shortDescription = shortDescription;
            m.director = director;
            return m;
        }
    }
}
