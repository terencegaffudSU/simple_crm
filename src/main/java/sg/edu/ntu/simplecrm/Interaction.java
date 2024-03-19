package sg.edu.ntu.simplecrm;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "interaction")
@Getter
@Setter
public class Interaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // at least 3 characters and at most 30 characters long
    @Size(min = 3, max = 30, message = "Remarks have to be at least 3 characters and at most 30 characters long")
    @Column(name = "remarks")
    private String remarks;

    // should not be in the future.
    @PastOrPresent(message = "Interaction Date cannot be in the future")
    @Column(name = "interaction_date")
    private LocalDate interactionDate;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    
}
