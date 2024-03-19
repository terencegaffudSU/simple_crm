package sg.edu.ntu.simplecrm;

public class CustomerNotFoundException extends RuntimeException {
    CustomerNotFoundException(Long id) {
        super("Could not find customer with id: " + id);
    }
}
