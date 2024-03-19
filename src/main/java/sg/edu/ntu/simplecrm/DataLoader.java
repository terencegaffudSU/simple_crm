package sg.edu.ntu.simplecrm;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
    private CustomerRepository customerRepository;

    // @Autowired
    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void loadData() {
        // clear the database first
        customerRepository.deleteAll();

        // load data here
        customerRepository.save(new Customer("Tony", "Stark", "iamironman@avengers.com", "98765432", 1979));
        customerRepository.save(new Customer("Bruce", "Banner", "bruce-banner@avengers.com", "88765432", 1978));
        customerRepository.save(new Customer("Peter", "Parker", "spide-man@avengers.com", "88865432", 2001));
        customerRepository.save(new Customer("Stephen", "Strange", "dr-strange@avengers.com", "08765432",1979));
    }
}
