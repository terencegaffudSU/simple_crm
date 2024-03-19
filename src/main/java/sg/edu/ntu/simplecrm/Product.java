package sg.edu.ntu.simplecrm;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final String id;
    private String name;
    private String description;
    private double price;
    
    public Product() {
        this.id = UUID.randomUUID().toString(); 
    }    
}
