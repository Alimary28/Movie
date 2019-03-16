package Domain;

import java.util.Objects;

public class Movie {
    private int id, year;
    private String title;
    private double price;
    private boolean inCinema;

    public Movie(int id, int year, String title, double price, boolean inCinema) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.price = price;
        this.inCinema = inCinema;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Movie movie = (Movie) obj;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, title, price);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", inCinema=" + inCinema +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInCinema() {
        return inCinema;
    }

    public void setInCinema(boolean inCinema) {
        this.inCinema = inCinema;
    }
}
