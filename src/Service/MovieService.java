package Service;
import Domain.Movie;
import Repository.MovieRepository;

import java.util.List;

public class MovieService {
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(int id, int year, String title, double price, boolean inCinema) {
        Movie existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (year == 0) {
                year = existing.getYear();
            }
            if (title.isEmpty()) {
                title = existing.getTitle();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Movie movie = new Movie(id, year, title, price, inCinema);
        repository.upsert(movie);
    }

    public void remove(int id) {
        repository.remove(id);
    }

    public List<Movie> getAll() {
        return repository.getAll();
    }


}
