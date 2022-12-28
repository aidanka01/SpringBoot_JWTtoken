package com.example.springbootproject.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String duration;

    // relation with company
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    // relation with group
    @ManyToMany(cascade ={CascadeType.ALL},mappedBy = "courses" )
    private List<Group> groups;

    // relation with instructor
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
    private Instructor instructor;



}
