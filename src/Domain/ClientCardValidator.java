package Domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;


public class ClientCardValidator {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    public void validate(ClientCard client){
        if(client.getCnp().length() < 13 || client.getCnp().length() > 13){
            throw new RuntimeException("CNP is not valid!");
        }
        try {
            format.parse(client.getBirthDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

        try {
            format.parse(client.getRegistrationDate());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of registration is not in a correct format!");
        }
    }
}
