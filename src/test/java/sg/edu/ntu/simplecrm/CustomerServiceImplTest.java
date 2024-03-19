package sg.edu.ntu.simplecrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceImplTest {
    
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    public void createCustomerTest() {

        // Setup
        Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("hawkeye@avengers.com").contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

        when((customerRepository.save(customer))).thenReturn(customer);

        // execute
        Customer savedCustomer = customerService.createCustomer(customer);

        // assert
        assertEquals(customer, savedCustomer, "The saved customer should be the same as the new customer");

        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void getCustomerTest() {
        // setup
        Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("hawkeye@avengers.com").contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

        Long customerId = 1L;

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        // execute
        Customer retrievedCustomer = customerService.getCustomer(customerId);

        // assert
        assertEquals(customer, retrievedCustomer);
    }

    @Test
    public void testGetCustomerNotFound() {
        Long customerId = 1L;
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(customerId));
    }
}
