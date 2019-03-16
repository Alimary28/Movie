package Domain;

import java.util.Objects;

public class Booking {
    private int id, movieId, cardId, points;
    private String date, hour;
    private double ticketPrice;

    public Booking(int id, int movieId, int cardId, String date, String hour, double ticketPrice, int points) {
        this.id = id;
        this.movieId = movieId;
        this.cardId = cardId;
        this.date = date;
        this.hour = hour;
        this.ticketPrice = ticketPrice;
        this.points = points;
    }

    public int getPointsByTicket() {
        return (int)ticketPrice * points;
    }
    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", movieId='" + movieId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", points='" + points + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieId, cardId, date, hour, ticketPrice, points);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
