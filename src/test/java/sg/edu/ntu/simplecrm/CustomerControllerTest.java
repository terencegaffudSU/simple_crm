package sg.edu.ntu.simplecrm;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Get customer by Id")
    @Test
    public void getCustomerByIdTest() throws Exception {
        // building a GET request
        RequestBuilder request = MockMvcRequestBuilders.get("/customers/1");

        // perform the request
        mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void getAllCustomers() throws Exception {
        // Step 1: Setup
        RequestBuilder request = MockMvcRequestBuilders.get("/customers");

        // Step 2: Execute and Assert
        mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.size()").value(4));
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void validCustomerCreationTest() throws Exception {
        // Step 1: Setup
        Customer newCustomer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
        .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

        String newCustomerAsJSON = objectMapper.writeValueAsString(newCustomer);

        // build request
        RequestBuilder request = MockMvcRequestBuilders.post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCustomerAsJSON);

        // eXecute and assert
        mockMvc.perform(request)
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id").value(5))
                    .andExpect(jsonPath("$.firstName").value("Clint"))
                    .andExpect(jsonPath("$.lastName").value("Barton"));
    }

    // @Test
    // public void invalidCusomterCreationTest() throws Exception {
    //     // setup
    //     // Customer invalidCustomer = new Customer(" ", " ", "brucecom", "Happy", 1200);

    //     Customer invalidCustomer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
    //     .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

    //     String invalidCustomerAsJSON = objectMapper.writeValueAsString(invalidCustomer);

    //     RequestBuilder request = MockMvcRequestBuilders.post("/customers")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(invalidCustomerAsJSON);
        
    //     // execute and assert
    //     mockMvc.perform(request)
    //             .andExpect(status().isBadRequest())
    //             .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    // }
}
