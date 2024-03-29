package Service;
import Domain.Movie;
import Domain.ClientCard;
import Domain.Booking;
import Repository.MovieRepository;
import Repository.ClientCardRepository;
import Repository.BookingRepository;
import java.util.List;

public class BookingService {


    private BookingRepository bookingRepository;
    private MovieRepository movieRepository;

    public BookingService(BookingRepository bookingRepository, MovieRepository movieRepository) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
    }

    public Booking addOrUpdate(int id, int movieId, int clientCardId, String date, String hour, double ticketPrice) {
        Booking existing = bookingRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (movieId == 0) {
                movieId = existing.getMovieId();
            }
            if (clientCardId == 0) {
                clientCardId = existing.getCardId();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (hour.isEmpty()) {
                hour = existing.getHour();
            }
            if (ticketPrice == 0) {
                ticketPrice = existing.getTicketPrice();
            }
        }

        Movie movieSold = movieRepository.findById(movieId);
        if (movieSold == null) {
            throw new RuntimeException("There is no movie with the given id!");
        }
        double price = movieSold.getPrice();
        double ticketPoints = 0.0;
        if (ticketPrice > 0 && movieSold.isInCinema()) {
            ticketPoints = 0.1; // 10% points from price of the ticket
        }

        Booking booking = new Booking(id, movieId, clientCardId, date, hour, price, (int)ticketPoints);
        bookingRepository.upsert(booking);
        return booking;
    }

    public void remove(int id) {
        bookingRepository.remove(id);
    }

    public List<Booking> getAll() {
        return bookingRepository.getAll();
    }

}
