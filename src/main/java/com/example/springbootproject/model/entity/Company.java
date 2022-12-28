package com.example.springbootproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String locatedCountry;
    private LocalDate createdAt;

    // relation with course
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,mappedBy = "company")
    @JsonIgnore
    private List<Course> course;

}
