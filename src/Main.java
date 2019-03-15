import Domain.MovieValidator;
import Domain.ClientCardValidator;
import Domain.BookingValidator;
import Repository.MovieRepository;
import Repository.ClientCardRepository;
import Repository.BookingRepository;
import Service.MovieService;
import Service.ClientCardService;
import Service.BookingService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        MovieValidator movieValidator = new MovieValidator();
        ClientCardValidator clientCardValidator = new ClientCardValidator();
        BookingValidator transactionValidator = new BookingValidator();

        MovieRepository movieRepository = new MovieRepository(movieValidator);
        ClientCardRepository clientCardRepository = new ClientCardRepository(clientCardValidator);
        BookingRepository bookingRepository = new BookingRepository(transactionValidator);

        MovieService movieService = new MovieService(movieRepository);
        ClientCardService clientCardService = new ClientCardService(clientCardRepository);
        BookingService bookingService = new BookingService(bookingRepository, movieRepository);

        Console console = new Console(movieService, clientCardService, bookingService);
        console.run();
    }

}

