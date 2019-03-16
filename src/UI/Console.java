package UI;
import Domain.Movie;
import Domain.ClientCard;
import Domain.Booking;
import Service.MovieService;
import Service.ClientCardService;
import Service.BookingService;

import java.util.Scanner;

public class Console {
    private MovieService movieService;
    private ClientCardService clientCardService;
    private BookingService bookingService;

    private Scanner scanner;

    public Console(MovieService movieService, ClientCardService clientCardService, BookingService bookingService) {
        this.movieService = movieService;
        this.clientCardService = clientCardService;
        this.bookingService = bookingService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie CRUD");
        System.out.println("2. ClientCard CRUD");
        System.out.println("3. Booking CRUD");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runClientCardCrud();
                    break;
                case "3":
                    runBookingCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runBookingCrud() {
        while (true) {
            System.out.println("1. Add or update booking");
            System.out.println("2. Remove a booking");
            System.out.println("3. View all bookings");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateBooking();
                    break;
                case "2":
                    handleRemoveBooking();
                    break;
                case "3":
                    handleViewBookings();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewBookings() {
        for (Booking booking : bookingService.getAll()) {
            System.out.println(booking);
        }
    }

    private void handleRemoveBooking() {
        try {
            System.out.print("Enter the id to remove:");
            int id = scanner.nextInt();
            bookingService.remove(id);

            System.out.println("Transaction removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateBooking() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter movie id (empty to not change for update): ");
            int movieId = scanner.nextInt();
            System.out.print("Enter client card (empty to not change for update): ");
            int cardId = scanner.nextInt();
            System.out.print("Enter date (empty to not change for update): ");
            scanner.nextLine();
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            scanner.nextLine();
            String time = scanner.nextLine();
            System.out.println("Enter ticket price");
            double ticketPrice = scanner.nextDouble();

            Booking booking = bookingService.addOrUpdate(id, movieId, cardId, date, time, ticketPrice);
            System.out.println(String.format("Added booking id=%s, ticket price=%f, points=%s%%", booking.getId(), booking.getTicketPrice(), booking.getPoints()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCardCrud() {
        while (true) {
            System.out.println("1. Add or update a client card");
            System.out.println("2. Remove a client card");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClientCard();
                    break;
                case "2":
                    handleRemoveClientCard();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClients() {
        for (ClientCard clientCard : clientCardService.getAll()) {
            System.out.println(clientCard);
        }
    }

    private void handleRemoveClientCard() {
        try {
            System.out.print("Enter the card id to remove:");
            int id = scanner.nextInt();
            clientCardService.remove(id);

            System.out.println("Client card removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClientCard() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter last name (empty to not change for update): ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            scanner.nextLine();
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            scanner.nextLine();
            String cnp = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            scanner.nextLine();
            String birthDate = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            scanner.nextLine();
            String registrationDate = scanner.nextLine();

            clientCardService.addOrUpdate(id, name, firstName, cnp, birthDate, registrationDate);

            System.out.println("Client card added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runMovieCrud() {
        while (true) {
            System.out.println("1. Add or update a movie");
            System.out.println("2. Remove a movie");
            System.out.println("3. View all movies");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMovie();
                    break;
                case "2":
                    handleRemoveMovie();
                    break;
                case "3":
                    handleViewMovies();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewMovies() {
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
    }

    private void handleRemoveMovie() {
        try {
            System.out.print("Enter the movie id to remove:");
            int id = scanner.nextInt();
            movieService.remove(id);

            System.out.println("Movie removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateMovie() {

        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter title (empty to not change for update): ");
            scanner.nextLine();
            String title = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter in Cinema (true / false): ");
            boolean inCinema = Boolean.parseBoolean(scanner.nextLine());

            movieService.addOrUpdate(id, year, title, price, inCinema);

            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

}
