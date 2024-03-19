package sg.edu.ntu.simplecrm;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(String id) {
        super("Could not find product with id: " + id);
    }
}
