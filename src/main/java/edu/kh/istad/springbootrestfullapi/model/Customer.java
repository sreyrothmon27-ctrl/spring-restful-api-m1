package edu.kh.istad.springbootrestfullapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="m1_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true ,nullable = false,length = 60)
    private String email;

    @Column( unique = true, nullable = false, length = 12)
    private String phonenumber;

    @Column(nullable = false)
    private Boolean isDelate;


    @OneToOne
    private User user;
}
