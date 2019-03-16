package Domain;

public class MovieValidator {
    public void validate(Movie movie){
        if(movie.getPrice() <= 0){
            throw new RuntimeException("Price must be a positive number");
        }
        if(movie.getYear() < 1000 || movie.getYear() > 9999){
            throw new RuntimeException("Invalid year");
        }
    }
}
