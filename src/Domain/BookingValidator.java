package Domain;

public class BookingValidator {

    public void validate(Booking booking){
        if(booking.getMovieId() <= 0 || booking.getDate() == null){
            throw new RuntimeException("Movie can not exists!");
        }
    }
}
