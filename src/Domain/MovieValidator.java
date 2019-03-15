package Domain;

public class MovieValidator {
    public void validate(Movie movie){
        if(movie.getPrice() <= 0){
            throw new RuntimeException("Price must be a positive number");
        }
    }
}
