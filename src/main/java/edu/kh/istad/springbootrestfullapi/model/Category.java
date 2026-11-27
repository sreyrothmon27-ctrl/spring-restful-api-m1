package edu.kh.istad.springbootrestfullapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="m1_catagories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false,length = 30)
    private String name;

    @Column(length = 255)
    private String icon;


    @OneToMany(mappedBy = "catagory")
    private List<Product> products;

}
